package widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Widget;

public class Text extends Widget{
	
	private String content;
	private String font_text;
	private int size;
	private Color color;
	private Font font;
	
	public Text(int x, int y, String content, int size, String font, Color color) {
		super();
		this.graphic.setBounds(x, y, 0, 0);
		this.content = content;
		font_text = font;
		this.font = new Font(font, Font.BOLD, size);
		this.size = size;
		this.color = color;
	}
	
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		g.setColor(color);
		g.drawString(content, graphic.x, graphic.y);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
