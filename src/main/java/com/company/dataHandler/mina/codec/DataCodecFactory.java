package com.company.datahandler.mina.codec;

import javax.annotation.Resource;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.springframework.stereotype.Component;

@Component("dataCodecFactory")
public class DataCodecFactory implements ProtocolCodecFactory {

	@Resource(name="decoder")
	private ProtocolDecoder decoder;
	@Resource(name="encoder")
	private ProtocolEncoder encoder;
	
	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return encoder;
	}

}
