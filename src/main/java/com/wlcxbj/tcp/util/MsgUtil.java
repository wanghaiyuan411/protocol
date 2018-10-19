package com.wlcxbj.tcp.util;

import com.google.common.io.BaseEncoding;
import com.wlcxbj.tcp.entity.MsgWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import java.util.Arrays;

/**
 * Description:
 *
 * @author yxiao
 */
@Slf4j
public class MsgUtil {

    private static final String ENCRYPT_SIGN = "SV";

    public static boolean isEncrypt(String version) {
        return version != null && version.startsWith(ENCRYPT_SIGN);
    }

    /**
     * @param message 字符串报文
     * @return MsgWrapper
     */
    public static MsgWrapper unPack(String message) {
        String[] split = message.split(ConstantAPI.SEPRATOR, -1);
        if (split.length < 6) {
            throw new IllegalArgumentException("Message format error(the length is less than 6):" + message);
        }
        int i = 0;
        MsgWrapper msg = new MsgWrapper();
        msg.setDate(split[i++]);
        msg.setTtype(split[i++]);
        //version
        String version = split[i++];
        if (StringUtils.isEmpty(version)) {
            throw new IllegalArgumentException("Message format error(version not found):" + message);
        }
        msg.setVersion(version);
        //serial
        String serial = split[i++];
        if (StringUtils.isEmpty(serial)) {
            throw new IllegalArgumentException("Message format error(Serial not found):" + message);
        }
        msg.setSerilId(serial);
        //msgId
        msg.setMsgId(split[i++]);
        if (isEncrypt(version)) {
            String secret = getSecretBySerial(serial);
            byte[] decrypt = AES.decrypt(BaseEncoding.base64().decode(split[i]), secret);
            if (decrypt == null) {
                throw new IllegalArgumentException("Get null decrypt byte arrays:" + message);
            }
            String[] tempBody = null;//Utf8.decode(decrypt).trim().split(ConstantAPI.SEPRATOR, -1);
            msg.setMsgType(tempBody[0]);
            if (tempBody.length > 1) {
                msg.setBody(Arrays.copyOfRange(tempBody, 1, tempBody.length));
            }
        } else {
            msg.setMsgType(split[i++]);
            if (split.length > i) {
                msg.setBody(Arrays.copyOfRange(split, i, split.length));
            }
        }
        return msg;
    }

    /*public static String makeResponseMsg(MsgResponse response) {
        if (StringUtils.isEmpty(response.getMsgId()) || StringUtils.isEmpty(response.getRespType())) {
            throw new IllegalArgumentException("msgId and respType can not be empty:" + response);
        }
        if (response.getMsgDate() == null) {
            response.setMsgDate("");
        }
        StringBuilder responseContent = new StringBuilder();
        responseContent.append("[");
        responseContent.append(response.getMsgDate());
        responseContent.append(CodecUtils.SEPRATOR);
        responseContent.append(response.getMsgId());
        responseContent.append(CodecUtils.SEPRATOR);
        if (response.isEncrypt()) {
            String secret = getSecretBySerial(response.getSerial());
            if (StringUtils.isNotEmpty(secret)) {
                String toEncrypt = response.getRespType();
                if (StringUtils.isNotEmpty(response.getParams())) {
                    toEncrypt += CodecUtils.SEPRATOR + response.getParams();
                }
                String encode = BaseEncoding.base64().encode(Objects.requireNonNull(AES.encrypt(toEncrypt, secret)));
                responseContent.append(encode);
                responseContent.append("]");
                return responseContent.toString();
            }
        }
        responseContent.append(response.getRespType());
        if (StringUtils.isNotEmpty(response.getParams())) {
            responseContent.append(CodecUtils.SEPRATOR);
            responseContent.append(response.getParams());
        }
        responseContent.append("]");
        return responseContent.toString();
    }*/

    /**
     * 通过serial查询其secret
     *
     * @param serial serial
     * @return secret
     */
    private static String getSecretBySerial(String serial) {
        //TODO
        return "0123456789abcdef";
    }
}
