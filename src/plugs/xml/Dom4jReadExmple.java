package plugs.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 利用dom4j进行XML编程
 * @author cuiweibing
 * @since 2007.8.10
 */
public class Dom4jReadExmple {
	/**
	 * 遍历整个XML文件，获取所有节点的值与其属性的值，并放入HashMap中
	 * @param filename String 待遍历的XML文件（相对路径或者绝对路径）
	 * @param hm       HashMap 存放遍历结果，格式：<nodename,nodevalue>或者<nodename+attrname,attrvalue>
	 */
	public void iterateWholeXML(String filename, HashMap<String, String> hm) {
		SAXReader saxReader = new SAXReader();
		try {
			System.out.println(this.getClass().getResource(filename).getFile());

			Document document = saxReader.read(this.getClass().getResource(
					filename).getFile());
			Element root = document.getRootElement();
			//   用于记录学生编号的变量
			int num = -1;
			//遍历根结点（students）的所有孩子节点（肯定是student节点）
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				num++;
				// 获取person节点的age属性的值
				Attribute ageAttr = element.attribute("age");
				if (ageAttr != null) {
					String age = ageAttr.getValue();
					if (age != null && !age.equals("")) {
						hm.put(element.getName() + "-" + ageAttr.getName()
								+ num, age);
					} else {
						hm.put(element.getName() + "-" + ageAttr.getName()
								+ num, "20");
					}
				} else {
					hm.put(element.getName() + "-age" + num, "20");
				}
				//遍历student结点的所有孩子节点（即name，college，telphone，notes），并进行处理
				for (Iterator iterInner = element.elementIterator(); iterInner
						.hasNext();) {
					Element elementInner = (Element) iterInner.next();
					if (elementInner.getName().equals("college")) {
						hm.put(elementInner.getName() + num, elementInner
								.getText());
						//获取college节点的leader属性的值
						Attribute leaderAttr = elementInner.attribute("leader");
						if (leaderAttr != null) {
							String leader = leaderAttr.getValue();
							if (leader != null && !leader.equals("")) {
								hm.put(elementInner.getName() + "-"
										+ leaderAttr.getName() + num, leader);
							} else {
								hm.put(elementInner.getName() + "-"
										+ leaderAttr.getName() + num, "leader");
							}
						} else {
							hm.put(elementInner.getName() + "-leader" + num,
									"leader");
						}
					} else {
						hm.put(elementInner.getName() + num, elementInner
								.getText());
					}
				}
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}