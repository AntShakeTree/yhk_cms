/**
 * Title: SessionDao.java
 *
 * @Package com.crawler.dao
 * : SessionDao.java
 * @author david
 * @date 2013-2-3 上午3:16:39
 * @version
 */
package com.ykh.dao.user;


import com.ykh.dao.Dao;
import com.ykh.dao.user.domain.Session;

import javax.transaction.Transactional;

/**
 * ClassName: SessionDao 
 * :  
 * @author david
 * @date 2013-2-3 上午3:16:39 
 *
 */
@Transactional
public interface SessionDao extends Dao<Session, Integer> {

}
