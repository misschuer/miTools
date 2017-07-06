package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 背包有更强装备
 **/
public class bag_find_equip_better extends AbstractCoder  {
	//物品id
	private int item_id;
	//背包位置
	private int pos;

	public bag_find_equip_better() {
		super(282);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.item_id);
		buffer.writeInt(this.pos);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.item_id = buffer.readInt(); 
		this.pos = buffer.readInt(); 
	}
	
	public int getItem_id() {
		return this.item_id;
	}
	
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
		
	public int getPos() {
		return this.pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
		
}