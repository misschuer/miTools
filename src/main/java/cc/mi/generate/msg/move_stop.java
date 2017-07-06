package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 停止移动
 **/
public class move_stop extends AbstractCoder  {
	//玩家GUID
	private int guid;
	//
	private short pos_x;
	//
	private short pos_y;

	public move_stop() {
		super(29);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeShort(this.pos_x);
		buffer.writeShort(this.pos_y);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.pos_x = buffer.readShort(); 
		this.pos_y = buffer.readShort(); 
	}
	
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
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