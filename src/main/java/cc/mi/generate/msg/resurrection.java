package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 复活
 **/
public class resurrection extends AbstractCoder  {
	//0:原地复活 1:回城复活
	private byte type;
	//保留
	private long reserve;

	public resurrection() {
		super(80);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		buffer.writeLong(this.reserve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.reserve = buffer.readLong(); 
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public long getReserve() {
		return this.reserve;
	}
	
	public void setReserve(long reserve) {
		this.reserve = reserve;
	}
		
}