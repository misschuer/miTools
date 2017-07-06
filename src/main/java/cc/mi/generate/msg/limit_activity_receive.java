package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 限时活动领取
 **/
public class limit_activity_receive extends AbstractCoder  {
	//领取id
	private int id;
	//领取类型
	private int type;

	public limit_activity_receive() {
		super(104);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		buffer.writeInt(this.type);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.type = buffer.readInt(); 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
		
}