package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 出售物品
 **/
public class bag_item_sell extends AbstractCoder  {
	//物品guid
	private String item_guid;
	//个数
	private int count;

	public bag_item_sell() {
		super(273);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.item_guid);
		buffer.writeInt(this.count);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.item_guid = StringCoder.readString(buffer);
		this.count = buffer.readInt(); 
	}
	
	public String getItem_guid() {
		return this.item_guid;
	}
	
	public void setItem_guid(String item_guid) {
		this.item_guid = item_guid;
	}
		
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
}