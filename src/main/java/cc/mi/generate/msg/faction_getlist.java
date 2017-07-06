package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 获取帮派列表
 **/
public class faction_getlist extends AbstractCoder  {
	//当前页
	private byte page;
	//每页数量
	private byte num;
	//自动过滤
	private byte grep;

	public faction_getlist() {
		super(184);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.page);
		buffer.writeByte(this.num);
		buffer.writeByte(this.grep);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.page = buffer.readByte(); 
		this.num = buffer.readByte(); 
		this.grep = buffer.readByte(); 
	}
	
	public byte getPage() {
		return this.page;
	}
	
	public void setPage(byte page) {
		this.page = page;
	}
		
	public byte getNum() {
		return this.num;
	}
	
	public void setNum(byte num) {
		this.num = num;
	}
		
	public byte getGrep() {
		return this.grep;
	}
	
	public void setGrep(byte grep) {
		this.grep = grep;
	}
		
}