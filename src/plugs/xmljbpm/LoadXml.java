package plugs.xmljbpm;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class LoadXml {

	public Document load(String fileName){
		SAXReader saxReader = new SAXReader();

		try {
			return  saxReader.read(this.getClass().getResource(
					fileName).getFile());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}