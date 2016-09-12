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
	 * ����xml�ļ�
	 */
	public void parseXML(){
		// ����book.xml�ļ�
				//����SAXReader����
				SAXReader reader=new SAXReader();
				try {
					//ͨ��reader�����read��������book.xml�ļ�����ȡdocument����
					Document document=reader.read(new File("books.xml"));
					//ͨ��document�����ȡ���ڵ�bookstore
					Element bookStore=document.getRootElement();
					//ͨ��element�����elementIterator������ȡ������
					Iterator it=bookStore.elementIterator();
					//��������������ȡ���ڵ��е���Ϣ���鼮��
					while(it.hasNext()){
						System.out.println("====��ʼ����ĳһ����====");
						Element book=(Element) it.next();
						//��ȡbook��������������ֵ
						List<Attribute>bookAttrs=book.attributes();
						for(Attribute attr:bookAttrs){
							System.out.println("��������"+attr.getName()+"----����ֵ��"+attr.getValue());	
						}
						Iterator itt=book.elementIterator();
						while(itt.hasNext()){
							Element bookChild=(Element) itt.next();
							System.out.println("�ڵ�����"+bookChild.getName()+"----�ڵ�ֵ��"+bookChild.getStringValue());
							
						}
						System.out.println("====��������ĳһ����====");	
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
		//����һ��document���󣬴�������xml�ĵ�
		Document document=DocumentHelper.createDocument();
		//2.�������ڵ�
		Element rss=document.addElement("rss");
		//3.��rss�ڵ������version����
		rss.addAttribute("version", "2.0");
		//4.�����ӽڵ㼰�ڵ�����
		Element channel=rss.addElement("channel");
		channel.addElement("title");
		Element title=channel.addElement("title");
		title.setText("������������");
		//��������xml�ļ��ĸ�ʽ
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		//5.����xml�ļ�
		File file=new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
			writer.setEscapeText(false);//�����Ƿ�ת�壨�����ַ���������ţ���Ĭ����yes
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
