package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 排行榜点赞
 **/
public class rank_add_like extends AbstractCoder  {
	//排行榜类型
	private byte type;
	//GUID
	private String guid;

	public rank_add_like() {
		super(207);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.type);
		StringCoder.writeString(buffer, this.guid);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readByte(); 
		this.guid = StringCoder.readString(buffer);
	}
	
	public byte getType() {
		return this.type;
	}
	
	public void setType(byte type) {
		this.type = type;
	}
		
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
}