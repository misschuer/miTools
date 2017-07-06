package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 完成任务
 **/
public class questgiver_complete_quest extends AbstractCoder  {
	//NPC_GUID
	private int guid;
	//任务ID
	private int quest_id;
	//选择奖励项
	private byte reward;

	public questgiver_complete_quest() {
		super(62);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeInt(this.quest_id);
		buffer.writeByte(this.reward);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.quest_id = buffer.readInt(); 
		this.reward = buffer.readByte(); 
	}
	
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
	public int getQuest_id() {
		return this.quest_id;
	}
	
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
		
	public byte getReward() {
		return this.reward;
	}
	
	public void setReward(byte reward) {
		this.reward = reward;
	}
		
}