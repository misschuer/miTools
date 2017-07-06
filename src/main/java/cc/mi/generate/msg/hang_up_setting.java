package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 进行挂机设置
 **/
public class hang_up_setting extends AbstractCoder  {
	//同PLAYER_FIELD_HOOK_BYTE0
	private int value0;
	//同PLAYER_FIELD_HOOK_BYTE1
	private int value1;
	//同PLAYER_FIELD_HOOK_BYTE2
	private int value2;
	//同PLAYER_FIELD_HOOK_BYTE3
	private int value3;

	public hang_up_setting() {
		super(164);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.value0);
		buffer.writeInt(this.value1);
		buffer.writeInt(this.value2);
		buffer.writeInt(this.value3);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.value0 = buffer.readInt(); 
		this.value1 = buffer.readInt(); 
		this.value2 = buffer.readInt(); 
		this.value3 = buffer.readInt(); 
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
		
	public int getValue2() {
		return this.value2;
	}
	
	public void setValue2(int value2) {
		this.value2 = value2;
	}
		
	public int getValue3() {
		return this.value3;
	}
	
	public void setValue3(int value3) {
		this.value3 = value3;
	}
		
}