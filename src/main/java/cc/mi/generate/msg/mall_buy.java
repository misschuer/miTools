package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 商城购买
 **/
public class mall_buy extends AbstractCoder  {
	//商品序列号
	private int id;
	//商品数量
	private int count;
	//时效ID
	private int time;

	public mall_buy() {
		super(137);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		buffer.writeInt(this.count);
		buffer.writeInt(this.time);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.count = buffer.readInt(); 
		this.time = buffer.readInt(); 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
		
}