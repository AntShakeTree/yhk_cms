package com.ykh.dao.suport;

import com.ykh.dao.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.ykh.dao.Dao;
import com.ykh.dao.Request;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Transactional
public class DaoSupport<T,ID extends  Serializable>  extends SimpleJpaRepository<T,ID> implements Dao<T, ID> {
    private final EntityManager entityManager;
    public DaoSupport(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
    public int getCount(String hql, Object... values) {
        if (hql.contains("select")) {
            hql = hql.substring(hql.indexOf("from"));
        }
        Query q = this.entityManager.createQuery("select count(*) " + hql);
        return prepareParamlizedQuery(q, values).getFirstResult();
    }

    public void excuteNative(String hql, Object... args) {
        prepareParamlizedQuery(this.entityManager.createNativeQuery(hql), args)
                .executeUpdate();
    }

    public void excuteHql(String hql, Object... args) {
        prepareParamlizedQuery(this.entityManager.createQuery(hql), args)
                .executeUpdate();
    }
    public int getCount(String hql, List<Object> values) {
        if (hql.contains("select")) {
            hql = hql.substring(hql.indexOf("from"));
        }
        Query q = this.entityManager.createQuery("select count(*) " + hql);
        return prepareParamlizedQuery(q, values.toArray()).getFirstResult();
    }

    public List<T> findHql(String hql, Object... args) {
        return ((List<T>) prepareParamlizedQuery(
                this.entityManager.createQuery(hql), args).getResultList());
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> listRequest(Request<T> req) {
        List<T> ls = null;
        QueryUtil queryUtil = QueryUtil.getHqlByDomain(req);

        String hql = queryUtil.getHql();
        List<Object> args = queryUtil.getValues();
        Query query = entityManager.createQuery(hql);


        ls = prepareParamlizedQuery(query, args.toArray())
                .getResultList();

        return ls;
    }
    @Override
    public List<Object> findAllSql(String hql, Object... args) {
        return  prepareParamlizedQuery(this.entityManager.createNativeQuery(hql), args).getResultList();
    }
    private static Query prepareParamlizedQuery(final Query query, final Object... params) {
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


    @Override
    public T findOne(Request<T> req) {
        QueryUtil queryUtil = QueryUtil.getHqlByDomain(req);
        List<T> ls = this.findHql(queryUtil.getHql(), queryUtil.getValues().toArray());
        if (ls.size() > 0) {
            return ls.get(0);
        } else {
            return null;
        }
    }
    @Override
    public T findOne(String hql, Object... keys) {
        List<T> ls = this.findHql(hql, keys);
        if (ls.size() > 0) {
            return ls.get(0);
        } else {
            return null;
        }
    }
    @Override
    public PageVO<T> findPages(PageRequest<T> request) {
        QueryUtil queryUtil = QueryUtil.getHqlByDomain(request);
        PageView pageView=new PageView(request.getPageSize(),request.getCurrentpage());
        pageView.setTotalpage(getCount(queryUtil.getHql(), queryUtil.getValues().toArray()));
        Query query=this.entityManager.createQuery(queryUtil.getHql()).setFirstResult(pageView.getFirstResult())
                .setMaxResults(pageView.getPageSize());
        query =  prepareParamlizedQuery(query,queryUtil.getValues().toArray());
        PageVO<T> pageVO =new PageVO<>();
        pageVO.setContents(query.getResultList());
        pageVO.setPage(pageView);
        return pageVO;
    }
    public T find(ID id) {
        return this.findOne(id);
    }

}
