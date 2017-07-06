package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 跳
 **/
public class jump extends AbstractCoder  {
	//跳的对象
	private int guid;
	//目的地坐标
	private float pos_x;
	//
	private float pos_y;

	public jump() {
		super(79);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeFloat(this.pos_x);
		buffer.writeFloat(this.pos_y);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.pos_x = buffer.readFloat(); 
		this.pos_y = buffer.readFloat(); 
	}
	
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
	public float getPos_x() {
		return this.pos_x;
	}
	
	public void setPos_x(float pos_x) {
		this.pos_x = pos_x;
	}
		
	public float getPos_y() {
		return this.pos_y;
	}
	
	public void setPos_y(float pos_y) {
		this.pos_y = pos_y;
	}
		
}