package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 任务NPC状态
 **/
public class questgiver_status extends AbstractCoder  {
	//NPC GUI
	private int guid;
	//状态
	private byte status;

	public questgiver_status() {
		super(55);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guid);
		buffer.writeByte(this.status);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = buffer.readInt(); 
		this.status = buffer.readByte(); 
	}
	
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
	public byte getStatus() {
		return this.status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
		
}