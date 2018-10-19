package com.wlcxbj.tcp.code;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class Encoder extends ProtocolEncoderAdapter{
    /**
     * Encodes higher-level message objects into binary or protocol-specific data.
     * MINA invokes {@link #encode(IoSession, Object, ProtocolEncoderOutput)}
     * method with message which is popped from the session write queue, and then
     * the encoder implementation puts encoded messages (typically {@link IoBuffer}s)
     * into {@link ProtocolEncoderOutput}.
     *
     * @param session
     * @param message
     * @param out
     * @throws Exception if the message violated protocol specification
     */
    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        byte[] msgBody = (byte[]) message;
        IoBuffer buffer = IoBuffer.allocate(msgBody.length, false);
        buffer.put(msgBody, 0, msgBody.length);
        buffer.flip();
        out.write(buffer);
    }
}
