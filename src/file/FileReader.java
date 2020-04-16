package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {
	private Scanner scanner;
	private File file;
	
	private int line = 0, indent = 0;
	
	private String identifier, string;
	private String[] data;
	
	public FileReader(File file){
		this.file = file;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.useDelimiter("\n");
		next();
	}
	public FileReader(String filePath) {
		file = new File(filePath);
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.useDelimiter("\n");
		next();
	}
	public void next() {
		try {
			string = scanner.nextLine();
		} catch(NoSuchElementException e) {
			System.out.println("could not find line");
			string = "-";
		}
		line++;
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
	public void next(String identifier) {
		while(!this.identifier.equals(identifier)) next();	
	}
	
	public String getName() {
		return identifier;
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
	
	public void reset() {
		scanner.reset();
		line = 0;
	}
	public void close() {
		scanner.close();
	}
	
}







