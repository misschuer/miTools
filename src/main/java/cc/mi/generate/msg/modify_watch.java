package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 客户端订阅对象信息
 **/
public class modify_watch extends AbstractCoder  {
	//操作类型
	private byte opt;
	//修改对象订阅
	private int cid;
	//订阅key
	private String key;

	public modify_watch() {
		super(131);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.opt);
		buffer.writeInt(this.cid);
		StringCoder.writeString(buffer, this.key);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.opt = buffer.readByte(); 
		this.cid = buffer.readInt(); 
		this.key = StringCoder.readString(buffer);
	}
	
	public byte getOpt() {
		return this.opt;
	}
	
	public void setOpt(byte opt) {
		this.opt = opt;
	}
		
	public int getCid() {
		return this.cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
		
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
		
}