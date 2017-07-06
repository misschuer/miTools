package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 完成任务后通知任务链的下个任务
 **/
public class questhelp_next extends AbstractCoder  {
	//当前任务
	private int current_id;
	//下一个任务
	private int next_id;
	//NPC_GUID
	private int guid;

	public questhelp_next() {
		super(63);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.current_id);
		buffer.writeInt(this.next_id);
		buffer.writeInt(this.guid);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.current_id = buffer.readInt(); 
		this.next_id = buffer.readInt(); 
		this.guid = buffer.readInt(); 
	}
	
	public int getCurrent_id() {
		return this.current_id;
	}
	
	public void setCurrent_id(int current_id) {
		this.current_id = current_id;
	}
		
	public int getNext_id() {
		return this.next_id;
	}
	
	public void setNext_id(int next_id) {
		this.next_id = next_id;
	}
		
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
}