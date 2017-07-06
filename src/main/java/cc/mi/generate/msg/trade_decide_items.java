package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;
import java.util.List;
import java.util.ArrayList;

/**
 * 交易确认物品
 **/
public class trade_decide_items extends AbstractCoder  {
	//确认交易的物品
	private List<String> items;
	//元宝
	private int gold_ingot;
	//银子
	private int silver;

	public trade_decide_items() {
		super(84);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeShort(this.items.size());
		for (String element : this.items) {
			StringCoder.writeString(buffer, element);
		}
		buffer.writeInt(this.gold_ingot);
		buffer.writeInt(this.silver);
	}

	@Override
	public void decode(ByteBuf buffer) {
		int size = buffer.readUnsignedShort();
		this.items = new ArrayList<>(size);
		for (int i = 0; i < size; ++ i) {
			String element = StringCoder.readString(buffer);
			this.items.add(element);
		}
		this.gold_ingot = buffer.readInt(); 
		this.silver = buffer.readInt(); 
	}
	
	public List<String> getItems() {
		return this.items;
	}
	
	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public int getGold_ingot() {
		return this.gold_ingot;
	}
	
	public void setGold_ingot(int gold_ingot) {
		this.gold_ingot = gold_ingot;
	}
		
	public int getSilver() {
		return this.silver;
	}
	
	public void setSilver(int silver) {
		this.silver = silver;
	}
		
}