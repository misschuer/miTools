package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 全民boss信息结果
 **/
public class mass_boss_info_ret extends AbstractCoder  {
	//全民boss参加人数
	private int count;
	//当前boss血量
	private byte percent;

	public mass_boss_info_ret() {
		super(353);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.count);
		buffer.writeByte(this.percent);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.count = buffer.readInt(); 
		this.percent = buffer.readByte(); 
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		
	public byte getPercent() {
		return this.percent;
	}
	
	public void setPercent(byte percent) {
		this.percent = percent;
	}
		
}