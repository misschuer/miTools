package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 传送到野外boss旁边
 **/
public class teleport_field_boss extends AbstractCoder  {
	//地图id
	private int mapid;
	//分线号
	private int lineNo;

	public teleport_field_boss() {
		super(217);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.mapid);
		buffer.writeInt(this.lineNo);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.mapid = buffer.readInt(); 
		this.lineNo = buffer.readInt(); 
	}
	
	public int getMapid() {
		return this.mapid;
	}
	
	public void setMapid(int mapid) {
		this.mapid = mapid;
	}
		
	public int getLineNo() {
		return this.lineNo;
	}
	
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
		
}