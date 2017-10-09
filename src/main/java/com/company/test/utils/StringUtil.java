package com.company.test.utils;

/**
 * @author zhaochuanzhen
 * @desc String工具类
 * @time 9:45 2017/10/8
 */
public class StringUtil {

    /**
     * 非空校验
     * @param param
     * @return
     */
    public static boolean isEmpty(String param) {
        if (param == null || "".equals(param)) {
            return true;
        } else {
            return false;
        }
    }

}
