package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;

/**
 * unit对象移动
 **/
public class unit_move extends AbstractCoder  {
	//怪物GUID
	private int guid;
	//
	private short pos_x;
	//
	private short pos_y;
	//路线
	private List<Byte> path;

	public unit_move() {
		super(30);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeShort(this.pos_x);
		buffer.writeShort(this.pos_y);
		buffer.writeShort(this.path.size());
		for (byte element : this.path) {
			buffer.writeByte(element);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.pos_x = buffer.readShort(); 
		this.pos_y = buffer.readShort(); 
		int size = buffer.readUnsignedShort();
		this.path = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			byte element = buffer.readByte();
			this.path.add(element);
		}
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
		
	public List<Byte> getPath() {
		return this.path;
	}
	
	public void setPath(List<Byte> path) {
		this.path = path;
	}
	
}