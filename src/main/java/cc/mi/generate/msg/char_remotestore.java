package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 角色配置信息
 **/
public class char_remotestore extends AbstractCoder  {
	//类型
	private int key;
	//配置信息
	private int value;

	public char_remotestore() {
		super(26);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.key);
		buffer.writeInt(this.value);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.key = buffer.readInt(); 
		this.value = buffer.readInt(); 
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
		
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
		
}