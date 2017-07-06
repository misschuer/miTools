package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 奖励列表
 **/
public class welfare_rewardlist_getback extends AbstractCoder  {
	//道具列表
	private String list;
	//消耗资源
	private String cost;

	public welfare_rewardlist_getback() {
		super(241);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.list);
		StringCoder.writeString(buffer, this.cost);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.list = StringCoder.readString(buffer);
		this.cost = StringCoder.readString(buffer);
	}
	
	public String getList() {
		return this.list;
	}
	
	public void setList(String list) {
		this.list = list;
	}
		
	public String getCost() {
		return this.cost;
	}
	
	public void setCost(String cost) {
		this.cost = cost;
	}
		
}