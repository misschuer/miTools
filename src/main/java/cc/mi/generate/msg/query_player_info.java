package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 查询玩家信息
 **/
public class query_player_info extends AbstractCoder  {
	//玩家guid
	private String guid;
	//每一位表示玩家各种信息
	private int flag;
	//回调ID
	private int callback_id;

	public query_player_info() {
		super(95);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.guid);
		buffer.writeInt(this.flag);
		buffer.writeInt(this.callback_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guid = StringCoder.readString(buffer);
		this.flag = buffer.readInt(); 
		this.callback_id = buffer.readInt(); 
	}
	
	public String getGuid() {
		return this.guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
	public int getFlag() {
		return this.flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
		
	public int getCallback_id() {
		return this.callback_id;
	}
	
	public void setCallback_id(int callback_id) {
		this.callback_id = callback_id;
	}
		
}