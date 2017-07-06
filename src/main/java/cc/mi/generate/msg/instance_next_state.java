package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 向服务端发送副本进入下一阶段指令
 **/
public class instance_next_state extends AbstractCoder  {
	//进入关卡
	private short level;
	//预留参数
	private int param;

	public instance_next_state() {
		super(102);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.level);
		buffer.writeInt(this.param);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.level = buffer.readShort(); 
		this.param = buffer.readInt(); 
	}
	
	public short getLevel() {
		return this.level;
	}
	
	public void setLevel(short level) {
		this.level = level;
	}
		
	public int getParam() {
		return this.param;
	}
	
	public void setParam(int param) {
		this.param = param;
	}
		
}