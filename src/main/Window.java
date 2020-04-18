package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;


public class Window extends Canvas {
		
	private static final long serialVersionUID = 1L;
	
	private Main main;
	
	public int graphX = 0, graphY = 0;
	public double zoom = 1.0;
	
	public JFrame frame = new JFrame();
	
	private UserInput input;	
		
	public Window(){
		main = Main.main;
		
		this.input = main.input;

		
		//this.setSize(800, 800);
		this.setBackground(Color.BLACK);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
		this.addKeyListener(input);
		this.addMouseWheelListener(input);
				
		//frame.setSize(800, 800);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		frame.requestFocus();
		
		this.requestFocus();
	}
	
	public void render(){
		BufferStrategy buff = this.getBufferStrategy();

		if (buff == null){
			this.createBufferStrategy(3);
			return;
		}
	
		Graphics g = buff.getDrawGraphics();
			
			main.topScreen.render(g);
			
		g.dispose();
		buff.show();
	}

	// positional functions
	public int centerX() {
		return getWidth()/2;
	}
	public int centerY() {
		return getHeight()/2;
	}
	public int left() {
		return 0;
	}
	public int right() {
		return getWidth();
	}
	public int top() {
		return 0;
	}
	public int bottom() {
		return getHeight();
	}
}
