package com.ykh.services.conference.util;


import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * PropertiesUtil:多tang-uc属性文件操作工具类
 *
 * @author YiChu Zhang
 *         <p/>
 *         Revision History
 * @version 0.0.1
 * @if CR/PR ID Author Date Major Change
 * @endif
 * @bug CR0001 Dongyu Zhang Sept. 20 2008 create version 0.0.1\n PR0001 Dongyu
 * @see
 */
public class BmsSiteUtil {

    private static final Logger LOGGER = Logger.getLogger(BmsSiteUtil.class);
    //zhangyichu add 2013-07-24
    private static Map<String, LinkedList<String>> siteMap = new HashMap<String, LinkedList<String>>();
    private Properties properties; // 属性对象
    private static BmsSiteUtil bmsSiteUtil = null;
    private static int index = 0; //产品对应的site项下标

    private BmsSiteUtil(String path) {
        if (null == path || "".equals(path)) {
            LOGGER.error("传入的文件路径为NULL，调用中断,手工抛出异常！");
            throw new NullPointerException("传入的文件路径为NULL");
        }
        LOGGER.info("path : " + path);
        InputStream inStream = this.getClass().getResourceAsStream(path);
        try {
            properties = new Properties();
            properties.load(inStream);
            Iterator<String> itor = properties.stringPropertyNames().iterator();
            String key = "";
            String value = "";
            String[] values = null;
            LinkedList<String> siteList = null;
            while (itor.hasNext()) {
                key = itor.next();
                values = properties.getProperty(key).split(",");
                siteList = new LinkedList<String>();
                for (int i = 0; i < values.length; i++) {
                    siteList.addFirst(values[i]);
                }
                siteMap.put(key, siteList);
            }
            LOGGER.info("BmsSiteUtil.siteMap : " + siteMap.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("未找到属性资源文件!");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("读取属性资源文件发生未知错误!");
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized BmsSiteUtil getInstance(String path) {
        if (bmsSiteUtil == null) {
            bmsSiteUtil = new BmsSiteUtil(path);
        }
        return bmsSiteUtil;
    }

    /**
     * 通过属性文件中的key，查找对应的value
     *
     * @param key 属性文件的key
     * @return key对应的value
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public String getValue(String key) {
        //移除该产品key的第一个tang.site并获得之
//			String value = siteMap.get(key).removeFirst();
//			LOGGER.info("---------------------site.value = " + value);
        //将该site放到该产品的site集的最后
//			siteMap.get(key).addLast(value);
        //返回获得的site
//			return value;

        if (index > siteMap.get(key).size() - 1) {
            index = 0;
        }
        return siteMap.get(key).get(index++);
    }

    public static void main(String[] args) {
        BmsSiteUtil bsu = BmsSiteUtil.getInstance("/applicationID_site.properties");
        for (int i = 0; i < 33; i++) {
            LOGGER.info(bsu.getValue("DEMOAPP"));
        }
    }

}
