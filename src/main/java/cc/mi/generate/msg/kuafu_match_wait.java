package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 单方跨服匹配等待
 **/
public class kuafu_match_wait extends AbstractCoder  {
	//匹配类型
	private byte type;
	//需要匹配个数
	private byte target;
	//当前匹配个数
	private byte count;
	//int参数
	private int data;
	//str参数
	private String params;

	public kuafu_match_wait() {
		super(256);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		buffer.writeByte(this.target);
		buffer.writeByte(this.count);
		buffer.writeInt(this.data);
		StringCoder.writeString(buffer, this.params);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.target = buffer.readByte(); 
		this.count = buffer.readByte(); 
		this.data = buffer.readInt(); 
		this.params = StringCoder.readString(buffer);
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public byte getTarget() {
		return this.target;
	}
	
	public void setTarget(byte target) {
		this.target = target;
	}
		
	public byte getCount() {
		return this.count;
	}
	
	public void setCount(byte count) {
		this.count = count;
	}
		
	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
		
	public String getParams() {
		return this.params;
	}
	
	public void setParams(String params) {
		this.params = params;
	}
		
}