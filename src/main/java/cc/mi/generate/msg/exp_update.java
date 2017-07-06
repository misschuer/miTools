package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 经验更新
 **/
public class exp_update extends AbstractCoder  {
	//改变的经验
	private int exp;
	//获得经验的类型
	private byte type;
	//VIP的经验显示
	private int vip_exp;

	public exp_update() {
		super(76);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.exp);
		buffer.writeByte(this.type);
		buffer.writeInt(this.vip_exp);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.exp = buffer.readInt(); 
		this.type = buffer.readByte(); 
		this.vip_exp = buffer.readInt(); 
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
		
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public int getVip_exp() {
		return this.vip_exp;
	}
	
	public void setVip_exp(int vip_exp) {
		this.vip_exp = vip_exp;
	}
		
}