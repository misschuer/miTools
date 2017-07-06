package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;
import cc.mi.core.coder.StringCoder;

/**
 * 后台弹窗
 **/
public class gm_rightfloat extends AbstractCoder  {
	//ID
	private int id;
	//结束时间
	private int end_time;
	//0-7点
	private int zone1;
	//8-13点
	private int zone2;
	//14-23点
	private int zone3;
	//标题
	private String subject;
	//内容
	private String content;
	//链接地址
	private String link;
	//模式 0:根据zone1，zone2，zone3设置的时间段弹 1:进入游戏1分钟后弹
	private byte mode;

	public gm_rightfloat() {
		super(111);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.id);
		buffer.writeInt(this.end_time);
		buffer.writeInt(this.zone1);
		buffer.writeInt(this.zone2);
		buffer.writeInt(this.zone3);
		StringCoder.writeString(buffer, this.subject);
		StringCoder.writeString(buffer, this.content);
		StringCoder.writeString(buffer, this.link);
		buffer.writeByte(this.mode);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.id = buffer.readInt(); 
		this.end_time = buffer.readInt(); 
		this.zone1 = buffer.readInt(); 
		this.zone2 = buffer.readInt(); 
		this.zone3 = buffer.readInt(); 
		this.subject = StringCoder.readString(buffer);
		this.content = StringCoder.readString(buffer);
		this.link = StringCoder.readString(buffer);
		this.mode = buffer.readByte(); 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getEnd_time() {
		return this.end_time;
	}
	
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
		
	public int getZone1() {
		return this.zone1;
	}
	
	public void setZone1(int zone1) {
		this.zone1 = zone1;
	}
		
	public int getZone2() {
		return this.zone2;
	}
	
	public void setZone2(int zone2) {
		this.zone2 = zone2;
	}
		
	public int getZone3() {
		return this.zone3;
	}
	
	public void setZone3(int zone3) {
		this.zone3 = zone3;
	}
		
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
		
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
		
	public byte getMode() {
		return this.mode;
	}
	
	public void setMode(byte mode) {
		this.mode = mode;
	}
		
}