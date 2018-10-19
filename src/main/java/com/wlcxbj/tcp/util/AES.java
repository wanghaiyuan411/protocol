package com.wlcxbj.tcp.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

/**
 * Description:
 *
 * @author yxiao
 */
@Slf4j
public class AES {

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     */
    public static byte[] encrypt(String content, String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");//"算法/模式/补码方式"
            byte[] byteContent = content.getBytes("utf-8");
            int l = byteContent.length;
            int t = l % 16;
            byte[] newByteContent;
            if (t != 0) {
                newByteContent = Arrays.copyOf(byteContent, l + 16 - t);
            } else {
                newByteContent = Arrays.copyOf(byteContent, l);
            }
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            return cipher.doFinal(newByteContent); // 加密
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            return cipher.doFinal(content); // 加密
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    //public static void main(String args[]) {
    //    String key = "T3";
    //    String password = "0123456789abcdef";
    //    byte[] bytes_Encrypt = encrypt(key, password);
    //    String encode = BaseEncoding.base64().encode(Objects.requireNonNull(bytes_Encrypt));
    //    System.out.println(encode);
    //    String string = new String(Objects.requireNonNull(decrypt(BaseEncoding.base64().decode("f3mTY1FZP2yQrHpdRekNvg=="), password)));
    //    System.out.print("解密=" + string);
    //}
}
