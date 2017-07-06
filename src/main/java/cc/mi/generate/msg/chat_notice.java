package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 公告
 **/
public class chat_notice extends AbstractCoder  {
	//公告id
	private int id;
	//公告内容
	private String content;
	//预留参数
	private String data;

	public chat_notice() {
		super(94);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		StringCoder.writeString(buffer, this.content);
		StringCoder.writeString(buffer, this.data);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.content = StringCoder.readString(buffer);
		this.data = StringCoder.readString(buffer);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
		
}