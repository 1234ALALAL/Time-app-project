package screens;
import java.awt.Color;
import java.awt.Graphics;

import main.*;


public class TopScreen extends Widget{
	
	private Color background = new Color(150,150,150);
	
	public OptionMenu optionMenu;
	public BannerMenu bannerMenu;
	public ContentPane contentPane;
	
	
	public TopScreen() {
		super();
		this.graphic.setBounds(0, 0, Main.main.window.getWidth(), Main.main.window.getHeight());
		
		optionMenu = new OptionMenu(this);
		bannerMenu = new BannerMenu(this);
		contentPane = new ContentPane(this);
		
		this.addW(optionMenu, 1, 1);
		this.addW(bannerMenu, 0, 0);
		this.addW(contentPane, 2, 2);
	}

	public void render(Graphics g) {
		g.setColor(background);
		g.fillRect(graphic.x,graphic.y,graphic.width,graphic.height);
		renderSelf(g);
	}

	public void tick() {
		tickSelf();
	}

	public void close() {
		
	}
	
}
