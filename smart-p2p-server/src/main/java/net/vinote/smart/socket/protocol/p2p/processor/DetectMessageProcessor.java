package net.vinote.smart.socket.protocol.p2p.processor;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.vinote.smart.socket.protocol.p2p.AbstractServiceMessageProcessor;
import net.vinote.smart.socket.protocol.p2p.Session;
import net.vinote.smart.socket.protocol.p2p.message.BaseMessage;
import net.vinote.smart.socket.protocol.p2p.message.DetectMessageReq;
import net.vinote.smart.socket.protocol.p2p.message.DetectMessageResp;

/**
 * 探测消息处理器
 *
 * @author Seer
 *
 */
public class DetectMessageProcessor extends AbstractServiceMessageProcessor {
	private Logger logger = LogManager.getLogger(DetectMessageProcessor.class);

	@Override
	public void processor(Session session, BaseMessage message) {
		DetectMessageReq msg = (DetectMessageReq) message;
		DetectMessageResp rspMsg = new DetectMessageResp(msg.getHead());
		rspMsg.setDetectMessage("探测响应消息" + msg.getHead().getSequenceID());
		try {
			session.sendWithoutResponse(rspMsg);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
	}
}
