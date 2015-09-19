package com.ykh.dao.user;

import com.ykh.dao.Dao;
import com.ykh.dao.user.domain.TempUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/27.
 */
public interface TempUserDao extends Dao<TempUser, Integer> {
//    TempUser findByUserId(Integer userId);

    List<TempUser> findByUsername(String username);
    List<TempUser> findByTempConferenceId(Integer tempConferenceId);

    Long deleteByTempConferenceId(Integer tempConfID);

    @Modifying
    @Transactional
    @Query("update TempUser u set u.status = ?2 where u.idTempUser = ?1")
    void updateStauts(int id, int status);

    TempUser findByUsernameAndDomain(String username, String domain);
}
