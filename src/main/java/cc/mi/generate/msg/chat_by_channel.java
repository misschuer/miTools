package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 不同频道聊天
 **/
public class chat_by_channel extends AbstractCoder  {
	//聊天频道
	private byte channel;
	//说话内容
	private String content;

	public chat_by_channel() {
		super(179);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.channel);
		StringCoder.writeString(buffer, this.content);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.channel = buffer.readByte(); 
		this.content = StringCoder.readString(buffer);
	}
	
	public byte getChannel() {
		return this.channel;
	}
	
	public void setChannel(byte channel) {
		this.channel = channel;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
}