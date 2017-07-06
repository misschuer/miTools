package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 发送聊天
 **/
public class send_chat extends AbstractCoder  {
	//聊天频道
	private byte channel;
	//玩家guid
	private String guid;
	//称号
	private byte title;
	//名字
	private String name;
	//VIP
	private byte vip;
	//转生
	private byte zs;
	//等级
	private byte lvl;
	//头像
	private byte gender;
	//说话内容
	private String content;
	//收到的guid
	private String to_guid;
	//帮派guid
	private String faction_guid;

	public send_chat() {
		super(180);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.channel);
		StringCoder.writeString(buffer, this.guid);
		buffer.writeByte(this.title);
		StringCoder.writeString(buffer, this.name);
		buffer.writeByte(this.vip);
		buffer.writeByte(this.zs);
		buffer.writeByte(this.lvl);
		buffer.writeByte(this.gender);
		StringCoder.writeString(buffer, this.content);
		StringCoder.writeString(buffer, this.to_guid);
		StringCoder.writeString(buffer, this.faction_guid);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.channel = buffer.readByte(); 
		this.guid = StringCoder.readString(buffer);
		this.title = buffer.readByte(); 
		this.name = StringCoder.readString(buffer);
		this.vip = buffer.readByte(); 
		this.zs = buffer.readByte(); 
		this.lvl = buffer.readByte(); 
		this.gender = buffer.readByte(); 
		this.content = StringCoder.readString(buffer);
		this.to_guid = StringCoder.readString(buffer);
		this.faction_guid = StringCoder.readString(buffer);
	}
	
	public byte getChannel() {
		return this.channel;
	}
	
	public void setChannel(byte channel) {
		this.channel = channel;
	}
		
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public byte getTitle() {
		return this.title;
	}
	
	public void setTitle(byte title) {
		this.title = title;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public byte getVip() {
		return this.vip;
	}
	
	public void setVip(byte vip) {
		this.vip = vip;
	}
		
	public byte getZs() {
		return this.zs;
	}
	
	public void setZs(byte zs) {
		this.zs = zs;
	}
		
	public byte getLvl() {
		return this.lvl;
	}
	
	public void setLvl(byte lvl) {
		this.lvl = lvl;
	}
		
	public byte getGender() {
		return this.gender;
	}
	
	public void setGender(byte gender) {
		this.gender = gender;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
	public String getTo_guid() {
		return this.to_guid;
	}
	
	public void setTo_guid(String to_guid) {
		this.to_guid = to_guid;
	}
		
	public String getFaction_guid() {
		return this.faction_guid;
	}
	
	public void setFaction_guid(String faction_guid) {
		this.faction_guid = faction_guid;
	}
		
}