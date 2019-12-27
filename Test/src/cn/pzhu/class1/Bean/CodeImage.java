package cn.pzhu.class1.Bean;

import java.awt.image.BufferedImage;

public class CodeImage {
	public CodeImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CodeImage(String code, BufferedImage image) {
		super();
		this.code = code;
		this.image = image;
	}

	private String code;
	private BufferedImage image;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
