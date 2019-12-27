package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import cn.pzhu.class1.Bean.CodeImage;

public class ImageUtil {
	public static CodeImage createImage(int width,int height,int n){
		CodeImage codeImage = null;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		
		Font font = new Font("Arial",Font.BOLD,24);
		g.setFont(font);
		
		char[] c="0123456789qwertyuiopasdfghjklzxcvbnm".toCharArray();
		String code="";
		Random random=new Random();
		for(int i=0;i<n;i++){
			int index=random.nextInt(c.length);
			code+=c[index];
		}
		g.drawString(code, width/10, height/3*2);
		codeImage=new CodeImage(code, image);
		
		return codeImage;
	}
}
