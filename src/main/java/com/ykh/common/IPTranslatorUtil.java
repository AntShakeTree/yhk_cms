package com.ykh.common;

import org.apache.log4j.Logger;
import sun.net.util.IPAddressUtil;

/**
 * IPTranslatorUtil 字符串IP地址和整数类型转换工具类
 *
 * @author Dongyu Zhang
 *         <p/>
 *         Revision History
 * @version 0.0.1
 * @if CR/PR ID Author Date Major Change
 * @endif
 * @bug
 * @see
 */

public class IPTranslatorUtil {

    /**
     * logger:log4j变量，用于本地日志的输出
     */
    private static final Logger LOGGER = Logger.getLogger(IPTranslatorUtil.class);

    /**
     * 将字符串ip（192.168.0.1）转换成正数
     *
     * @param strIp 字符串IP
     * @return long型数字
     * @code long ip = IPTranslatorUtil.ipToLong("192.168.0.1"); Syetem.out.println(ip); 输出：3232235521
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public static Long ipToLong(String strIp) {
        // 参数为空判断
        if (strIp == null || strIp.equals("")) {
            LOGGER.error("IP地址转换到Long方法调用错误，传入参数strIP为空，调用中断，直接返回NULL！");
            return null;
        }
        if (!IPAddressUtil.isIPv4LiteralAddress(strIp)) {
            LOGGER.error("[" + strIp + "]---IP地址不合法，调用中断，直接返回NULL！");
            return null;
        }
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    public static Integer ipToInteger(String strIp) {
        // 参数为空判断
        if (strIp == null || strIp.equals("")) {
            LOGGER.error("IP地址转换到Long方法调用错误，传入参数strIP为空，调用中断，直接返回NULL！");
            return null;
        }
        if (!IPAddressUtil.isIPv4LiteralAddress(strIp)) {
            LOGGER.error("[" + strIp + "]---IP地址不合法，调用中断，直接返回NULL！");
            return null;
        }
        int[] ip = new int[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Integer.parseInt(strIp.substring(0, position1));
        ip[1] = Integer.parseInt(strIp.substring(position1 + 1, position2));
        ip[2] = Integer.parseInt(strIp.substring(position2 + 1, position3));
        ip[3] = Integer.parseInt(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    /**
     * 将十进制long型数转换成字符串IP
     *
     * @param longIp long型数正整数值
     * @return String 字符串IP
     * @code Syetem.out.println(3232235521);输出：192.168.0.1
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public static String longToIP(long longIp) {

        StringBuffer sb = new StringBuffer("");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24) & 0xFF));
        return sb.toString();
    }
}