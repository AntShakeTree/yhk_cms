package com.ykh.dao.user.domain;

import com.alibaba.fastjson.JSON;
import com.ykh.pojo.UserServiceDTO;

import javax.persistence.*;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@Table
@Entity
public class TempUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTempUser;
    private String userGuid;
    private String domain;
    private Integer userId;
    private String username;
    private Integer clientType;
    private Integer pinCode;
    private Integer tempConferenceId;
    private int status;
    @Transient
    private boolean isJoin = false;

    public boolean isJoin() {
        return isJoin;
    }

    public void setIsJoin(boolean isJoin) {
        this.isJoin = isJoin;
    }

    @Convert(converter = UserChannelConverJson.class)
    private UserServiceDTO userChannel;


    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdTempUser() {
        return idTempUser;
    }

    public void setIdTempUser(Integer idTempUser) {
        this.idTempUser = idTempUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public static class UserChannelConverJson implements AttributeConverter<UserServiceDTO, String> {

        @Override
        public String convertToDatabaseColumn(UserServiceDTO attribute) {
            return JSON.toJSONString(attribute);
        }

        @Override
        public UserServiceDTO convertToEntityAttribute(String dbData) {
            return JSON.parseObject(dbData, UserServiceDTO.class);
        }
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserServiceDTO getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(UserServiceDTO userChannel) {
        this.userChannel = userChannel;
    }
}
