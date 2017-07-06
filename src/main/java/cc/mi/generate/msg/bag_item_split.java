package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 分割物品
 **/
public class bag_item_split extends AbstractCoder  {
	//包裹ID
	private byte bag_id;
	//切割哪个位置物品
	private short src_pos;
	//切割多少出去
	private int count;
	//切割到什么位置
	private short dst_pos;
	//切割到什么包裹
	private byte dst_bag;

	public bag_item_split() {
		super(34);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.bag_id);
		buffer.writeShort(this.src_pos);
		buffer.writeInt(this.count);
		buffer.writeShort(this.dst_pos);
		buffer.writeByte(this.dst_bag);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.bag_id = buffer.readByte(); 
		this.src_pos = buffer.readShort(); 
		this.count = buffer.readInt(); 
		this.dst_pos = buffer.readShort(); 
		this.dst_bag = buffer.readByte(); 
	}
	
	public byte getBag_id() {
		return this.bag_id;
	}
	
	public void setBag_id(byte bag_id) {
		this.bag_id = bag_id;
	}
		
	public short getSrc_pos() {
		return this.src_pos;
	}
	
	public void setSrc_pos(short src_pos) {
		this.src_pos = src_pos;
	}
		
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
	public short getDst_pos() {
		return this.dst_pos;
	}
	
	public void setDst_pos(short dst_pos) {
		this.dst_pos = dst_pos;
	}
		
	public byte getDst_bag() {
		return this.dst_bag;
	}
	
	public void setDst_bag(byte dst_bag) {
		this.dst_bag = dst_bag;
	}
		
}