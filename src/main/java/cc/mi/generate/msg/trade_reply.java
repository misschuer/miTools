package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 交易请求答复
 **/
public class trade_reply extends AbstractCoder  {
	//请求交易的人guid
	private String guid;
	//0:拒绝1:接受
	private byte reply;

	public trade_reply() {
		super(82);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		buffer.writeByte(this.reply);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		this.reply = buffer.readByte(); 
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public byte getReply() {
		return this.reply;
	}
	
	public void setReply(byte reply) {
		this.reply = reply;
	}
		
}