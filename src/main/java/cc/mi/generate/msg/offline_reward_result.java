package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.item_reward_info;

/**
 * 离线奖励结果
 **/
public class offline_reward_result extends AbstractCoder  {
	//备用
	private int reserve;
	//备用2
	private int reserve2;
	//备用3
	private int reserve3;
	//备用4
	private int reserve4;
	///奖励道具列表/
	private List<item_reward_info> list;

	public offline_reward_result() {
		super(326);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.reserve);
		buffer.writeInt(this.reserve2);
		buffer.writeInt(this.reserve3);
		buffer.writeInt(this.reserve4);
		buffer.writeShort(this.list.size());
		for (item_reward_info element : this.list) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.reserve = buffer.readInt(); 
		this.reserve2 = buffer.readInt(); 
		this.reserve3 = buffer.readInt(); 
		this.reserve4 = buffer.readInt(); 
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.list.add(element);
		}
	}
	
	public int getReserve() {
		return this.reserve;
	}
	
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
		
	public int getReserve2() {
		return this.reserve2;
	}
	
	public void setReserve2(int reserve2) {
		this.reserve2 = reserve2;
	}
		
	public int getReserve3() {
		return this.reserve3;
	}
	
	public void setReserve3(int reserve3) {
		this.reserve3 = reserve3;
	}
		
	public int getReserve4() {
		return this.reserve4;
	}
	
	public void setReserve4(int reserve4) {
		this.reserve4 = reserve4;
	}
		
	public List<item_reward_info> getList() {
		return this.list;
	}
	
	public void setList(List<item_reward_info> list) {
		this.list = list;
	}
	
}