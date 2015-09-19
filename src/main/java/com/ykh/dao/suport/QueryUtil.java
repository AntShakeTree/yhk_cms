package com.ykh.dao.suport;

import com.maxc.rest.common.ConfigUtil;
import com.ykh.common.ParseJSON;
import com.ykh.dao.GenericsUtils;
import com.ykh.dao.PageRequest;
import com.ykh.dao.Request;
import com.ykh.dao.annotation.DaoHelper;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Sort;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * @author ant_shake_tree
 */
public class QueryUtil {

    private String hql;
    private List<Object> values;

    QueryUtil(String hql, List<Object> values) {
        super();
        this.hql = hql;
        this.values = values;
    }

    public String getHql() {
        return hql;
    }

    public List<Object> getValues() {
        return values;
    }

    /**
     * @param <T>
     * @param @param req 设定文件
     * @return void 返回类型
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws
     * @Title: getHqlByDomain
     * @Description: 获得hql
     */
    public static <T> QueryUtil getHqlByDomain(Request<T> req) {
        BeanWrapper bean = new BeanWrapperImpl(req);
        PropertyDescriptor[] pros = bean.getPropertyDescriptors();
        StringBuffer hql = new StringBuffer();
        hql.append(" from ");
        String fromname = GenericsUtils.getMethodParameterGenericsInterfaceType(req)
                .getSimpleName();
        hql.append(fromname);
        hql.append(" where ");
        List<Object> strs = new ArrayList<Object>();
        for (PropertyDescriptor propertyDescriptor : pros) {
            try {
                Method methodGetX = propertyDescriptor.getReadMethod(); // Read对应get()方法
                Method methodSet = propertyDescriptor.getWriteMethod();


                String properyName = propertyDescriptor.getName();
                if (methodGetX != null && methodSet != null) {
                    Object reValue = methodGetX.invoke(req);

                    if (reValue == null || (reValue + "").equals("")) {
                        continue;
                    }
                    DaoHelper daoHelper = methodGetX
                            .getAnnotation(DaoHelper.class);
//
                    boolean iscontinu = false;
                    if (daoHelper != null) {
                        DaoHelper.IgnoreValue ignoreValue = daoHelper.ignore();

                        switch (ignoreValue) {
                            case ZERO:
                                if (reValue instanceof Integer) {
                                    if ((int) reValue == 0) {
                                        iscontinu = true;
                                    }
                                } else if (reValue instanceof Long) {
                                    if ((long) reValue == 0) {
                                        continue;
                                    }
                                } else if (reValue instanceof Double) {
                                    if ((double) reValue == 0) {
                                        continue;
                                    }
                                } else if (reValue instanceof String) {
                                    if (Integer.parseInt(reValue + "") == 0) {
                                        continue;
                                    }
                                }
                                break;
                            case NULLCOLLECTION:
                                Collection<?> c = (Collection<?>) reValue;
                                if (c != null && c.size() <= 0) {
                                    iscontinu = true;
                                }
                                break;
                            case NONE:

                                iscontinu = true;

                                break;
                            default:
                                break;
                        }
                    }
                    if (isContainsPageProperty(properyName)) {
                        continue;
                    }
                    if (iscontinu) {
                        continue;
                    }
                    if (daoHelper != null) {
                        DaoHelper.SearchMethod searchMethod = daoHelper.searchMethod();
                        if (searchMethod != null) {
                            switch (searchMethod) {
                                case like: {
                                    strs.add("%" + reValue + "%");

                                    hql.append(" " + propertyDescriptor.getName())
                                            .append(" like ? ").append("and ");

                                    break;
                                }
                                default:
                                    break;
                            }
                        } else {
                            strs.add(reValue);
                            hql.append(" " + propertyDescriptor.getName())
                                    .append(" = ? ").append("and ");
                        }
                    } else {
                        strs.add(reValue);
                        hql.append(" " + propertyDescriptor.getName())
                                .append(" = ? ").append("and ");
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hql.append(" 1=1 ");
        if (req instanceof PageRequest) {
            Map<String, Sort.Direction> od = ((PageRequest) req).getOrders();
            if (od != null) {
                StringBuilder sb = new StringBuilder(" order by ");

                for (String key : od.keySet()) {
                    sb.append(key).append(" ").append(od.get(key)).append(",");
                }
                hql.append(sb.substring(0, sb.length() - 1));
            }
        }


        return new QueryUtil(hql.toString(), strs);
    }

    public static boolean isContainsPageProperty(String properyName) {
        String[] sts = ConfigUtil.getByKey("page.property").split(",");
        for (String string : sts) {
            if (properyName.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hql == null) ? 0 : hql.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QueryUtil other = (QueryUtil) obj;
        if (hql == null) {
            if (other.hql != null)
                return false;
        } else if (!hql.equals(other.hql))
            return false;
        String vs = checkVs();
        if (vs == null) {
            if (other.checkVs() != null)
                return false;
        } else if (!vs.equals(other.checkVs()))
            return false;
        return true;
    }

    private String checkVs() {
        return ParseJSON.toJson(this.values);
    }

    @Override
    public String toString() {
        return "QueryUtil [hql=" + hql + ", values=" + values + "]";
    }


}
