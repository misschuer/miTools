package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 使用元宝操作某事
 **/
public class use_gold_opt extends AbstractCoder  {
	//操作类型
	private byte type;
	//字符串
	private String param;

	public use_gold_opt() {
		super(109);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		StringCoder.writeString(buffer, this.param);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.param = StringCoder.readString(buffer);
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public String getParam() {
		return this.param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
		
}