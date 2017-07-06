package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import java.util.List;
import java.util.ArrayList;

/**
 * Npc商品列表
 **/
public class npc_goods_list extends AbstractCoder  {
	//商品列表
	private List<Integer> goods;
	//
	private int npc_id;

	public npc_goods_list() {
		super(42);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.goods.size());
		for (int element : this.goods) {
			buffer.writeInt(element);
		}
		buffer.writeInt(this.npc_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.goods = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			int element = buffer.readInt();
			this.goods.add(element);
		}
		this.npc_id = buffer.readInt(); 
	}
	
	public List<Integer> getGoods() {
		return this.goods;
	}
	
	public void setGoods(List<Integer> goods) {
		this.goods = goods;
	}
	
	public int getNpc_id() {
		return this.npc_id;
	}
	
	public void setNpc_id(int npc_id) {
		this.npc_id = npc_id;
	}
		
}