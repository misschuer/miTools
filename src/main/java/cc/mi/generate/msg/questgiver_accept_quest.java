package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 接任务
 **/
public class questgiver_accept_quest extends AbstractCoder  {
	//npcGUID
	private int npcid;
	//
	private int quest_id;

	public questgiver_accept_quest() {
		super(68);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.npcid);
		buffer.writeInt(this.quest_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.npcid = buffer.readInt(); 
		this.quest_id = buffer.readInt(); 
	}
	
	public int getNpcid() {
		return this.npcid;
	}
	
	public void setNpcid(int npcid) {
		this.npcid = npcid;
	}
		
	public int getQuest_id() {
		return this.quest_id;
	}
	
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
		
}