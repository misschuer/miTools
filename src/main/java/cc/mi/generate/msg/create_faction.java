package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 创建帮派
 **/
public class create_faction extends AbstractCoder  {
	//帮派名称
	private String name;
	//icon
	private byte icon;

	public create_faction() {
		super(142);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.name);
		buffer.writeByte(this.icon);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.name = StringCoder.readString(buffer);
		this.icon = buffer.readByte(); 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public byte getIcon() {
		return this.icon;
	}
	
	public void setIcon(byte icon) {
		this.icon = icon;
	}
		
}