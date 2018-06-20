package edu.handong.csee.java.AdditionalHW;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLmaker {
	public void makeHTMLfile(String directory, String Information) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(directory + "/index.html")));
			bw.write(Information);
			System.out.println(directory + "/index.html 파일을 형성하는데 성공하였습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}

	}
}
