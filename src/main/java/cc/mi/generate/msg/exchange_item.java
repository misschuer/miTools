package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 兑换物品
 **/
public class exchange_item extends AbstractCoder  {
	//物品模版
	private int entry;
	//兑换数量
	private int count;
	//兑换物品模版
	private int tar_entry;

	public exchange_item() {
		super(39);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.entry);
		buffer.writeInt(this.count);
		buffer.writeInt(this.tar_entry);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.entry = buffer.readInt(); 
		this.count = buffer.readInt(); 
		this.tar_entry = buffer.readInt(); 
	}
	
	public int getEntry() {
		return this.entry;
	}
	
	public void setEntry(int entry) {
		this.entry = entry;
	}
		
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
	public int getTar_entry() {
		return this.tar_entry;
	}
	
	public void setTar_entry(int tar_entry) {
		this.tar_entry = tar_entry;
	}
		
}