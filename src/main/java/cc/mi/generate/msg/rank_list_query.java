package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 获取排行信息
 **/
public class rank_list_query extends AbstractCoder  {
	//回调号
	private int call_back_id;
	//排行类型
	private byte rank_list_type;
	//开始
	private short start_index;
	//结束
	private short end_index;

	public rank_list_query() {
		super(118);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.call_back_id);
		buffer.writeByte(this.rank_list_type);
		buffer.writeShort(this.start_index);
		buffer.writeShort(this.end_index);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.call_back_id = buffer.readInt(); 
		this.rank_list_type = buffer.readByte(); 
		this.start_index = buffer.readShort(); 
		this.end_index = buffer.readShort(); 
	}
	
	public int getCall_back_id() {
		return this.call_back_id;
	}
	
	public void setCall_back_id(int call_back_id) {
		this.call_back_id = call_back_id;
	}
		
	public byte getRank_list_type() {
		return this.rank_list_type;
	}
	
	public void setRank_list_type(byte rank_list_type) {
		this.rank_list_type = rank_list_type;
	}
		
	public short getStart_index() {
		return this.start_index;
	}
	
	public void setStart_index(short start_index) {
		this.start_index = start_index;
	}
		
	public short getEnd_index() {
		return this.end_index;
	}
	
	public void setEnd_index(short end_index) {
		this.end_index = end_index;
	}
		
}