package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 购买仙府进入券
 **/
public class buy_xianfu_item extends AbstractCoder  {
	//仙府券类型
	private byte type;
	//购买类型
	private byte indx;
	//购买数量
	private short count;

	public buy_xianfu_item() {
		super(258);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		buffer.writeByte(this.indx);
		buffer.writeShort(this.count);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.indx = buffer.readByte(); 
		this.count = buffer.readShort(); 
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public byte getIndx() {
		return this.indx;
	}
	
	public void setIndx(byte indx) {
		this.indx = indx;
	}
		
	public short getCount() {
		return this.count;
	}
	
	public void setCount(short count) {
		this.count = count;
	}
		
}