package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 操作失败
 **/
public class operation_failed extends AbstractCoder  {
	//操作类型
	private short type;
	//失败原因
	private short reason;
	//预留参数
	private String data;

	public operation_failed() {
		super(6);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.type);
		buffer.writeShort(this.reason);
		StringCoder.writeString(buffer, this.data);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readShort(); 
		this.reason = buffer.readShort(); 
		this.data = StringCoder.readString(buffer);
	}
	
	public short getType() {
		return this.type;
	}
	
	public void setType(short type) {
		this.type = type;
	}
		
	public short getReason() {
		return this.reason;
	}
	
	public void setReason(short reason) {
		this.reason = reason;
	}
		
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
		
}