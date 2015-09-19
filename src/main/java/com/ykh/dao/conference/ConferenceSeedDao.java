package com.ykh.dao.conference;

import com.ykh.dao.Dao;
import com.ykh.dao.conference.domain.ConferenceSeed;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public interface ConferenceSeedDao extends Dao<ConferenceSeed, Integer> {
    @Query("select max(seed) from ConferenceSeed")
    Integer findMaxId();
}
