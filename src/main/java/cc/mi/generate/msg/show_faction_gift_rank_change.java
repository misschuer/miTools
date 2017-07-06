package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.generate.stru.faction_gift_rank_info;

/**
 * 返回家族魅力排行变化
 **/
public class show_faction_gift_rank_change extends AbstractCoder  {
	//原排行
	private int old_rank;
	//新排行
	private int new_rank;
	//本帮派排行信息
	private faction_gift_rank_info info;

	public show_faction_gift_rank_change() {
		super(340);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.old_rank);
		buffer.writeInt(this.new_rank);
		this.info.encode(buffer);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.old_rank = buffer.readInt(); 
		this.new_rank = buffer.readInt(); 
		this.info = new faction_gift_rank_info();
		this.info.decode(buffer);
	}
	
	public int getOld_rank() {
		return this.old_rank;
	}
	
	public void setOld_rank(int old_rank) {
		this.old_rank = old_rank;
	}
		
	public int getNew_rank() {
		return this.new_rank;
	}
	
	public void setNew_rank(int new_rank) {
		this.new_rank = new_rank;
	}
		
	public faction_gift_rank_info getInfo() {
		return this.info;
	}
	
	public void setInfo(faction_gift_rank_info info) {
		this.info = info;
	}
		
}