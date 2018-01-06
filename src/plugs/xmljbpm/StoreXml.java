package plugs.xmljbpm;

import java.io.FileWriter;
import java.io.IOException;


import org.dom4j.Document;
public class StoreXml {
	public void store(Document doc,String fileName){
		String path = this.getClass().getResource(fileName).getPath();
		System.out.println(path);
		FileWriter fw;
		try {
			System.out.println(doc.asXML());
			fw = new FileWriter(path);
			fw.write(new String(doc.asXML().getBytes("iso8859-1"),"gbk"));
//			fw.write(new String(doc.asXML().getBytes("gbk"),"utf-8"));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
