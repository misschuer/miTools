package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 玩家使用游戏对象以后的动作
 **/
public class use_gameobject_action extends AbstractCoder  {
	//玩家ID
	private int player_id;
	//游戏对象ID
	private int gameobject_id;

	public use_gameobject_action() {
		super(72);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.player_id);
		buffer.writeInt(this.gameobject_id);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.player_id = buffer.readInt(); 
		this.gameobject_id = buffer.readInt(); 
	}
	
	public int getPlayer_id() {
		return this.player_id;
	}
	
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
		
	public int getGameobject_id() {
		return this.gameobject_id;
	}
	
	public void setGameobject_id(int gameobject_id) {
		this.gameobject_id = gameobject_id;
	}
		
}