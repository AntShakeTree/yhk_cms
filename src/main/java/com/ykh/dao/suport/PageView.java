package com.ykh.dao.suport;

public class PageView {
    private int totalpage = 1;
    private int pageSize = 15;
    private int currentpage = 1;
    private int totalrecord;
    private int pagecode = 10;

    public int getFirstResult() {
        return (this.currentpage - 1) * this.pageSize;
    }

    public int getPagecode() {
        return pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    public PageView(int pageSize, int currentpage) {
        this.pageSize = pageSize;
        if (currentpage < 1) {
            this.currentpage = 1;
        } else {
            this.currentpage = currentpage;
        }
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
        int tp = this.totalrecord / this.pageSize;
        int mod = this.totalrecord % this.pageSize;
        setTotalpage(mod == 0 ? tp : tp + 1);
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentpage() {
        return currentpage;
    }
}
