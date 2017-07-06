package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 仓库存钱
 **/
public class warehouse_save_money extends AbstractCoder  {
	//多少钱
	private int money;
	//多少元宝
	private int money_gold;
	//多少银票
	private int money_bills;

	public warehouse_save_money() {
		super(107);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.money);
		buffer.writeInt(this.money_gold);
		buffer.writeInt(this.money_bills);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.money = buffer.readInt(); 
		this.money_gold = buffer.readInt(); 
		this.money_bills = buffer.readInt(); 
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
		
	public int getMoney_gold() {
		return this.money_gold;
	}
	
	public void setMoney_gold(int money_gold) {
		this.money_gold = money_gold;
	}
		
	public int getMoney_bills() {
		return this.money_bills;
	}
	
	public void setMoney_bills(int money_bills) {
		this.money_bills = money_bills;
	}
		
}