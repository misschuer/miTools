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
public class social_gift_friend extends AbstractCoder  {
	//好友GUID
	private String guid;
	//礼物列表
	private List<item_reward_info> gift;

	public social_gift_friend() {
		super(173);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		buffer.writeShort(this.gift.size());
		for (item_reward_info element : this.gift) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		int size = buffer.readUnsignedShort();
		this.gift = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.gift.add(element);
		}
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public List<item_reward_info> getGift() {
		return this.gift;
	}
	
	public void setGift(List<item_reward_info> gift) {
		this.gift = gift;
	}
	
}