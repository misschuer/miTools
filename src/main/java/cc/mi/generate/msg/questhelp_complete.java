package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 任务系统强制完成任务
 **/
public class questhelp_complete extends AbstractCoder  {
	//任务ID
	private int quest_id;
	//任务
	private byte quest_statue;
	//保留
	private byte reserve;

	public questhelp_complete() {
		super(64);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.quest_id);
		buffer.writeByte(this.quest_statue);
		buffer.writeByte(this.reserve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.quest_id = buffer.readInt(); 
		this.quest_statue = buffer.readByte(); 
		this.reserve = buffer.readByte(); 
	}
	
	public int getQuest_id() {
		return this.quest_id;
	}
	
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
		
	public byte getQuest_statue() {
		return this.quest_statue;
	}
	
	public void setQuest_statue(byte quest_statue) {
		this.quest_statue = quest_statue;
	}
		
	public byte getReserve() {
		return this.reserve;
	}
	
	public void setReserve(byte reserve) {
		this.reserve = reserve;
	}
		
}