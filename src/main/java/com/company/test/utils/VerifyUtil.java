package com.company.test.utils;

import java.util.Random;

/**
 * @author zhaochuanzhen
 * @desc 验证码生成
 * @since 9:01 2017/9/29
 */
public class VerifyUtil {

    /**
     * 生成6位随机数
     */
    public static String getRamdomNum() {
        Random random = new Random();
        String sRand = "";
        for (int i = 0; i < 6; i++) {
            int itmp = random.nextInt(10) + 48;
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
        }
        return sRand;
    }

}
