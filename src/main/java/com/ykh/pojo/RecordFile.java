package com.ykh.pojo;

import java.util.List;

public class RecordFile {
    private List<String> fileList;
    private Long modifyTime;

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }


}
