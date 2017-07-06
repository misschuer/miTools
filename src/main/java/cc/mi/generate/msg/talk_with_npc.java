package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 和npc对话
 **/
public class talk_with_npc extends AbstractCoder  {
	//npcid
	private short entry;
	//任务id
	private short questId;

	public talk_with_npc() {
		super(231);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.entry);
		buffer.writeShort(this.questId);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.entry = buffer.readShort(); 
		this.questId = buffer.readShort(); 
	}
	
	public short getEntry() {
		return this.entry;
	}
	
	public void setEntry(short entry) {
		this.entry = entry;
	}
		
	public short getQuestId() {
		return this.questId;
	}
	
	public void setQuestId(short questId) {
		this.questId = questId;
	}
		
}