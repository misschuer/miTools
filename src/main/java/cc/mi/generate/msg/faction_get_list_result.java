package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.faction_info;

/**
 * 帮派列表
 **/
public class faction_get_list_result extends AbstractCoder  {
	//帮派列表
	private List<faction_info> list;
	//当前页
	private byte curpag;
	//最大页
	private byte maxpag;

	public faction_get_list_result() {
		super(183);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.list.size());
		for (faction_info element : this.list) {
			element.encode(buffer);
		}
		buffer.writeByte(this.curpag);
		buffer.writeByte(this.maxpag);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			faction_info element = new faction_info();
			element.decode(buffer);
			this.list.add(element);
		}
		this.curpag = buffer.readByte(); 
		this.maxpag = buffer.readByte(); 
	}
	
	public List<faction_info> getList() {
		return this.list;
	}
	
	public void setList(List<faction_info> list) {
		this.list = list;
	}
	
	public byte getCurpag() {
		return this.curpag;
	}
	
	public void setCurpag(byte curpag) {
		this.curpag = curpag;
	}
		
	public byte getMaxpag() {
		return this.maxpag;
	}
	
	public void setMaxpag(byte maxpag) {
		this.maxpag = maxpag;
	}
		
}