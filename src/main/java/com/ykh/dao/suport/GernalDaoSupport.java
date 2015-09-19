package com.ykh.dao.suport;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GernalDaoSupport {
    @PersistenceContext
    private EntityManager entityManager;

    public List<?> find(String hql, Object... params) {
        Query query = entityManager.createQuery(hql);
        prepareParamlizedQuery(query, params);
        return query.getResultList();
    }

    public Query prepareParamlizedQuery(final Query query,
                                        final Object... params) {
        if (params == null) {
            return query;
        }
        int i = 0;

        for (Object param : params) {
            if (param == null) {
                continue;
            }
            query.setParameter(++i, param);
        }
        return query;
    }

    //	public List<?> findSql(String hql,Object... params){
//		Query query = entityManager.createNativeQuery(sqlString, resultClass);
//		prepareParamlizedQuery(query, params);
//		return query.getResultList();
//	}
    public EntityManager getEntityManager() {
        return entityManager;
    }


}
