package com.ykh.services.conference.impl;

import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.ConferenceSeed;
import com.ykh.services.conference.ConferenceSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Component
public class ConferenceSeedServiceImpl implements ConferenceSeedService {
    @Autowired
    ConferenceSeedDao conferenceSeedDao;

    @Override
    public synchronized Integer getConfTempId(Integer confId, String name) {
        ConferenceSeed conferenceSeed = new ConferenceSeed(confId, name);

        Integer max = conferenceSeedDao.findMaxId();

        if (max != null && (max >= Integer.MAX_VALUE - 1)) {
            conferenceSeedDao.excuteNative("truncate Table conference_seed");
        }
        conferenceSeedDao.save(conferenceSeed);
        int seed = conferenceSeed.getSeed();
        return seed << 16;
    }

}
