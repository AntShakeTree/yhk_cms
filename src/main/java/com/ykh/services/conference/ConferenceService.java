package com.ykh.services.conference;

import com.ykh.dao.Dao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.pojo.User;
import com.ykh.pojo.UserServiceDTO;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;

public interface ConferenceService {
    /**
     * 单独的创建会议方法，创建会议后没有获得接入和传输信息（此时没有用户加入），创建后会议处于挂起状态。 提供给会议监控调用，暂未实现。
     * <p/>
     * <p/>
     * 适用条件：会议已经预约，没有创建，没有用户加入（创建一场没有用户的会议）
     * <p/>
     * 执行流程：Tang应用传入要已经预约的会议ID；会议管理创建临时会议ID（32位编码，包含主子会议逻辑）；
     * 会议管理保存预约ID和临时会议ID关系到cdrconferenceinfo表，同时保留在内存，动态更新。
     * 会议管理通过从数据库获得会议具体服务值信息，构建32位二进制编码，转换成整型；
     * 会议管理调用内总线接口，传递临时会议ID和转换后的整形编码（会议服务编码）给业务管理。
     * <p/>
     * 使用方法：服务暴露外部接口，调用者需要通过消息传入预约会议ID，服务返回创建成功与否。
     * <p/>
     * 注意事项：会议的具体服务值信息通过32为二进制码表示，具体编码值和业务管理协议。
     * 临时会议ID（32位二进制）的生成遵从一定的业务规则——前24位代表主会ID，后八位代表子会ID。 该方法创建会议后，会议没有启动。
     *
     * @param conference 会议标识
     * @return boolean 返回是否创建成功
     * @throws Exception 抛出异常
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public ConferenceInfoBMS createConference(Conference conference)
            throws RuntimeException;

    /**
     * 停止会议，没有释放会议资源
     *
     * @param applicationID    应用ID
     * @param tempConferenceID 临时会议ID
     * @return
     * @throws Exception
     */
    public Boolean stopConference(String applicationID, Integer tempConferenceID)
            throws RuntimeException;

    /**
     * 会议删除，提供给会议监控使用，释放所有会议资源
     *
     * @param conferenceID 临时会议ID
     * @return 返回是否成功关闭会议
     * @throws Exception 抛出异常
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    // @Override
    public Boolean deleteConference(String applicationID, Integer conferenceID)
            throws RuntimeException;

    /**
     * 查询指定会议的在会用户数，动态
     *
     * @param tempConfID 临时会议ID
     * @return
     * @throws Exception
     */
    public Integer queryUserNum(Integer tempConfID)
            throws Exception;

    /**
     * 直接启动一个会议
     * <p/>
     * 用户信息
     *
     * @param tempConferenceID 临时会议ID
     * @return
     * @throws Exception
     */
    public Boolean startConference(Integer tempConferenceID) throws RuntimeException;

    /**
     * 用户加入--用户使用
     *
     * @param applicationID
     * @param tempConferenceID
     * @param user
     * @return
     * @throws Exception
     */
    public UserChannel joinConference(String applicationID,
                                      Integer tempConferenceID, User user) throws Exception;

    /**
     * 实时会议创建后，用户发起轮询请求，根据临时会议ID查询会议状态信息
     *
     * @param applicationID 应用ID
     * @param tempConfID    临时会议ID
     * @return
     * @throws Exception
     */
    public ConfJoinTempConf getConferenceInfo(String applicationID, Integer tempConfID,Integer confId);
    /**
     * 根据临时会议ID和临时用户ID查询该用户在该会议中的状态
     *
     * @param applicationID 应用ID
     * @param tempConfID    临时会议ID
     * @param username    临时用户ID
     * @return
     * @throws Exception
     */
    public UserConferenceStatus getUserConferenceStatus(String applicationID, Integer tempConfID,
                                                        String username) ; /**
     * 根据临时会议ID和临时用户ID查询该用户在该会议中的状态
     *
     * @param applicationID 应用ID
     * @param tempConfID    临时会议ID
     * @param userId    临时用户ID
     * @return
     * @throws Exception
     */
    public UserConferenceStatus getUserConferenceStatus(String applicationID, Integer tempConfID,
                                                        Integer userId) ;

    /**
     * 创建临时会议，生成一个临时会议ID，向BMS发送create with out user命令，记录一个会议cdr 创建会议时需要考虑并发
     *
     * @param applicationID 应用ID
     * @param billingCode   计费代码
     * @return 临时会议ID（会议对象）
     * @throws Exception
     */
    public Integer createConference(String applicationID, String billingCode)
            throws Exception;

    /**
     * 初始化一场预约会议。
     * 将会创建一场BMS会议，往ConfJoinTempConf、Cdrconferenceinfo、Router表中各插入一条数据。
     *
     * @param applicationID 应用ID
     * @param conferenceID  预约会议ID，需要是预约出来的会议ID，而不是开通出来的ID
     * @return 临时会议ID（会议对象）
     * @throws Exception
     */
    public Integer initConference(String applicationID, Integer conferenceID)
            throws Exception;

    void openConference(Conference conference);

    Conference modifyConference(Conference conference);

    UserServiceDTO userJoinConference(User request);

    public Dao.PageVO<Conference> searchConference(Conference conference);

    UserServiceDTO startConferecneWithUser(Integer conferenceId, User request);

    public UserServiceDTO startConferenceWithUser(User request);
}
