package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 玩家加入或者离开某服务器
 **/
public class join_or_leave_server extends AbstractCoder  {
	//加入或者离开
	private byte join_or_leave;
	//服务器类型
	private byte server_type;
	//服务器进程id
	private int server_pid;
	//服务器连接id
	private int server_fd;
	//加入或者离开的时间点
	private int time;

	public join_or_leave_server() {
		super(125);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.join_or_leave);
		buffer.writeByte(this.server_type);
		buffer.writeInt(this.server_pid);
		buffer.writeInt(this.server_fd);
		buffer.writeInt(this.time);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.join_or_leave = buffer.readByte(); 
		this.server_type = buffer.readByte(); 
		this.server_pid = buffer.readInt(); 
		this.server_fd = buffer.readInt(); 
		this.time = buffer.readInt(); 
	}
	
	public byte getJoin_or_leave() {
		return this.join_or_leave;
	}
	
	public void setJoin_or_leave(byte join_or_leave) {
		this.join_or_leave = join_or_leave;
	}
		
	public byte getServer_type() {
		return this.server_type;
	}
	
	public void setServer_type(byte server_type) {
		this.server_type = server_type;
	}
		
	public int getServer_pid() {
		return this.server_pid;
	}
	
	public void setServer_pid(int server_pid) {
		this.server_pid = server_pid;
	}
		
	public int getServer_fd() {
		return this.server_fd;
	}
	
	public void setServer_fd(int server_fd) {
		this.server_fd = server_fd;
	}
		
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
		
}