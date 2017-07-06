package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 角色配置信息
 **/
public class char_remotestore_str extends AbstractCoder  {
	//类型
	private int key;
	//配置信息
	private String value;

	public char_remotestore_str() {
		super(27);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.key);
		StringCoder.writeString(buffer, this.value);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.key = buffer.readInt(); 
		this.value = StringCoder.readString(buffer);
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
		
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
		
}