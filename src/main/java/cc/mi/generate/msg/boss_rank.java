package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;
import cc.mi.generate.stru.rank_info;

/**
 * 当前BOSS伤害排名
 **/
public class boss_rank extends AbstractCoder  {
	//boss类型
	private byte rankType;
	//排名
	private List<rank_info> rankList;
	//我的排名
	private byte mine;

	public boss_rank() {
		super(206);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.rankType);
		buffer.writeShort(this.rankList.size());
		for (rank_info element : this.rankList) {
			element.encode(buffer);
		}
		buffer.writeByte(this.mine);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.rankType = buffer.readByte(); 
		int size = buffer.readUnsignedShort();
		this.rankList = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			rank_info element = new rank_info();
			element.decode(buffer);
			this.rankList.add(element);
		}
		this.mine = buffer.readByte(); 
	}
	
	public byte getRankType() {
		return this.rankType;
	}
	
	public void setRankType(byte rankType) {
		this.rankType = rankType;
	}
		
	public List<rank_info> getRankList() {
		return this.rankList;
	}
	
	public void setRankList(List<rank_info> rankList) {
		this.rankList = rankList;
	}
	
	public byte getMine() {
		return this.mine;
	}
	
	public void setMine(byte mine) {
		this.mine = mine;
	}
		
}