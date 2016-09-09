package com;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.swing.JOptionPane;

public class MyWeather {
	private static String getSoapRequest(String city) {
	     try {
	     InputStreamReader isr = new InputStreamReader(new FileInputStream("weather.xml"));
	     BufferedReader reader = new BufferedReader(isr);
	     String soap = "";
	     String tmp;
	     while ((tmp = reader.readLine()) != null) {
	      soap += tmp;
	     }
	     reader.close();
	     isr.close();
	     return soap.replace("${city}$", city);
	     } catch (Exception ex) {
	     ex.printStackTrace();
	     return null;
	     }
	     }
	     private static InputStream getSoapInputStream(String city)throws Exception
	         {
	             try
	             {
	                 String soap =getSoapRequest(city);
	                 if(soap==null)
	                 {
	                     return null;
	                 }
	                 URL url=new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
	                 //URL url=new URL("http://flash.weather.com.cn/wmaps/xml/china.xml");
	             
	                 URLConnection conn=url.openConnection();
	                 conn.setUseCaches(false);
	                 conn.setDoInput(true);
	                 conn.setDoOutput(true);

	                 conn.setRequestProperty("Content-Length", Integer.toString(soap.length()));
	                 conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	                 conn.setRequestProperty("SOAPAction","http://WebXml.com.cn/getWeatherbyCityName");

	                 OutputStream os=conn.getOutputStream();
	                 OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
	                 //osw.write(new String(soap.getBytes(),"utf-8"));
	                 osw.write(soap);
	                 osw.flush();
	                 osw.close();

	                 InputStream is=conn.getInputStream();
	                 return is;
	             }
	             catch(Exception e)
	             {
	                 e.printStackTrace();
	                 return null;
	             }
	    }
	    public static String getWeather(String city)
	   {
	       try
	       {
	           Document doc;
	           DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	           dbf.setNamespaceAware(true);
	           DocumentBuilder db=dbf.newDocumentBuilder();
	           InputStream is=getSoapInputStream(city);
	           doc=db.parse(is);
	           NodeList nl=doc.getElementsByTagName("getWeatherbyCityNameResult");
	           Node n=nl.item(0);
	           //JOptionPane.showMessageDialog(null,n.getChildNodes().getLength());
	           for (int i=0;i<n.getChildNodes().getLength()-1;i++)
	           {
	             String weather=n.getChildNodes().item(i).getTextContent();
	             System.out.print(weather);
	           }
	           is.close();
	           return "null";
	       }
	       catch(Exception e)
	       {
	           e.printStackTrace();
	           return null;
	       }
	   }
	   public static void main (String [] args )throws Exception
	   {
	       //System.out.println(MyWeather.getWeather("ÉÏº£"));
	       MyWeather.getWeather("¾£ÖÝ");
	   }

}
