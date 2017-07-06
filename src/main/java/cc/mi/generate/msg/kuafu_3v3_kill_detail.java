package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 击杀数据
 **/
public class kuafu_3v3_kill_detail extends AbstractCoder  {
	//击杀者下标
	private int indx1;
	//被击杀者下标
	private int indx2;

	public kuafu_3v3_kill_detail() {
		super(250);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.indx1);
		buffer.writeInt(this.indx2);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.indx1 = buffer.readInt(); 
		this.indx2 = buffer.readInt(); 
	}
	
	public int getIndx1() {
		return this.indx1;
	}
	
	public void setIndx1(int indx1) {
		this.indx1 = indx1;
	}
		
	public int getIndx2() {
		return this.indx2;
	}
	
	public void setIndx2(int indx2) {
		this.indx2 = indx2;
	}
		
}