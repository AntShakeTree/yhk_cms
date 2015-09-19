package com.ykh.services;

import com.ykh.dao.conference.domain.ConfJoinTempConf;

/**
 * Created by ant_shake_tree on 15/9/17.
 */
public interface ConfJoinTempConfService {
    void updateStatus(Integer tempConfID, Integer status);
    ConfJoinTempConf findConferenceByTempConfId(Integer tempConfid);

    void deleteByTempConfId(Integer tempConfID);

    void saveTempConf(ConfJoinTempConf confJoinTempConf);

    ConfJoinTempConf findByTempConfId(Integer tempConferenceID);
}
