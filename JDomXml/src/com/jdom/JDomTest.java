package com.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Attribute;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest {
	private static ArrayList<Book>booksList=new ArrayList<Book>();
	
	/*
	 * 解析xml
	 */
	private void parseXML(){
		//进行对books.xml文件的JDom解析
		//准备工作
		//1.创建一个saxBuilder的对象
		SAXBuilder saxBuilder=new SAXBuilder();
		//2.创建一个输入流，将xml文件加载到输入流中
		InputStream in;
		try {
			in = new FileInputStream("books.xml");
			InputStreamReader isr=new InputStreamReader(in, "UTF-8");//解决乱码问题
			//3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
			Document document=saxBuilder.build(isr);
			//4.通过document对象获取xml文件的根节点
			Element rootElement=document.getRootElement();
			//5.获取根节点下的子节点的List集合
			List<Element>bookList=rootElement.getChildren();
			//继续进行解析
			for(Element book:bookList){
				Book bookEntity=new Book();
				System.out.println("======开始解析第"+(bookList.indexOf(book)+1)+"本书======");
				//解析book的属性集合
				List<org.jdom2.Attribute>attrList=book.getAttributes();
				// //知道节点下属性名称时，获取属性值
				//book.getAttribute("id");
				//遍历attrList(针对不清楚book节点下的属性的名字及数量）
				for(org.jdom2.Attribute attr:attrList){
					//获取属性名
					String attrName=attr.getName();
					//获取属性值
					String attrValue=attr.getValue();
					System.out.println("属性名："+attrName+"----属性值："+attrValue);
					if(attrName.equals("id")){
						bookEntity.setId(attrValue);
					}
				}
				//对book节点的子节点的节点名以及节点值的遍历
				List<Element>bookChilds=book.getChildren();
				for(Element child:bookChilds){
					System.out.println("节点名："+child.getName()+"----节点值："+child.getValue());
					if(child.getName().equals("name")){
						bookEntity.setName(child.getValue());
					}else if(child.getName().equals("author")){
						bookEntity.setAuthor(child.getValue());
					}else if(child.getName().equals("year")){
						bookEntity.setYear(child.getValue());
					}else if(child.getName().equals("price")){
						bookEntity.setPrice(child.getValue());
					}else if(child.getName().equals("language")){
						bookEntity.setLanguage(child.getValue());
					}
				}
				
				System.out.println("======结束解析第"+(bookList.indexOf(book)+1)+"本书======");
				booksList.add(bookEntity);
				bookEntity=null;
				System.out.println(booksList.size());
				System.out.println(booksList.get(0).getId());
				System.out.println(booksList.get(0).getName());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*
	 * 创建xml文件
	 */
	private void createXML(){
		//1.先生成一个根节点
		Element rss=new Element("rss");
		//2.为节点添加属性
		rss.setAttribute("version", "2.0");
		//3.生成一个document对象
		Document document=new Document(rss);
		
		Element channel=new Element("channel");
		rss.addContent(channel);
		Element title=new Element("title");
		title.setText("国内最新新闻");
		channel.addContent(title);
		//设置xml样式
		Format format=Format.getCompactFormat();
		format.setIndent("");//换行
		format.setEncoding("GBK");
		
		//4.创建XMLOutputter的对象
		XMLOutputter outputter=new XMLOutputter(format);
		//5.利用outputter将document对象转换成xml文档
		try {
			outputter.output(document,new FileOutputStream(new File("rssnews.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		JDomTest jt=new JDomTest();
		jt.parseXML();
		jt.createXML();

	}

}
