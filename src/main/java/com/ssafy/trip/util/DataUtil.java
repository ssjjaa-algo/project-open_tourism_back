package com.ssafy.trip.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class DataUtil {

    // 암호화할 때 사용할 Salt (랜덤 바이트배열)
    public static String getSalt() {
        System.out.println("getSalt 진입");
        Random random = new Random();
        byte[] salt = new byte[10];

        random.nextBytes(salt); // 난수 생성

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < salt.length; i++) {
            sb.append(String.format("%02x", salt[i]));
        }
        System.out.println("getSalt 탈출");
        return sb.toString();
    }

    // Salt 사용해서 암호화
    public static String getEncrypt(String pw, String salt) {
        System.out.println("encrypt 진입");
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // sha 256알고리즘 객체 생성

            // pw + salt문자열에 sha 256 적용
            md.update((pw+salt).getBytes());
            byte[] b = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++) { // 10진수 문자열로 변환
                sb.append(String.format("%02x", b[i]));
            }

            result = sb.toString();
            System.out.println("여기까지");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
