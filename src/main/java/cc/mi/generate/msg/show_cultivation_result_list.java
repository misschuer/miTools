package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.item_reward_info;

/**
 * 返回修炼场战斗结果
 **/
public class show_cultivation_result_list extends AbstractCoder  {
	//战斗结果-1:失败  1:胜利
	private int result;
	//对方名称
	private String name;
	///奖励道具列表/
	private List<item_reward_info> list;

	public show_cultivation_result_list() {
		super(295);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.result);
		StringCoder.writeString(buffer, this.name);
		buffer.writeShort(this.list.size());
		for (item_reward_info element : this.list) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.result = buffer.readInt(); 
		this.name = StringCoder.readString(buffer);
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.list.add(element);
		}
	}
	
	public int getResult() {
		return this.result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public List<item_reward_info> getList() {
		return this.list;
	}
	
	public void setList(List<item_reward_info> list) {
		this.list = list;
	}
	
}