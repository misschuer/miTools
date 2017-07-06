package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 任务对话选项
 **/
public class questhelp_talk_option extends AbstractCoder  {
	//任务ID
	private int quest_id;
	//选项ID
	private int option_id;
	//
	private int value0;
	//
	private int value1;

	public questhelp_talk_option() {
		super(47);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.quest_id);
		buffer.writeInt(this.option_id);
		buffer.writeInt(this.value0);
		buffer.writeInt(this.value1);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.quest_id = buffer.readInt(); 
		this.option_id = buffer.readInt(); 
		this.value0 = buffer.readInt(); 
		this.value1 = buffer.readInt(); 
	}
	
	public int getQuest_id() {
		return this.quest_id;
	}
	
	public void setQuest_id(int quest_id) {
		this.quest_id = quest_id;
	}
		
	public int getOption_id() {
		return this.option_id;
	}
	
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}
		
	public int getValue0() {
		return this.value0;
	}
	
	public void setValue0(int value0) {
		this.value0 = value0;
	}
		
	public int getValue1() {
		return this.value1;
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
	}
		
}