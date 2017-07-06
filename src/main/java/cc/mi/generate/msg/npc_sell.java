package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 出售物品
 **/
public class npc_sell extends AbstractCoder  {
	//NPCID
	private int npc_id;
	//物品guid
	private String item_guid;
	//数量
	private int num;

	public npc_sell() {
		super(44);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.npc_id);
		StringCoder.writeString(buffer, this.item_guid);
		buffer.writeInt(this.num);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.npc_id = buffer.readInt(); 
		this.item_guid = StringCoder.readString(buffer);
		this.num = buffer.readInt(); 
	}
	
	public int getNpc_id() {
		return this.npc_id;
	}
	
	public void setNpc_id(int npc_id) {
		this.npc_id = npc_id;
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
		
}