package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 杀人啦~~！！！！
 **/
public class kill_man extends AbstractCoder  {
	//杀人者
	private String killer;
	//杀人者名字
	private String killer_name;
	//被杀者
	private String victim;
	//被杀者名字
	private String victim_name;

	public kill_man() {
		super(105);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		StringCoder.writeString(buffer, this.killer);
		StringCoder.writeString(buffer, this.killer_name);
		StringCoder.writeString(buffer, this.victim);
		StringCoder.writeString(buffer, this.victim_name);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.killer = StringCoder.readString(buffer);
		this.killer_name = StringCoder.readString(buffer);
		this.victim = StringCoder.readString(buffer);
		this.victim_name = StringCoder.readString(buffer);
	}
	
	public String getKiller() {
		return this.killer;
	}
	
	public void setKiller(String killer) {
		this.killer = killer;
	}
		
	public String getKiller_name() {
		return this.killer_name;
	}
	
	public void setKiller_name(String killer_name) {
		this.killer_name = killer_name;
	}
		
	public String getVictim() {
		return this.victim;
	}
	
	public void setVictim(String victim) {
		this.victim = victim;
	}
		
	public String getVictim_name() {
		return this.victim_name;
	}
	
	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}
		
}