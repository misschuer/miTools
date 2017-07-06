package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 更新任务进度_下标数量
 **/
public class questhelp_update_status extends AbstractCoder  {
	//任务ID
	private int quest_id;
	//下标ID
	private int slot_id;
	//增加数量
	private int num;

	public questhelp_update_status() {
		super(66);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.quest_id);
		buffer.writeInt(this.slot_id);
		buffer.writeInt(this.num);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.quest_id = buffer.readInt(); 
		this.slot_id = buffer.readInt(); 
		this.num = buffer.readInt(); 
	}
	
	public int getQuest_id() {
		return this.quest_id;
	}
	
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
		
	public int getSlot_id() {
		return this.slot_id;
	}
	
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
		
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
		
}