package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 记录客户端日志
 **/
public class write_client_log extends AbstractCoder  {
	//类型
	private int type;
	//uid
	private String uid;
	//guid
	private String guid;
	//内容
	private String log;

	public write_client_log() {
		super(5);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.type);
		StringCoder.writeString(buffer, this.uid);
		StringCoder.writeString(buffer, this.guid);
		StringCoder.writeString(buffer, this.log);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.type = buffer.readInt(); 
		this.uid = StringCoder.readString(buffer);
		this.guid = StringCoder.readString(buffer);
		this.log = StringCoder.readString(buffer);
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
		
	public String getUid() {
		return this.uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
		
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public String getLog() {
		return this.log;
	}
	
	public void setLog(String log) {
		this.log = log;
	}
		
}