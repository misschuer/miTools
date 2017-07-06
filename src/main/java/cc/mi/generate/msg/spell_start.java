package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 客户端释放技能
 **/
public class spell_start extends AbstractCoder  {
	//技能ID
	private int spell_id;
	//
	private short target_pos_x;
	//
	private short target_pos_y;
	//
	private int caster;
	//目标
	private int target;

	public spell_start() {
		super(77);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.spell_id);
		buffer.writeShort(this.target_pos_x);
		buffer.writeShort(this.target_pos_y);
		buffer.writeInt(this.caster);
		buffer.writeInt(this.target);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.spell_id = buffer.readInt(); 
		this.target_pos_x = buffer.readShort(); 
		this.target_pos_y = buffer.readShort(); 
		this.caster = buffer.readInt(); 
		this.target = buffer.readInt(); 
	}
	
	public int getSpell_id() {
		return this.spell_id;
	}
	
	public void setSpell_id(int spell_id) {
		this.spell_id = spell_id;
	}
		
	public short getTarget_pos_x() {
		return this.target_pos_x;
	}
	
	public void setTarget_pos_x(short target_pos_x) {
		this.target_pos_x = target_pos_x;
	}
		
	public short getTarget_pos_y() {
		return this.target_pos_y;
	}
	
	public void setTarget_pos_y(short target_pos_y) {
		this.target_pos_y = target_pos_y;
	}
		
	public int getCaster() {
		return this.caster;
	}
	
	public void setCaster(int caster) {
		this.caster = caster;
	}
		
	public int getTarget() {
		return this.target;
	}
	
	public void setTarget(int target) {
		this.target = target;
	}
		
}