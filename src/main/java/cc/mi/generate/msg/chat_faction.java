package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 阵营聊天
 **/
public class chat_faction extends AbstractCoder  {
	//玩家id
	private String guid;
	//玩家名称
	private String name;
	//说话内容
	private String content;
	//玩家阵营
	private byte faction;

	public chat_faction() {
		super(91);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		StringCoder.writeString(buffer, this.name);
		StringCoder.writeString(buffer, this.content);
		buffer.writeByte(this.faction);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		this.name = StringCoder.readString(buffer);
		this.content = StringCoder.readString(buffer);
		this.faction = buffer.readByte(); 
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
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
		
	public byte getFaction() {
		return this.faction;
	}
	
	public void setFaction(byte faction) {
		this.faction = faction;
	}
		
}