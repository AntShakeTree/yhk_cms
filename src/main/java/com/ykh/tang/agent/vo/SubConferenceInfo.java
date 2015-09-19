package com.ykh.tang.agent.vo;

import java.util.List;

/**
 * Struct18
 *
 * @author Dongyu Zhang
 *         <p/>
 *         Revision History
 * @version 0.0.1
 * @if CR/PR ID Author Date Major Change
 * @endif
 * @bug CR0001 Dongyu Zhang Sept. 20 2008 create version 0.0.1\n PR0001 Dongyu
 * Zhang Sept. 20 2008 create version 0.0.2\n PR0002 Dongyu Zhang Sept. 20
 * 2008 create version 0.1.1\n
 * @see
 */
public final class SubConferenceInfo extends Struct5 {
    public List<RoleInfo> roleInfoArr = null; // roleInfo

    public List<String> serviceConfigArr = null; // serviceConfigs

    public List<RoleInfo> getRoleInfoArr() {
        return roleInfoArr;
    }

    public void setRoleInfoArr(List<RoleInfo> roleInfoArr) {
        this.roleInfoArr = roleInfoArr;
    }

    public List<String> getServiceConfigArr() {
        return serviceConfigArr;
    }

    public void setServiceConfigArr(List<String> serviceConfigArr) {
        this.serviceConfigArr = serviceConfigArr;
    }
}
