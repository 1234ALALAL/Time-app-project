package screens;

import java.awt.Color;
import java.awt.Graphics;

import main.Widget;
import widgets.Button;
import widgets.Text;

public class OptionMenu extends Widget{
	
	private Color background = new Color(100,100,100);
	
	public static final int OPTION_HEIGHT = 50;
	
	
	public OptionMenu(Widget parent) {
		super(parent);
		graphic.setBounds(0, 20, 350, parent.graphic.getHeight());
		
		addW(new OptionButton(1, "DashBoard",this), 0, 0);
		addW(new OptionButton(2, "Calendar",this), 0, 0);
		addW(new OptionButton(3, "Schedular",this), 0, 0);
		addW(new OptionButton(4, "Manager",this), 0, 0);
		addW(new OptionButton(5, "Tasks",this), 0, 0);
		addW(new OptionButton(6, "Timer",this), 0, 0);
		addW(new OptionButton(7, "Review",this), 0, 0);
	}
	
	public void render(Graphics g) {
		g.setColor(background);
		g.fillRect(graphic.x, graphic.y, graphic.width, graphic.height);
		renderSelf(g);
	}

	public void tick() {
		tickSelf();
	}

	public void close() {
		
	}
	
	private class OptionButton extends Button {
				
		public OptionButton(int index, String text, OptionMenu opt) {
			super(
					opt.graphic.x, 
					opt.graphic.y + (index-1)*OptionMenu.OPTION_HEIGHT + 20, 
					opt.graphic.width, 
					OptionMenu.OPTION_HEIGHT - 1,
					new Text(
							opt.graphic.x + 30, 
							opt.graphic.y + index*OptionMenu.OPTION_HEIGHT, 
							text, 
							OptionMenu.OPTION_HEIGHT - 30, 
							"arial black", 
							new Color(255,165,0)
							),
					opt.background
					);
			
		}
		
		@Override
		public void act() {
			
		}
	}

}
