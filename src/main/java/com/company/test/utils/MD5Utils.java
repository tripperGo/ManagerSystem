package com.company.test.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhaochuanzhen
 * @desc MD5加密
 * @since 9:01 2017/9/29
 */
public class MD5Utils {
    public static String encodeByMd5(String plainMsg) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(plainMsg.getBytes("UTF-8"));
            StringBuffer digestMsgBuf=new StringBuffer();
            byte[] digestMsgTmp=messageDigest.digest();
            for (int i=0;i<digestMsgTmp.length;i++) {
                int val = ((int) digestMsgTmp[i]) & 0xff;
                if (val < 16)
                    digestMsgBuf.append("0");
                digestMsgBuf.append(Integer.toHexString(val));
            }
            return digestMsgBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "MD5Utils ERR";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "MD5Utils ERR";
        }

    }
}
