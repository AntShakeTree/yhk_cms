package com.ykh.dao.conference;

import com.config.TestConfig;
import com.ykh.dao.conference.domain.Conference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConferenceDaoTest {
    @Autowired ConferenceDao conferenceDao;
    @Test
    public void search(){
        Conference conference =new Conference();
        conference.setBillingcode("753053");
        conferenceDao.findPages(conference);
    }
}