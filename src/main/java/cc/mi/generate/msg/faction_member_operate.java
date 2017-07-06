package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 帮派成员操作
 **/
public class faction_member_operate extends AbstractCoder  {
	//操作类型
	private byte opt_type;
	//预留int值1
	private short reserve_int1;
	//预留int值2
	private short reserve_int2;
	//预留string值1
	private String reserve_str1;
	//预留string值2
	private String reserve_str2;

	public faction_member_operate() {
		super(186);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.opt_type);
		buffer.writeShort(this.reserve_int1);
		buffer.writeShort(this.reserve_int2);
		StringCoder.writeString(buffer, this.reserve_str1);
		StringCoder.writeString(buffer, this.reserve_str2);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.opt_type = buffer.readByte(); 
		this.reserve_int1 = buffer.readShort(); 
		this.reserve_int2 = buffer.readShort(); 
		this.reserve_str1 = StringCoder.readString(buffer);
		this.reserve_str2 = StringCoder.readString(buffer);
	}
	
	public byte getOpt_type() {
		return this.opt_type;
	}
	
	public void setOpt_type(byte opt_type) {
		this.opt_type = opt_type;
	}
		
	public short getReserve_int1() {
		return this.reserve_int1;
	}
	
	public void setReserve_int1(short reserve_int1) {
		this.reserve_int1 = reserve_int1;
	}
		
	public short getReserve_int2() {
		return this.reserve_int2;
	}
	
	public void setReserve_int2(short reserve_int2) {
		this.reserve_int2 = reserve_int2;
	}
		
	public String getReserve_str1() {
		return this.reserve_str1;
	}
	
	public void setReserve_str1(String reserve_str1) {
		this.reserve_str1 = reserve_str1;
	}
		
	public String getReserve_str2() {
		return this.reserve_str2;
	}
	
	public void setReserve_str2(String reserve_str2) {
		this.reserve_str2 = reserve_str2;
	}
		
}