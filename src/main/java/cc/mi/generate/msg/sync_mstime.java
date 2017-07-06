package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 同步时间
 **/
public class sync_mstime extends AbstractCoder  {
	//服务器运行的毫秒数
	private int mstime_now;
	//自然时间
	private int time_now;
	//自然时间的服务器启动时间
	private int open_time;

	public sync_mstime() {
		super(7);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.mstime_now);
		buffer.writeInt(this.time_now);
		buffer.writeInt(this.open_time);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.mstime_now = buffer.readInt(); 
		this.time_now = buffer.readInt(); 
		this.open_time = buffer.readInt(); 
	}
	
	public int getMstime_now() {
		return this.mstime_now;
	}
	
	public void setMstime_now(int mstime_now) {
		this.mstime_now = mstime_now;
	}
		
	public int getTime_now() {
		return this.time_now;
	}
	
	public void setTime_now(int time_now) {
		this.time_now = time_now;
	}
		
	public int getOpen_time() {
		return this.open_time;
	}
	
	public void setOpen_time(int open_time) {
		this.open_time = open_time;
	}
		
}