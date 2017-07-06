package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 包裹操作-交换位置
 **/
public class bag_exchange_pos extends AbstractCoder  {
	//源包裹
	private int src_bag;
	//源位置
	private int src_pos;
	//目标包裹
	private int dst_bag;
	//目标位置
	private int dst_pos;

	public bag_exchange_pos() {
		super(32);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.src_bag);
		buffer.writeInt(this.src_pos);
		buffer.writeInt(this.dst_bag);
		buffer.writeInt(this.dst_pos);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.src_bag = buffer.readInt(); 
		this.src_pos = buffer.readInt(); 
		this.dst_bag = buffer.readInt(); 
		this.dst_pos = buffer.readInt(); 
	}
	
	public int getSrc_bag() {
		return this.src_bag;
	}
	
	public void setSrc_bag(int src_bag) {
		this.src_bag = src_bag;
	}
		
	public int getSrc_pos() {
		return this.src_pos;
	}
	
	public void setSrc_pos(int src_pos) {
		this.src_pos = src_pos;
	}
		
	public int getDst_bag() {
		return this.dst_bag;
	}
	
	public void setDst_bag(int dst_bag) {
		this.dst_bag = dst_bag;
	}
		
	public int getDst_pos() {
		return this.dst_pos;
	}
	
	public void setDst_pos(int dst_pos) {
		this.dst_pos = dst_pos;
	}
		
}