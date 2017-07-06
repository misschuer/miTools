package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 跨服传送
 **/
public class kuafu_chuansong extends AbstractCoder  {
	//战斗信息
	private String str_data;
	//观察者guid
	private String watcher_guid;
	//预留参数
	private int reserve;

	public kuafu_chuansong() {
		super(132);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.str_data);
		StringCoder.writeString(buffer, this.watcher_guid);
		buffer.writeInt(this.reserve);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.str_data = StringCoder.readString(buffer);
		this.watcher_guid = StringCoder.readString(buffer);
		this.reserve = buffer.readInt(); 
	}
	
	public String getStr_data() {
		return this.str_data;
	}
	
	public void setStr_data(String str_data) {
		this.str_data = str_data;
	}
		
	public String getWatcher_guid() {
		return this.watcher_guid;
	}
	
	public void setWatcher_guid(String watcher_guid) {
		this.watcher_guid = watcher_guid;
	}
		
	public int getReserve() {
		return this.reserve;
	}
	
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
		
}