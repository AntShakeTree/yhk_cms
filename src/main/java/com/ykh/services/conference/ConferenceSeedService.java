package com.ykh.services.conference;

import com.ykh.dao.conference.domain.ConfJoinTempConf;

/**
 * Created by ant_shake_tree on 15/8/21.
 */

public interface ConferenceSeedService {
    Integer getConfTempId(Integer confId, String name);

}
