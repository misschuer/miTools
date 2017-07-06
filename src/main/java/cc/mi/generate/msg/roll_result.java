package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * roll点结果
 **/
public class roll_result extends AbstractCoder  {
	//数值点
	private byte point;
	//名字
	private String name;
	//是否当前最高
	private byte isHighest;
	//服务器结束roll点时间戳
	private int timestamp;
	//rollid
	private byte rollid;

	public roll_result() {
		super(205);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.point);
		StringCoder.writeString(buffer, this.name);
		buffer.writeByte(this.isHighest);
		buffer.writeInt(this.timestamp);
		buffer.writeByte(this.rollid);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.point = buffer.readByte(); 
		this.name = StringCoder.readString(buffer);
		this.isHighest = buffer.readByte(); 
		this.timestamp = buffer.readInt(); 
		this.rollid = buffer.readByte(); 
	}
	
	public byte getPoint() {
		return this.point;
	}
	
	public void setPoint(byte point) {
		this.point = point;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public byte getIsHighest() {
		return this.isHighest;
	}
	
	public void setIsHighest(byte isHighest) {
		this.isHighest = isHighest;
	}
		
	public int getTimestamp() {
		return this.timestamp;
	}
	
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
		
	public byte getRollid() {
		return this.rollid;
	}
	
	public void setRollid(byte rollid) {
		this.rollid = rollid;
	}
		
}