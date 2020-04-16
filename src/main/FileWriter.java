package main;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileWriter {
	
	private File file;
	private BufferedWriter writer; 
	
	private int indent = 0;
	
	public FileWriter(File file){
		this.file = file;
		try {
			writer = new BufferedWriter(new java.io.FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public FileWriter(String file){
		this.file = new File(file);
		try {
			writer = new BufferedWriter(new java.io.FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getIndent() {
		return indent;
	}
	public void setIndent(int i) {
		indent = i;
	}
	public void indentIn() {
		indent++;
	}
	public void indentOut() {
		indent--;
	}
	public void write(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void write(String identifier, String data) {
		try {
			String s = "";
			for(int i=0; i<indent; i++)
				s = s+"\t";
			s = s+identifier+": "+data;
			writer.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void write(int i, String identifier, String data) {
		indent = i;
		write(identifier,data);
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
