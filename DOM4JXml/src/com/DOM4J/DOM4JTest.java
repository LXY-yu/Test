package com.DOM4J;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	public static void main(String[] args) {
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

}
