package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 放弃任务
 **/
public class questlog_remove_quest extends AbstractCoder  {
	//任务下标位置
	private byte slot;
	//保留
	private long reserve;

	public questlog_remove_quest() {
		super(61);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.slot);
		buffer.writeLong(this.reserve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.slot = buffer.readByte(); 
		this.reserve = buffer.readLong(); 
	}
	
	public byte getSlot() {
		return this.slot;
	}
	
	public void setSlot(byte slot) {
		this.slot = slot;
	}
		
	public long getReserve() {
		return this.reserve;
	}
	
	public void setReserve(long reserve) {
		this.reserve = reserve;
	}
		
}