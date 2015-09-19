package com.ykh.services.conference.impl;

import com.ykh.common.Session;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.services.TempUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/9/19.
 */
@Service
public class TempUserServiceImpl implements TempUserService {
    @Autowired
    TempUserDao tempUserDao;
    @Override
    public void updateStatus(int id, int status) {
        tempUserDao.updateStauts(id,status);
    }

    @Override
    public void deleteByTempConferenceId(Integer tempConfID) {
        List<TempUser> ts=tempUserDao.findByTempConferenceId(tempConfID);
        for (TempUser t:ts){
            Session.removeCache(t.getUsername());
        }
        tempUserDao.deleteByTempConferenceId(tempConfID);
    }

    @Override
    public void deleteUser(int userID) {
        tempUserDao.delete(userID);
    }
}
