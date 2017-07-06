package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 返回家族boss结果
 **/
public class faction_boss_send_result extends AbstractCoder  {
	//结果标识
	private int result;
	//bossId
	private int boss_id;
	//家族资金变化量
	private int money;

	public faction_boss_send_result() {
		super(321);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.result);
		buffer.writeInt(this.boss_id);
		buffer.writeInt(this.money);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.result = buffer.readInt(); 
		this.boss_id = buffer.readInt(); 
		this.money = buffer.readInt(); 
	}
	
	public int getResult() {
		return this.result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
		
	public int getBoss_id() {
		return this.boss_id;
	}
	
	public void setBoss_id(int boss_id) {
		this.boss_id = boss_id;
	}
		
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
		
}