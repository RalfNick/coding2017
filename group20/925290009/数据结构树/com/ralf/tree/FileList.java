package com.ralf.tree;

import java.io.File;

public class FileList {
	public void list(File file){
		list(file,0);
	}

	private void list(File file, int depth) {
		printName(file,depth);
		if (file.isDirectory()) {
			File[] files  = file.listFiles();
			for(File f : files){
				list(f, depth + 1);
			}
		}
	}

	private void printName(File file,int depth) {
		
		String name = file.getName();
		for (int i = 0; i < depth; i++)
			System.out.print("+");
		if (file.isDirectory()) {
			System.out.println("Dir:" + name);
		}
		else {
			System.out.println(name + " " + file.length());
		}
	}
	
	public static void main(String[] args) {
		FileList fileList = new FileList();
		File file = new File("D:\\1");
		fileList.list(file);
	}
	
}
