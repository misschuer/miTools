package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.char_create_info;

/**
 * 角色列表
 **/
public class chars_list extends AbstractCoder  {
	//角色列表
	private List<char_create_info> list;
	//家族名称
	private String faction_name;
	//女王名称
	private String queen_name;
	//图标
	private byte icon;

	public chars_list() {
		super(16);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.list.size());
		for (char_create_info element : this.list) {
			element.encode(buffer);
		}
		StringCoder.writeString(buffer, this.faction_name);
		StringCoder.writeString(buffer, this.queen_name);
		buffer.writeByte(this.icon);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			char_create_info element = new char_create_info();
			element.decode(buffer);
			this.list.add(element);
		}
		this.faction_name = StringCoder.readString(buffer);
		this.queen_name = StringCoder.readString(buffer);
		this.icon = buffer.readByte(); 
	}
	
	public List<char_create_info> getList() {
		return this.list;
	}
	
	public void setList(List<char_create_info> list) {
		this.list = list;
	}
	
	public String getFaction_name() {
		return this.faction_name;
	}
	
	public void setFaction_name(String faction_name) {
		this.faction_name = faction_name;
	}
		
	public String getQueen_name() {
		return this.queen_name;
	}
	
	public void setQueen_name(String queen_name) {
		this.queen_name = queen_name;
	}
		
	public byte getIcon() {
		return this.icon;
	}
	
	public void setIcon(byte icon) {
		this.icon = icon;
	}
		
}