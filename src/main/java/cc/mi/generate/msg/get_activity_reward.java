package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 活跃度奖励
 **/
public class get_activity_reward extends AbstractCoder  {
	//礼包序号
	private byte id;
	//vip奖励
	private byte vip;

	public get_activity_reward() {
		super(218);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.id);
		buffer.writeByte(this.vip);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readByte(); 
		this.vip = buffer.readByte(); 
	}
	
	public byte getId() {
		return this.id;
	}
	
	public void setId(byte id) {
		this.id = id;
	}
		
	public byte getVip() {
		return this.vip;
	}
	
	public void setVip(byte vip) {
		this.vip = vip;
	}
		
}