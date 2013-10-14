package com.test.methods;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.omg.CORBA.portable.InputStream;
/**
 * 
 * @author starwang
 * XML ����
 */
public class XML {
	 public static String doc2String(Document doc) throws Exception {    //documentת�ַ��� 
	        Format format = Format.getPrettyFormat();     
	        format.setEncoding("UTF-8");// ����xml�ļ����ַ�ΪUTF-8�������������     
	        XMLOutputter xmlout = new XMLOutputter(format);     
	        ByteArrayOutputStream bo = new ByteArrayOutputStream();     
	        xmlout.output(doc, bo);     
	        return bo.toString();     
	    }     
	   public static Document string2Doc(String xmlStr) throws Exception {   //�ַ��� תdocument  
	        java.io.Reader in = new StringReader(xmlStr);     
	        Document doc = (new SAXBuilder()).build(in);            
	        return doc;     
	    }  
	public static void createDoc() throws Exception {
		   Element carEl = new Element("car");
		    //����vin���ԣ�������ֵ
		    carEl.setAttribute("vin", "123fhg5869705iop90");
		    
		    //����ע��
		    carEl.addContent(new Comment("Description of a car"));
		    
		    //����һ��makeԪ�أ������ı�����
		    carEl.addContent(new Element("make").setText("Toyota"));
		    
		    //����һ��modelԪ�أ����һ���ı�Ԫ��
		    carEl.addContent(new Element("model").setContent(new Text("Celica")));
		    
		    //����һ��yearԪ�أ�����ı�����
		    carEl.addContent(new Element("year").addContent("1997"));
		    
		    //����һ��colorԪ�أ��ı�������green
		    carEl.addContent(new Element("color").setText("green"));
		    
		    //����һ��license��Ԫ��
		    Element licenseEl = new Element("license");
		    //ΪlicenseԪ������ı�����
		    licenseEl.addContent("1ABC234");
		    //����һ��state�����ԣ�ֵΪCA
		    licenseEl.setAttribute("state", "CA");
		    //��licenseEl��ӵ���Ԫ����
		    carEl.addContent(licenseEl);
		    
		    //��carԪ������Ϊ��Ԫ��
		    Document doc = new Document(carEl);
		    //System.out.print(doc.getDocument().toString());
		    XMLOutputter output = new XMLOutputter(); //2��ָ����2���ַ���true��ʾ�û��У�������ǿ�ɶ��� 
		    FileOutputStream out = new FileOutputStream("dsf.xml"); 
		    output.output(doc, out);
	
	
	}
	public static void readXMLContent(Document doc) {
	  //  SAXBuilder builder = new SAXBuilder();
	    try {
	       // Document doc = builder.build(new File("dsf.xml"));
	        Element rootEl = doc.getRootElement();
	        //���������Ԫ��
	        @SuppressWarnings("unchecked")
			List<Element> list = rootEl.getChildren();
	        //List<Element> list = rootEl.getChildren("disk");
	        for (Element el : list) {
	            //��ȡname����ֵ
	            String name = el.getAttributeValue("name");
	            //��ȡ��Ԫ��capacity�ı�ֵ
	            String capacity = el.getChildText("title");
	            //��ȡ��Ԫ��directories�ı�ֵ
	            String directories = el.getChildText("make");
	            String files = el.getChildText("files");
	            System.out.println(el.getText());
	            System.out.println(el.getChildren());
	            System.out.println("��������:" + capacity);
	            System.out.println("Ŀ¼��:" + directories);
	            System.out.println("�ļ���:" + files);
	            System.out.println("-----------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	 public static void readNode(Element root, String prefix) {  
	        if (root == null) return;  
	        // ��ȡ����  
	        List<Attribute> attrs = root.getAttributes();  
	        if (attrs != null && attrs.size() > 0) {  
	            System.err.print(prefix);  
	            for (Attribute attr : attrs) {  
	                System.err.print(attr.getValue() + " ");  
	            }  
	            System.err.println();  
	        }  
	        // ��ȡ�����ӽڵ�  
	        List<Element> childNodes = root.getChildren();  
	        prefix += "\t";  
	        for (Element e : childNodes) {  
	            readNode(e, prefix);  
	        }  }
	public static void main(String[] args) throws Exception {
        String s = "<?xml version=\"1.0\" encoding=\"GBK\"?><result><status>0</status></result>";
        	int a=s.indexOf("<?"); 
        	int b=s.indexOf("?>")+2;
        	System.out.print(s.substring(b));
//		 SAXBuilder builder = new SAXBuilder(false);  
//		java.io.InputStream in = XML.class.getClassLoader().getResourceAsStream("struts.xml");  
//        Document doc = string2Doc(s);  
//       
//        // ��ȡ���ڵ� <university>  
////        Element root = doc.getRootElement();  
////        readNode(root, ""); 
//        System.out.print(doc.getRootElement().getChildText("status"));
	//readXMLContent();
        
	}

}
