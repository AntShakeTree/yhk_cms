//package com.ykh.services.helper;
//
//
//import com.maxc.rest.common.Utils;
//import com.ykh.dao.user.TempUserDao;
//import com.ykh.dao.user.domain.TempUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by ant_shake_tree on 15/9/17.
// */
//@Component
//public class TempUserIdGenerateHelper {
//    @Autowired
//    TempUserDao tempUserDao;
//
//    public int geneate(String username) {
//        int k = (int) (Utils.hashCode( username));
//        TempUser tempUser = tempUserDao.find(k);
//        if (tempUser != null) {
//            k = (int) Utils.hashCode(Utils.nextSessionId());
//        }
//        return k;
//    }
//}
