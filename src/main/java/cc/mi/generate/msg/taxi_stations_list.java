package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.taxi_menu_info;

/**
 * 发送传送点列表
 **/
public class taxi_stations_list extends AbstractCoder  {
	//
	private int npcid;
	//传送点列表
	private List<taxi_menu_info> stations;

	public taxi_stations_list() {
		super(49);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.npcid);
		buffer.writeShort(this.stations.size());
		for (taxi_menu_info element : this.stations) {
			element.encode(buffer);
		}
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.npcid = buffer.readInt(); 
		int size = buffer.readUnsignedShort();
		this.stations = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			taxi_menu_info element = new taxi_menu_info();
			element.decode(buffer);
			this.stations.add(element);
		}
	}
	
	public int getNpcid() {
		return this.npcid;
	}
	
	public void setNpcid(int npcid) {
		this.npcid = npcid;
	}
		
	public List<taxi_menu_info> getStations() {
		return this.stations;
	}
	
	public void setStations(List<taxi_menu_info> stations) {
		this.stations = stations;
	}
	
}