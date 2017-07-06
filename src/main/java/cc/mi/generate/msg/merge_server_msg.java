package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 合服通知
 **/
public class merge_server_msg extends AbstractCoder  {
	//合服域名
	private String merge_host;
	//合服端口
	private int merge_port;
	//合服sessionkey
	private String merge_key;
	//合服类型
	private int merge_type;
	//预留
	private int reserve;
	//预留2
	private int reserve2;

	public merge_server_msg() {
		super(117);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.merge_host);
		buffer.writeInt(this.merge_port);
		StringCoder.writeString(buffer, this.merge_key);
		buffer.writeInt(this.merge_type);
		buffer.writeInt(this.reserve);
		buffer.writeInt(this.reserve2);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.merge_host = StringCoder.readString(buffer);
		this.merge_port = buffer.readInt(); 
		this.merge_key = StringCoder.readString(buffer);
		this.merge_type = buffer.readInt(); 
		this.reserve = buffer.readInt(); 
		this.reserve2 = buffer.readInt(); 
	}
	
	public String getMerge_host() {
		return this.merge_host;
	}
	
	public void setMerge_host(String merge_host) {
		this.merge_host = merge_host;
	}
		
	public int getMerge_port() {
		return this.merge_port;
	}
	
	public void setMerge_port(int merge_port) {
		this.merge_port = merge_port;
	}
		
	public String getMerge_key() {
		return this.merge_key;
	}
	
	public void setMerge_key(String merge_key) {
		this.merge_key = merge_key;
	}
		
	public int getMerge_type() {
		return this.merge_type;
	}
	
	public void setMerge_type(int merge_type) {
		this.merge_type = merge_type;
	}
		
	public int getReserve() {
		return this.reserve;
	}
	
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
		
	public int getReserve2() {
		return this.reserve2;
	}
	
	public void setReserve2(int reserve2) {
		this.reserve2 = reserve2;
	}
		
}