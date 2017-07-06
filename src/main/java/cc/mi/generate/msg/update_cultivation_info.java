package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 返回修炼场信息
 **/
public class update_cultivation_info extends AbstractCoder  {
	//修炼开始时间
	private int start_time;
	//宝箱掠夺信息
	private int lost;

	public update_cultivation_info() {
		super(287);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.start_time);
		buffer.writeInt(this.lost);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.start_time = buffer.readInt(); 
		this.lost = buffer.readInt(); 
	}
	
	public int getStart_time() {
		return this.start_time;
	}
	
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
		
	public int getLost() {
		return this.lost;
	}
	
	public void setLost(int lost) {
		this.lost = lost;
	}
		
}