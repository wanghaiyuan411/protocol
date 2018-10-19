package com.wlcxbj.tcp.code;

import com.wlcxbj.tcp.util.ConstantAPI;
import com.wlcxbj.tcp.util.MsgUtil;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class Decode extends CumulativeProtocolDecoder {
    /**
     * Implement this method to consume the specified cumulative buffer and
     * decode its content into message(s).
     *
     * @param session
     * @param in      the cumulative buffer
     * @param out
     * @return <tt>true</tt> if and only if there's more to decode in the buffer
     * and you want to have <tt>doDecode</tt> method invoked again.
     * Return <tt>false</tt> if remaining data is not enough to decode,
     * then this method will be invoked again when more data is cumulated.
     * @throws Exception if cannot decode <tt>in</tt>.
     */
    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) {
        int limit = ConstantAPI.MAXLEN;
        if (in.remaining() > limit) {
            in.clear();
            //log.error("Message length error exceeded " + limit);
            throw new IllegalArgumentException("Message exceeded maximum length " + limit);
        }

        boolean dataCurrent = false;
        // 如果消息内容不够,则重置到这mark处
        in.mark();
        byte start = in.get();
        int index = 0;
        if (start == ConstantAPI.BYTE_START_FLAG) {
            byte[] buff = new byte[limit];
            byte end;
            while (in.hasRemaining()) {
                end = in.get();
                if (end == ConstantAPI.BYTE_END_FLAG) {
                    dataCurrent = true;
                    break;
                } else {
                    buff[index++] = end;
                }
            }
            if (dataCurrent) {
                String decodeMsg = new String(buff, 0, index);
                //log.info("Received msg=[{}],length={},address=[{}]", decodeMsg, index, session.getRemoteAddress());
                out.write(MsgUtil.unPack(decodeMsg));
                // 这里有两种情况1：没数据了，那么就结束当前调用，有数据就再次调用
                return true;
            } else {
                // 如果消息内容不够，则重置，相当于不读取size
                in.reset();
                // 接收新数据，以拼凑成完整数据
                return false;
            }
        } else {
            //不是以[ 开头，两种情况，1.断包 2.其他非法请求
            //find [
            while (in.hasRemaining()) {
                in.mark();
                start = in.get();
                if (start == ConstantAPI.BYTE_START_FLAG) {
                    //找到[,
                    dataCurrent = true;
                    break;
                }
            }
            if (dataCurrent) {
                //找到[ ,从[ 开始重新接收
                in.reset();
                return false;
            } else {
                //没有【，非法请求，丢弃
                return true;
            }
        }
    }
}
