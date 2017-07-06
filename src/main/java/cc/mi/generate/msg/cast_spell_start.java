package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 通知客户端释放蓄力技能
 **/
public class cast_spell_start extends AbstractCoder  {
	//释放玩家
	private int caster_guid;
	//攻击玩家
	private int target_guid;
	//技能id
	private short spellid;
	//参数
	private String data;

	public cast_spell_start() {
		super(300);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.caster_guid);
		buffer.writeInt(this.target_guid);
		buffer.writeShort(this.spellid);
		StringCoder.writeString(buffer, this.data);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.caster_guid = buffer.readInt(); 
		this.target_guid = buffer.readInt(); 
		this.spellid = buffer.readShort(); 
		this.data = StringCoder.readString(buffer);
	}
	
	public int getCaster_guid() {
		return this.caster_guid;
	}
	
	public void setCaster_guid(int caster_guid) {
		this.caster_guid = caster_guid;
	}
		
	public int getTarget_guid() {
		return this.target_guid;
	}
	
	public void setTarget_guid(int target_guid) {
		this.target_guid = target_guid;
	}
		
	public short getSpellid() {
		return this.spellid;
	}
	
	public void setSpellid(short spellid) {
		this.spellid = spellid;
	}
		
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
		
}