package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 与NPC交流选择选项
 **/
public class gossip_select_option extends AbstractCoder  {
	//选项ID
	private int option;
	//NPCguid
	private int guid;
	//输入值
	private String unknow;

	public gossip_select_option() {
		super(51);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.option);
		buffer.writeInt(this.guid);
		StringCoder.writeString(buffer, this.unknow);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.option = buffer.readInt(); 
		this.guid = buffer.readInt(); 
		this.unknow = StringCoder.readString(buffer);
	}
	
	public int getOption() {
		return this.option;
	}
	
	public void setOption(int option) {
		this.option = option;
	}
		
	public int getGuid() {
		return this.guid;
	}
	
	public void setGuid(int guid) {
		this.guid = guid;
	}
		
	public String getUnknow() {
		return this.unknow;
	}
	
	public void setUnknow(String unknow) {
		this.unknow = unknow;
	}
		
}