package com.company.datahandler.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;

@Component("dataReceptHandler")
public class DataReceptHandler extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("服务端收到数据："+message.toString());
        session.write(message);
    }
	/**
	 * 返回已连接的客户端总数
	 * @return
	 */
	public Integer getNumberOfUsers(){
		return null;
	}
	/**
	 * 把客户踢出会话
	 * @param client
	 */
	public void kick(String name) {
		
    }
}
