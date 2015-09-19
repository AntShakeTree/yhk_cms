package com.ykh.common;

import com.google.common.collect.Lists;

import java.util.List;

public class YkhUtils {

    public static List<String> getAllServicetypelist() {
        List<String> seriveTypeLists = Lists.newLinkedList();
        seriveTypeLists.add(Constants.SERVICE_AUDIO);
        seriveTypeLists.add(Constants.SERVICE_BMS);
        seriveTypeLists.add(Constants.SERVICE_CHAT);
        seriveTypeLists.add(Constants.SERVICE_DESKTOP);
        seriveTypeLists.add(Constants.SERVICE_DOCSHARE);
        seriveTypeLists.add(Constants.SERVICE_QA);
        seriveTypeLists.add(Constants.SERVICE_SURVEY);
        seriveTypeLists.add(Constants.SERVICE_WHITEBOARD);
        seriveTypeLists.add(Constants.SERVICE_VEDIO);
        return seriveTypeLists;
    }
}
