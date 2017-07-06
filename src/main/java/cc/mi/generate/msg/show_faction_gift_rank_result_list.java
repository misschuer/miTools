package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.faction_gift_rank_info;

/**
 * 返回家族魅力排行
 **/
public class show_faction_gift_rank_result_list extends AbstractCoder  {
	//排行列表
	private List<faction_gift_rank_info> list;
	//本帮派排行信息
	private faction_gift_rank_info info;
	//页数
	private int page;

	public show_faction_gift_rank_result_list() {
		super(339);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.list.size());
		for (faction_gift_rank_info element : this.list) {
			element.encode(buffer);
		}
		this.info.encode(buffer);
		buffer.writeInt(this.page);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.list = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			faction_gift_rank_info element = new faction_gift_rank_info();
			element.decode(buffer);
			this.list.add(element);
		}
		this.info = new faction_gift_rank_info();
		this.info.decode(buffer);
		this.page = buffer.readInt(); 
	}
	
	public List<faction_gift_rank_info> getList() {
		return this.list;
	}
	
	public void setList(List<faction_gift_rank_info> list) {
		this.list = list;
	}
	
	public faction_gift_rank_info getInfo() {
		return this.info;
	}
	
	public void setInfo(faction_gift_rank_info info) {
		this.info = info;
	}
		
	public int getPage() {
		return this.page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
		
}