package com.DOM4J;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {
	/*
	 * 解析xml文件
	 */
	public void parseXML(){
		// 解析book.xml文件
				//创建SAXReader对象
				SAXReader reader=new SAXReader();
				try {
					//通过reader对象的read方法加载book.xml文件，获取document对象
					Document document=reader.read(new File("books.xml"));
					//通过document对象获取根节点bookstore
					Element bookStore=document.getRootElement();
					//通过element对象的elementIterator方法获取迭代器
					Iterator it=bookStore.elementIterator();
					//遍历迭代器，获取根节点中的信息（书籍）
					while(it.hasNext()){
						System.out.println("====开始遍历某一本书====");
						Element book=(Element) it.next();
						//获取book的属性名和属性值
						List<Attribute>bookAttrs=book.attributes();
						for(Attribute attr:bookAttrs){
							System.out.println("属性名："+attr.getName()+"----属性值："+attr.getValue());	
						}
						Iterator itt=book.elementIterator();
						while(itt.hasNext()){
							Element bookChild=(Element) itt.next();
							System.out.println("节点名："+bookChild.getName()+"----节点值："+bookChild.getStringValue());
							
						}
						System.out.println("====结束遍历某一本书====");	
					}
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	/*
	 * 
	 */
	private void createXML(){
		//创建一个document对象，代表整个xml文档
		Document document=DocumentHelper.createDocument();
		//2.创建根节点
		Element rss=document.addElement("rss");
		//3.向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		//4.生成子节点及节点内容
		Element channel=rss.addElement("channel");
		channel.addElement("title");
		Element title=channel.addElement("title");
		title.setText("国内最新新闻");
		//设置生成xml文件的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		//5.生成xml文件
		File file=new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
			writer.setEscapeText(false);//设置是否转义（特殊字符比如尖括号），默认是yes
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		DOM4JTest dj=new DOM4JTest();
		dj.parseXML();
		dj.createXML();

	}

}
