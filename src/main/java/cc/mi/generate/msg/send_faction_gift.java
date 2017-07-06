package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.item_reward_info;

/**
 * 赠送礼物
 **/
public class send_faction_gift extends AbstractCoder  {
	//礼物list
	private List<item_reward_info> list;
	//留言
	private String msg;
	//留言类型
	private int msg_type;

	public send_faction_gift() {
		super(331);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.list.size());
		for (item_reward_info element : this.list) {
			element.encode(buffer);
		}
		StringCoder.writeString(buffer, this.msg);
		buffer.writeInt(this.msg_type);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.list.add(element);
		}
		this.msg = StringCoder.readString(buffer);
		this.msg_type = buffer.readInt(); 
	}
	
	public List<item_reward_info> getList() {
		return this.list;
	}
	
	public void setList(List<item_reward_info> list) {
		this.list = list;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
		
	public int getMsg_type() {
		return this.msg_type;
	}
	
	public void setMsg_type(int msg_type) {
		this.msg_type = msg_type;
	}
		
}