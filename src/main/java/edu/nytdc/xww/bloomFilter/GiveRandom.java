package edu.nytdc.xww.bloomFilter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class GiveRandom {
    private static final String number = "0123456789";
    private static final String low_case_character = "qwertyuiopasdfghjklzxcvbnm";
    private static final String mail_character = "@._";
    private static final String all =
            number + low_case_character + low_case_character.toUpperCase() + mail_character;

    /**
     * 部分完全随机
     *
     * @return 字符串
     */
    public static String randomString() {
        return random(randomInt(9));
    }

    /**
     * 部分完全随机
     *
     * @return 字符串
     */
    public static String randomString(int length) {
        return random(length);
    }

    /**
     * 随机生成range范围内的字符
     *
     * @param length 长度
     * @return 字符串
     */
    private static String random(int length) {
        int rangeLength = all.length();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(rangeLength);
            stringBuilder.append(all.charAt(n));
        }
        return stringBuilder.toString();
    }

    public static int randomInt(int range) {
        Random random = new Random();
        return random.nextInt(range - 1) + 1;
    }

    /**
     * 字符串转Base64
     *
     * @param s 待编码
     * @return 编码
     */
    private static String StringToBase64(String s) {
        return Arrays.toString(Base64.getEncoder().encode(s.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Base64转字符串
     *
     * @param s 待解码
     * @return 解码
     */
    private static String Base64ToString(String s) {
        return Arrays.toString(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)));
    }
}
