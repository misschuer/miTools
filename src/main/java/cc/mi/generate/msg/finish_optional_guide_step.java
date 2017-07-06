package cc.mi.generate.msg;

import io.netty.buffer.ByteBuf;
import cc.mi.core.coder.AbstractCoder;

/**
 * 完成非强制引导的步骤
 **/
public class finish_optional_guide_step extends AbstractCoder  {
	//引导id
	private int guide_id;
	//引导分步骤
	private byte step;

	public finish_optional_guide_step() {
		super(301);
	}
	
	@Override
	public void encode(ByteBuf buffer) {
		buffer.writeInt(this.guide_id);
		buffer.writeByte(this.step);
	}

	@Override
	public void decode(ByteBuf buffer) {
		this.guide_id = buffer.readInt(); 
		this.step = buffer.readByte(); 
	}
	
	public int getGuide_id() {
		return this.guide_id;
	}
	
	public void setGuide_id(int guide_id) {
		this.guide_id = guide_id;
	}
		
	public byte getStep() {
		return this.step;
	}
	
	public void setStep(byte step) {
		this.step = step;
	}
		
}