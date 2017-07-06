package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 战利品拾取
 **/
public class loot_select extends AbstractCoder  {
	//x
	private short x;
	//y
	private short y;

	public loot_select() {
		super(122);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.x);
		buffer.writeShort(this.y);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.x = buffer.readShort(); 
		this.y = buffer.readShort(); 
	}
	
	public short getX() {
		return this.x;
	}
	
	public void setX(short x) {
		this.x = x;
	}
		
	public short getY() {
		return this.y;
	}
	
	public void setY(short y) {
		this.y = y;
	}
		
}