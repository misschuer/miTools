package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 包裹操作-销毁物品
 **/
public class bag_destroy extends AbstractCoder  {
	//物品guid
	private String item_guid;
	//数量（预留）
	private int num;
	//包裹ID
	private int bag_id;

	public bag_destroy() {
		super(33);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.item_guid);
		buffer.writeInt(this.num);
		buffer.writeInt(this.bag_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.item_guid = StringCoder.readString(buffer);
		this.num = buffer.readInt(); 
		this.bag_id = buffer.readInt(); 
	}
	
	public String getItem_guid() {
		return this.item_guid;
	}
	
	public void setItem_guid(String item_guid) {
		this.item_guid = item_guid;
	}
		
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
		
	public int getBag_id() {
		return this.bag_id;
	}
	
	public void setBag_id(int bag_id) {
		this.bag_id = bag_id;
	}
		
}