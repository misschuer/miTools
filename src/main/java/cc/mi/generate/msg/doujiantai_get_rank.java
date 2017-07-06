package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 斗剑台排行榜
 **/
public class doujiantai_get_rank extends AbstractCoder  {
	//类型
	private short startIdx;
	//类型
	private short endIdx;

	public doujiantai_get_rank() {
		super(266);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.startIdx);
		buffer.writeShort(this.endIdx);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.startIdx = buffer.readShort(); 
		this.endIdx = buffer.readShort(); 
	}
	
	public short getStartIdx() {
		return this.startIdx;
	}
	
	public void setStartIdx(short startIdx) {
		this.startIdx = startIdx;
	}
		
	public short getEndIdx() {
		return this.endIdx;
	}
	
	public void setEndIdx(short endIdx) {
		this.endIdx = endIdx;
	}
		
}