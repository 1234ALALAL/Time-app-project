package screens;

import java.awt.Color;
import java.awt.Graphics;


import main.Widget;
import widgets.Text;

public class ContentPane extends Widget{
	
	private Widget subject;
	
	public ContentPane(Widget parent) {
		super(parent);
		graphic.setBounds(350, 20, parent.graphic.getHeight(), parent.graphic.getHeight());
		subject = new Text(xrel(400), yrel(320), "Nothing to show", 20, "Arael Black", new Color(50,50,50));
	}
	
	public void setSubject(Widget subject) {
		this.subject = subject;
	}
	
	public Widget getSubject() {
		return subject;
	}

	public void render(Graphics g) {
		subject.render(g);
	}

	public void tick() {
		
	}

	public void close() {
		
	}
	
}
