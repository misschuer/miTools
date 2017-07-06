package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 申请升级技能
 **/
public class raise_base_spell extends AbstractCoder  {
	//技能类型
	private byte raiseType;
	//技能ID
	private short spellId;

	public raise_base_spell() {
		super(145);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.raiseType);
		buffer.writeShort(this.spellId);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.raiseType = buffer.readByte(); 
		this.spellId = buffer.readShort(); 
	}
	
	public byte getRaiseType() {
		return this.raiseType;
	}
	
	public void setRaiseType(byte raiseType) {
		this.raiseType = raiseType;
	}
		
	public short getSpellId() {
		return this.spellId;
	}
	
	public void setSpellId(short spellId) {
		this.spellId = spellId;
	}
		
}