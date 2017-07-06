package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 请求跳跃
 **/
public class jump_start extends AbstractCoder  {
	//坐标x
	private short pos_x;
	//坐标x
	private short pos_y;

	public jump_start() {
		super(160);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.pos_x);
		buffer.writeShort(this.pos_y);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.pos_x = buffer.readShort(); 
		this.pos_y = buffer.readShort(); 
	}
	
	public short getPos_x() {
		return this.pos_x;
	}
	
	public void setPos_x(short pos_x) {
		this.pos_x = pos_x;
	}
		
	public short getPos_y() {
		return this.pos_y;
	}
	
	public void setPos_y(short pos_y) {
		this.pos_y = pos_y;
	}
		
}