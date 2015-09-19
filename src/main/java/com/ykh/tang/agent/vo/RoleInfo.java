package com.ykh.tang.agent.vo;

import java.util.List;

/**
 * Struct17 RoleInfo_bms
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
public final class RoleInfo extends Struct5 {
    public int roleType = 0;
    public int maxUser = 0;

    public List<String> servPrivArr = null;

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int type) {
        this.roleType = type;
    }

    public int getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(int users) {
        this.maxUser = users;
    }

    public List<String> getServPrivArr() {
        return servPrivArr;
    }

    public void setServPrivArr(List<String> servPrivArr) {
        this.servPrivArr = servPrivArr;
    }
}
