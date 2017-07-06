package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 活动找回奖励
 **/
public class welfare_active_getback extends AbstractCoder  {
	//活动类型
	private byte id;
	//完美找回
	private byte best;
	//找回次数
	private short num;

	public welfare_active_getback() {
		super(229);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.id);
		buffer.writeByte(this.best);
		buffer.writeShort(this.num);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readByte(); 
		this.best = buffer.readByte(); 
		this.num = buffer.readShort(); 
	}
	
	public byte getId() {
		return this.id;
	}
	
	public void setId(byte id) {
		this.id = id;
	}
		
	public byte getBest() {
		return this.best;
	}
	
	public void setBest(byte best) {
		this.best = best;
	}
		
	public short getNum() {
		return this.num;
	}
	
	public void setNum(short num) {
		this.num = num;
	}
		
}