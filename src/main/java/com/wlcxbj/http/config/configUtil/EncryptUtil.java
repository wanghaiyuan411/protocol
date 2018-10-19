package com.wlcxbj.http.config.configUtil;

import com.google.common.hash.Hashing;
import lombok.extern.log4j.Log4j;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 验证签名工具类
 */
@Log4j
public class EncryptUtil {
    private final static String SIGN_SECRET = "secret";
    private final static String SIGN_PARAMTER = "signatrue";

    public static boolean isSignatrueLegal(Map<String, String[]> requestMap) {
        String sign = getSignBySecret(requestMap);
        log.info("sign = "+ sign);
        return requestMap.get(SIGN_PARAMTER)[0].equals(sign);
    }

    /**
     *
     * @param requestMap
     * @return
     * 拼接 k1=v1&k2=v2 用hmacsha256加密
     */

    private static String getSignBySecret(Map<String, String[]> requestMap){
        String stringStream = requestMap.entrySet().stream().filter(stringEntry -> !stringEntry.getKey().equals("sign"))
                .map(stringEntry -> stringEntry.getKey() + "=" + stringEntry.getValue()[0])
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .reduce((a,b) -> a+"&"+b)
                .map(a -> hmacBySha256(a, SIGN_SECRET))
                .orElse(null);
        log.info(stringStream);
        return requestMap.entrySet().stream().peek(e -> log.info("key =" + e.getKey() + " ,value = " + e.getValue()[0]))
                .filter(e -> !e.getKey().equals(SIGN_PARAMTER))
                .map(entry -> entry.getKey() + "=" + entry.getValue()[0])
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .reduce((a,b) -> a+"&"+b)
                .map(m -> hmacBySha256(m, SIGN_SECRET))
                .orElse(null);
    }
    private static String hmacBySha256(String msg, String key) {
        return Hashing.hmacSha256(key.getBytes()).hashBytes(msg.getBytes()).toString();
    }


}
