package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 选择传送点
 **/
public class taxi_select_station extends AbstractCoder  {
	//
	private int station_id;
	//
	private int guid;

	public taxi_select_station() {
		super(50);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.station_id);
		buffer.writeInt(this.guid);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.station_id = buffer.readInt(); 
		this.guid = buffer.readInt(); 
	}
	
	public int getStation_id() {
		return this.station_id;
	}
	
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
		
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
}