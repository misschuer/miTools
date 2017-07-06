package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 野外死亡倒计时
 **/
public class field_death_cooldown extends AbstractCoder  {
	//原地复活类型
	private byte type;
	//时间戳或者元宝值
	private int value;
	//杀人者名字
	private String killername;
	//自动复活倒计时
	private short cooldown;
	//参数
	private String params;

	public field_death_cooldown() {
		super(136);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		buffer.writeInt(this.value);
		StringCoder.writeString(buffer, this.killername);
		buffer.writeShort(this.cooldown);
		StringCoder.writeString(buffer, this.params);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.value = buffer.readInt(); 
		this.killername = StringCoder.readString(buffer);
		this.cooldown = buffer.readShort(); 
		this.params = StringCoder.readString(buffer);
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
		
	public String getKillername() {
		return this.killername;
	}
	
	public void setKillername(String killername) {
		this.killername = killername;
	}
		
	public short getCooldown() {
		return this.cooldown;
	}
	
	public void setCooldown(short cooldown) {
		this.cooldown = cooldown;
	}
		
	public String getParams() {
		return this.params;
	}
	
	public void setParams(String params) {
		this.params = params;
	}
		
}