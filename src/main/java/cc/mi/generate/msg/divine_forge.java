package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 神兵强化
 **/
public class divine_forge extends AbstractCoder  {
	//神兵id
	private int id;
	//次数
	private int count;

	public divine_forge() {
		super(342);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		buffer.writeInt(this.count);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.count = buffer.readInt(); 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
}