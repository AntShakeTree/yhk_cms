package com.ykh.tang.agent.vo;

import java.util.List;

public class AutoStopParams {
    List<String> roles;
    int time1;
    boolean stopwhenoneuser;
    int time2;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getTime1() {
        return time1;
    }

    public void setTime1(int time1) {
        this.time1 = time1;
    }

    public boolean getStopwhenoneuser() {
        return stopwhenoneuser;
    }

    public void setStopwhenoneuser(boolean stopwhenoneuser) {
        this.stopwhenoneuser = stopwhenoneuser;
    }

    public int getTime2() {
        return time2;
    }

    public void setTime2(int time2) {
        this.time2 = time2;
    }
}
