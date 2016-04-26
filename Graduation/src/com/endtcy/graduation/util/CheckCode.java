package com.endtcy.graduation.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import com.endtcy.graduation.base.BaseAction;

public class CheckCode extends BaseAction {
	private static final long serialVersionUID = 1L;

	InputStream sos;
	
	// 验证码图片的宽度。         
    private int width = 60;         
    // 验证码图片的高度。         
    private int height = 20;         
    // 验证码字符个数         
    private int codeCount = 4;         
    private int x = 0;         
    // 字体高度         
    private int fontHeight;         
    private int codeY;         
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };         
   
    /**       
     * 初始化验证图片属性       
     */        
    public void initxuan() throws ServletException {         
        String strWidth ="80";         
        String strHeight ="30";         
        String strCodeCount = "4";         
        // 将配置的信息转换成数值         
        try {         
            if (strWidth != null && strWidth.length() != 0) {         
                width = Integer.parseInt(strWidth);         
            }         
            if (strHeight != null && strHeight.length() != 0) {         
                height = Integer.parseInt(strHeight);         
            }         
            if (strCodeCount != null && strCodeCount.length() != 0) {         
                codeCount = Integer.parseInt(strCodeCount);         
            }         
        } catch (NumberFormatException e) {         
        }         
        x = width / (codeCount + 1);         
        fontHeight = height - 2;         
        codeY = height - 4;         
    }   
    
    public String execute() throws ServletException{ 
        initxuan();
        // 定义图像buffer         
        BufferedImage buffImg = new BufferedImage(width, height,         
                BufferedImage.TYPE_INT_RGB);         
        Graphics2D g = buffImg.createGraphics();         
        Random random = new Random();         
        g.setColor(Color.WHITE);         
        g.fillRect(0, 0, width, height);         
        // 创建字体，字体的大小应该根据图片的高度来定。         
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);         
        g.setFont(font);         
        // 画边框。         
        g.setColor(Color.BLACK);         
        g.drawRect(0, 0, width - 1, height - 1);         
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到。         
        g.setColor(Color.BLACK);         
        for (int i = 0; i < 10; i++) {         
            int x = random.nextInt(width);         
            int y = random.nextInt(height);         
            int xl = random.nextInt(12);         
            int yl = random.nextInt(12);         
            g.drawLine(x, y, x + xl, y + yl);         
        }         
        StringBuffer randomCode = new StringBuffer();         
        int red = 0, green = 0, blue = 0;         
        // 随机产生codeCount数字的验证码。         
        for (int i = 0; i < codeCount; i++) {         
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);         
            red = random.nextInt(255);         
            green = random.nextInt(255);         
            blue = random.nextInt(255);         
            g.setColor(new Color(red, green, blue));         
            g.drawString(strRand, (i + 1) * x, codeY);         
            randomCode.append(strRand);         
        }         
        // 将四位数字的验证码保存到Session中。                 
        session.put("validateCode", randomCode.toString());         
        // 禁止图像缓存。               
        // 将图像输出到Servlet输出流中。               
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        
        try {
			ImageIO.write(buffImg, "jpeg", bos);
		} catch (IOException e) {
			e.printStackTrace();
		}         
        byte[] b=bos.toByteArray();
        sos=new ByteArrayInputStream(b);
        return "success";
    }

	public InputStream getSos() {
		return sos;
	}

	public void setSos(InputStream sos) {
		this.sos = sos;
	}

	        
    
}