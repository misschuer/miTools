package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.gossip_menu_option_info;

/**
 * 发送闲聊信息和选项
 **/
public class gossip_message extends AbstractCoder  {
	//NPC ID
	private int npcid;
	//npc模版id
	private int npc_entry;
	//闲聊素材表id
	private int option_id;
	//闲聊文本
	private String option_text;
	//闲聊列表
	private List<gossip_menu_option_info> gossip_items;

	public gossip_message() {
		super(53);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.npcid);
		buffer.writeInt(this.npc_entry);
		buffer.writeInt(this.option_id);
		StringCoder.writeString(buffer, this.option_text);
		buffer.writeShort(this.gossip_items.size());
		for (gossip_menu_option_info element : this.gossip_items) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.npcid = buffer.readInt(); 
		this.npc_entry = buffer.readInt(); 
		this.option_id = buffer.readInt(); 
		this.option_text = StringCoder.readString(buffer);
		int size = buffer.readUnsignedShort();
		this.gossip_items = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			gossip_menu_option_info element = new gossip_menu_option_info();
			element.decode(buffer);
			this.gossip_items.add(element);
		}
	}
	
	public int getNpcid() {
		return this.npcid;
	}
	
	public void setNpcid(int npcid) {
		this.npcid = npcid;
	}
		
	public int getNpc_entry() {
		return this.npc_entry;
	}
	
	public void setNpc_entry(int npc_entry) {
		this.npc_entry = npc_entry;
	}
		
	public int getOption_id() {
		return this.option_id;
	}
	
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}
		
	public String getOption_text() {
		return this.option_text;
	}
	
	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}
		
	public List<gossip_menu_option_info> getGossip_items() {
		return this.gossip_items;
	}
	
	public void setGossip_items(List<gossip_menu_option_info> gossip_items) {
		this.gossip_items = gossip_items;
	}
	
}