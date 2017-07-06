package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 神兵铸魂
 **/
public class divine_spirit extends AbstractCoder  {
	//神兵id
	private int id;
	//失败保护
	private int protect;
	//提升概率
	private int improve;

	public divine_spirit() {
		super(344);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		buffer.writeInt(this.protect);
		buffer.writeInt(this.improve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.protect = buffer.readInt(); 
		this.improve = buffer.readInt(); 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getProtect() {
		return this.protect;
	}
	
	public void setProtect(int protect) {
		this.protect = protect;
	}
		
	public int getImprove() {
		return this.improve;
	}
	
	public void setImprove(int improve) {
		this.improve = improve;
	}
		
}