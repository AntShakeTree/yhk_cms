package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 9 from chao.li
 *
 * @author xianchao.ji
 */
public class SubConfInfo {
    List<String> roleInfoArr;
    List<String> configArr;

    public List<String> getRoleInfoArr() {
        return roleInfoArr;
    }

    public void setRoleInfoArr(List<String> roleInfoArr) {
        this.roleInfoArr = roleInfoArr;
    }

    public List<String> getConfigArr() {
        return configArr;
    }

    public void setConfigArr(List<String> configArr) {
        this.configArr = configArr;
    }
}
