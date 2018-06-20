package edu.handong.csee.java.AdditionalHW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class URLReader {
	public String getInformationFromWeb(String url) {
		BufferedReader in = null;

		String totalInformation = null;
		try {
			URL obj = new URL(url); // 호출할 url
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			String line;
			while ((line = in.readLine()) != null) { // response를 차례대로 출력
				totalInformation += (line + "\n");
				// System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return totalInformation;
	}
}
