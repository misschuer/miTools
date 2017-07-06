package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 喇叭
 **/
public class chat_horn extends AbstractCoder  {
	//玩家guid
	private String guid;
	//玩家阵营
	private byte faction;
	//玩家名称
	private String name;
	//说话内容
	private String content;

	public chat_horn() {
		super(93);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		buffer.writeByte(this.faction);
		StringCoder.writeString(buffer, this.name);
		StringCoder.writeString(buffer, this.content);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		this.faction = buffer.readByte(); 
		this.name = StringCoder.readString(buffer);
		this.content = StringCoder.readString(buffer);
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public byte getFaction() {
		return this.faction;
	}
	
	public void setFaction(byte faction) {
		this.faction = faction;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
}