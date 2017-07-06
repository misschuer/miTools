package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 设置攻击模式
 **/
public class set_attack_mode extends AbstractCoder  {
	//模式
	private byte mode;
	//保留
	private long reserve;

	public set_attack_mode() {
		super(73);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.mode);
		buffer.writeLong(this.reserve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.mode = buffer.readByte(); 
		this.reserve = buffer.readLong(); 
	}
	
	public byte getMode() {
		return this.mode;
	}
	
	public void setMode(byte mode) {
		this.mode = mode;
	}
		
	public long getReserve() {
		return this.reserve;
	}
	
	public void setReserve(long reserve) {
		this.reserve = reserve;
	}
		
}