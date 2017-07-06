package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.item_reward_info;

/**
 * 扫荡副本奖励
 **/
public class sweep_instance_reward extends AbstractCoder  {
	//扫荡副本子类型
	private byte inst_sub_type;
	//扫荡副本数据1
	private byte data1;
	//扫荡副本数据2
	private byte data2;
	//扫荡副本数据3
	private byte data3;
	//道具列表
	private List<item_reward_info> list;

	public sweep_instance_reward() {
		super(168);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.inst_sub_type);
		buffer.writeByte(this.data1);
		buffer.writeByte(this.data2);
		buffer.writeByte(this.data3);
		buffer.writeShort(this.list.size());
		for (item_reward_info element : this.list) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.inst_sub_type = buffer.readByte(); 
		this.data1 = buffer.readByte(); 
		this.data2 = buffer.readByte(); 
		this.data3 = buffer.readByte(); 
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			item_reward_info element = new item_reward_info();
			element.decode(buffer);
			this.list.add(element);
		}
	}
	
	public byte getInst_sub_type() {
		return this.inst_sub_type;
	}
	
	public void setInst_sub_type(byte inst_sub_type) {
		this.inst_sub_type = inst_sub_type;
	}
		
	public byte getData1() {
		return this.data1;
	}
	
	public void setData1(byte data1) {
		this.data1 = data1;
	}
		
	public byte getData2() {
		return this.data2;
	}
	
	public void setData2(byte data2) {
		this.data2 = data2;
	}
		
	public byte getData3() {
		return this.data3;
	}
	
	public void setData3(byte data3) {
		this.data3 = data3;
	}
		
	public List<item_reward_info> getList() {
		return this.list;
	}
	
	public void setList(List<item_reward_info> list) {
		this.list = list;
	}
	
}