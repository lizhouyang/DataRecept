package com.company.dataHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端消息处理类
 * @author welcome
 *
 */
public class HelloClientHandler implements IoHandler {

	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
//		cause.printStackTrace();
	}

	public void inputClosed(IoSession session) throws Exception {

	}

	/**
	 * 处理从服务端或控制台输入的消息
	 */
	public void messageReceived(IoSession session, Object message) throws Exception {
		
		if(message!=null){//接受服务端返回的消息
			String	printmsg = "服务端应答:" +message.toString();
			System.out.println(printmsg);
		}
		//session.write(msg);
	}

	public void messageSent(IoSession session, Object message) throws Exception {
	}

	public void sessionClosed(IoSession session) throws Exception {

	}

	//创建会话
	public void sessionCreated(IoSession session) throws Exception {
		
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	}

	//会话建立并打开时调用。第一次建立连接的时候
	public void sessionOpened(IoSession session) throws Exception {
		String message = "%,03,00EB,J,0047,00DF,02,14121419,00000EAE00000EBB00000EBE00000EC000000EBE00000F2200000F9600000F9300000F8B00000F8900000F9000000F9100000F8E,00000C4A00000C4600000C4600000C4A00000C4B00000C9200000CD600000CDC00000CD100000CD400000CDE00000CE100000CD9,5376#";
		session.write(message);
	}

}
