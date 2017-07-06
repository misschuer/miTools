package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 设置拒绝接受消息
 **/
public class msg_decline extends AbstractCoder  {
	//PLAYER_FIELD_DECLINE_CHANNEL_BYTE0
	private int value0;
	//PLAYER_FIELD_DECLINE_CHANNEL_BYTE1
	private int value1;

	public msg_decline() {
		super(182);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.value0);
		buffer.writeInt(this.value1);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.value0 = buffer.readInt(); 
		this.value1 = buffer.readInt(); 
	}
	
	public int getValue0() {
		return this.value0;
	}
	
	public void setValue0(int value0) {
		this.value0 = value0;
	}
		
	public int getValue1() {
		return this.value1;
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
	}
		
}