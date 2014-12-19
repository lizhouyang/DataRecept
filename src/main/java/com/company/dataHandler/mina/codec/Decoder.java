package com.company.datahandler.mina.codec;


import java.nio.charset.Charset;
import java.util.zip.CRC32;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.springframework.stereotype.Component;

import com.company.datahandler.utils.CRC16;

@Component("decoder")
public class Decoder implements ProtocolDecoder {

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		//TODO 会不会存在粘包现象？
		if(in.remaining()>10){
			//定义一个跟数据同样长度的字节数组
			byte[] m=new byte[in.limit()];
			//将数据都读到字节数组
			in.get(m);
			//将字节数据串成字符串
			String msg=new String(m, Charset.forName("US-ASCII"));
			System.out.println(msg);
			String[] msgArray= StringUtils.split(msg,',');
			if (msg.isEmpty()) {
				throw new Exception();
			}
			//TODO 以下并未进行ArrayIndexOutOfBoundsException检测
			//检测第一个字符
			if(!StringUtils.equals(msgArray[0],"%")){
				throw new Exception();
			}
			//检测是否下位机发回
			if(StringUtils.equals(msgArray[1], "02")){
				throw new Exception();
			}
			//求得包长度
			int packageLength=0;
			if(StringUtils.isNumeric(msgArray[2])){
				packageLength=Integer.parseInt(msgArray[2], 16);
			}
			//判断包的长度和CRC校验
			if(packageLength>0){
				//重置读取位置
				in.rewind();
				//读取数据包
				byte[] dataPack=new byte[packageLength];
				in.get(dataPack);
				//得到CRC的字符串
				String correctCRC=CRC16.getCrcHexString(dataPack);
				String dataCRC=msgArray[msgArray.length-1];
				//判断CRC是否相等
				if(StringUtils.equals(correctCRC, dataCRC)){
					//CRC校验通过，开始解析
					
				}else {
					throw new Exception();
				}
			}
		}
	}

	@Override
	public void dispose(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
