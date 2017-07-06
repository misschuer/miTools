package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 禁言操作
 **/
public class player_gag extends AbstractCoder  {
	//玩家ID
	private String player_id;
	//结束时间
	private int end_time;
	//禁言理由
	private String content;

	public player_gag() {
		super(115);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.player_id);
		buffer.writeInt(this.end_time);
		StringCoder.writeString(buffer, this.content);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.player_id = StringCoder.readString(buffer);
		this.end_time = buffer.readInt(); 
		this.content = StringCoder.readString(buffer);
	}
	
	public String getPlayer_id() {
		return this.player_id;
	}
	
	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}
		
	public int getEnd_time() {
		return this.end_time;
	}
	
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
}