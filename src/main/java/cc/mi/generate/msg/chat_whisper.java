package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 私聊
 **/
public class chat_whisper extends AbstractCoder  {
	//玩家id
	private String guid;
	//说话内容
	private String content;

	public chat_whisper() {
		super(90);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		StringCoder.writeString(buffer, this.content);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		this.content = StringCoder.readString(buffer);
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
}