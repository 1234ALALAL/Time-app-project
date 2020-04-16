package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileData {
	
	private File file;
	
	private ArrayList<Line> fileContent = new ArrayList<>();
	
	private int line = 0;
	private int indent = 0;
	private String identifier, string;
	private String[] data;
	
	private class Line {
		public String string;
		public int indent;
		public String identifier;
		public String[] data;
		public Line(int in, String id, String[] dat) {
			indent = in; identifier = id; data = dat;
			string = getLineFromData(in,id,dat);
		}
		public Line(String string) {
			this.string = string;
			for (indent = 0; string.charAt(indent)=='\t'; indent++);
			String[] parts = string.split(":", 2);
			identifier = parts[0].trim();
			if(parts.length == 1) {
				data = parts[0].split(",");
				identifier = "-";
			} else {
				data = parts[1].split(",");
			}
			for (int i=0; i<data.length; i++)
				data[i] = data[i].trim();
		}
	}
	
	private FileData(File file) {
		this.file = file;
		drawContent();
	}
	private FileData(String file) {
		this.file = new File(file);
		drawContent();
	}
	
	public void drawContent() {
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				fileContent.add(new Line(sc.next()));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(int i=0; i<fileContent.size(); i++)
				writer.write(fileContent.get(i).string+"\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void open(String identifier) {
		
	}
	public void open(int line) {
		this.line = line;
	}
	public void nextLine() {
		line++;
	}
	public String getLineName() {
		return fileContent.get(line).identifier;
	}
	public String getData() {
		return data[0];
	}
	public String getData(int i) {
		return data[i];
	}
	public String[] getAllData() {
		return data;
	}
	public int getLine() {
		return line;
	}
	public int getIndent() {
		return indent;
	}
	public String getString(){
		return string;
	}
	
	
	
	
	
	
	
	public String getLineFromData(int indent, String identifier, String[] data) {
		String s = "";
		for(int i=0; i<indent; i++)
			s = s+"\t";
		s = s+identifier+": ";
		for(int i=0; i<data.length-1; i++) {
			s = s+data[i]+", ";
		}
		s = s+data[data.length-1];
		return s;
	}
	public String getLineFromData(int indent, String identifier, String data) {
		String s = "";
		for(int i=0; i<indent; i++)
			s = s+"\t";
		s = s+identifier+": "+data;
		return s;
	}
	
	
}
