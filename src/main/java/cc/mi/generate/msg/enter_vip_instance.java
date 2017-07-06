package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 请求进入vip副本
 **/
public class enter_vip_instance extends AbstractCoder  {
	//vip副本序号id
	private short id;
	//vip副本难度
	private byte hard;

	public enter_vip_instance() {
		super(161);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.id);
		buffer.writeByte(this.hard);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readShort(); 
		this.hard = buffer.readByte(); 
	}
	
	public short getId() {
		return this.id;
	}
	
	public void setId(short id) {
		this.id = id;
	}
		
	public byte getHard() {
		return this.hard;
	}
	
	public void setHard(byte hard) {
		this.hard = hard;
	}
		
}