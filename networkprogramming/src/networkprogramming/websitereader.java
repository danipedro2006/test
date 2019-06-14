package networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

public class websitereader
	{
		public static void main(String[] args) throws UnsupportedEncodingException, IOException
			{
				URL url=null;
				URLConnection urlConn=null;
				url=new URL("http://www.google.com");
				urlConn=url.openConnection();
				InputStreamReader inStream=new InputStreamReader(urlConn.getInputStream(), "UTF8");
				BufferedReader buff=new BufferedReader(inStream);
				String currentLine;
				while((currentLine=buff.readLine())!=null)
					{
						System.out.println(currentLine);
					}
			}
	}
