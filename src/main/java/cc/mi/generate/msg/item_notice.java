package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.item_reward_info;

/**
 * 获得奖励提示
 **/
public class item_notice extends AbstractCoder  {
	//显示位置类型
	private byte showType;
	//道具列表
	private List<item_reward_info> list;

	public item_notice() {
		super(214);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.showType);
		buffer.writeShort(this.list.size());
		for (item_reward_info element : this.list) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.showType = buffer.readByte(); 
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.list.add(element);
		}
	}
	
	public byte getShowType() {
		return this.showType;
	}
	
	public void setShowType(byte showType) {
		this.showType = showType;
	}
		
	public List<item_reward_info> getList() {
		return this.list;
	}
	
	public void setList(List<item_reward_info> list) {
		this.list = list;
	}
	
}