package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 生物讲话
 **/
public class chat_unit_talk extends AbstractCoder  {
	//发言者id
	private int guid;
	//发言内容摸版id
	private int content;
	//发言字符
	private String say;

	public chat_unit_talk() {
		super(88);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeInt(this.content);
		StringCoder.writeString(buffer, this.say);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.content = buffer.readInt(); 
		this.say = StringCoder.readString(buffer);
	}
	
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
	public int getContent() {
		return this.content;
	}
	
	public void setContent(int content) {
		this.content = content;
	}
		
	public String getSay() {
		return this.say;
	}
	
	public void setSay(String say) {
		this.say = say;
	}
		
}