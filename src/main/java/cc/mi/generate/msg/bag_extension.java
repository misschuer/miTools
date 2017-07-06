package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 背包扩展
 **/
public class bag_extension extends AbstractCoder  {
	//包裹
	private byte bag_id;
	//扩展类型
	private byte extension_type;
	//开启位置
	private int bag_pos;

	public bag_extension() {
		super(40);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeByte(this.bag_id);
		buffer.writeByte(this.extension_type);
		buffer.writeInt(this.bag_pos);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.bag_id = buffer.readByte(); 
		this.extension_type = buffer.readByte(); 
		this.bag_pos = buffer.readInt(); 
	}
	
	public byte getBag_id() {
		return this.bag_id;
	}
	
	public void setBag_id(byte bag_id) {
		this.bag_id = bag_id;
	}
		
	public byte getExtension_type() {
		return this.extension_type;
	}
	
	public void setExtension_type(byte extension_type) {
		this.extension_type = extension_type;
	}
		
	public int getBag_pos() {
		return this.bag_pos;
	}
	
	public void setBag_pos(int bag_pos) {
		this.bag_pos = bag_pos;
	}
		
}