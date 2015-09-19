package com.ykh.services.conference.impl;

import com.ykh.common.Session;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.services.ConfJoinTempConfService;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ant_shake_tree on 15/9/17.
 */
@Service
public class ConfJoinTempConfServiceImpl implements ConfJoinTempConfService {
    @Autowired
    ConfJoinTempConfDao confJoinTempConfDao;

    @Autowired
    ICMSAgentInterface icmsAgent;
    @Override
    public void updateStatus(Integer tempConfID, Integer status) {
        ConfJoinTempConf confJoinTempConf = (ConfJoinTempConf)Session.getCache(tempConfID);
        confJoinTempConf.setStatus(status);
        Session.setCache(tempConfID, status);
//        confJoinTempConfDao.save(confJoinTempConf);
        confJoinTempConfDao.excuteHql("update ConfJoinTempConf set status=? where  tempConfId=? ",status,tempConfID);

    }

    @Override
    public ConfJoinTempConf findConferenceByTempConfId(Integer tempConfid) {
        if(Session.containsKey(tempConfid)){
            return  (ConfJoinTempConf)Session.getCache(tempConfid);
        }else
        return confJoinTempConfDao.findByTempConfId(tempConfid);
    }

    @Override
    public void deleteByTempConfId(Integer tempConfID) {
        confJoinTempConfDao.deleteByTempConfId(tempConfID);
    }

    @Override
    public void saveTempConf(ConfJoinTempConf confJoinTempConf) {
        Session.setCache(confJoinTempConf.getTempConfId(),confJoinTempConf);
        confJoinTempConfDao.save(confJoinTempConf);
    }

    @Override
    public ConfJoinTempConf findByTempConfId(Integer tempConferenceID) {
        ConfJoinTempConf confJoinTempConf=(ConfJoinTempConf)Session.getCache(tempConferenceID);
        if(confJoinTempConf==null){
//            ConfJoinTempConf confJoinTempConf = new ConfJoinTempConf.Bulider().status(1).billingcode(conference.getBillingcode()).startTime(new Date()).tempConfId(tempConferenceID).conferenceId(conference.getConferenceId()).create();
            ConfJoinTempConf confJoinTempConf1 =confJoinTempConfDao.findByTempConfId(tempConferenceID);
            ConferenceInfoBMS conferenceInfoBMS= icmsAgent.getConfInfo(Consts.site, tempConferenceID);
            if(confJoinTempConf1!=null){
                confJoinTempConf1.setStatus(conferenceInfoBMS.getStatus());
                Session.setCache(tempConferenceID, confJoinTempConf1);
                confJoinTempConfDao.excuteHql("update ConfJoinTempConf set status=? where  tempConfId=? ",conferenceInfoBMS.getStatus(),tempConferenceID);
            }
            return confJoinTempConf1;
        }
        return  confJoinTempConf;
    }
}
