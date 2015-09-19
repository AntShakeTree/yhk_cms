package com.ykh.services;

/**
 * Created by ant_shake_tree on 15/9/13.
 */
public interface TempUserService {
    public void updateStatus(int id, int status);

    void deleteByTempConferenceId(Integer tempConfID);


    void deleteUser(int userID);
}
