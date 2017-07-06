package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 通知客户端观察者的视角
 **/
public class notice_watcher_map_info extends AbstractCoder  {
	//观察者guid
	private String wather_guid;
	//地图id
	private int map_id;
	//实例id
	private int instance_id;

	public notice_watcher_map_info() {
		super(130);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.wather_guid);
		buffer.writeInt(this.map_id);
		buffer.writeInt(this.instance_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.wather_guid = StringCoder.readString(buffer);
		this.map_id = buffer.readInt(); 
		this.instance_id = buffer.readInt(); 
	}
	
	public String getWather_guid() {
		return this.wather_guid;
	}
	
	public void setWather_guid(String wather_guid) {
		this.wather_guid = wather_guid;
	}
		
	public int getMap_id() {
		return this.map_id;
	}
	
	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}
		
	public int getInstance_id() {
		return this.instance_id;
	}
	
	public void setInstance_id(int instance_id) {
		this.instance_id = instance_id;
	}
		
}