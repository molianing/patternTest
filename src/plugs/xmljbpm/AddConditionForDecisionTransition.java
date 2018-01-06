package plugs.xmljbpm;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Attribute;


public class AddConditionForDecisionTransition {
	public final String ELEMENT_NAME_FIRST = "decision" ;
	public final String ELEMENT_NAME_SECOND = "transition" ;
	public final String ELEMENT_NAME_THREE = "condition" ;
	public final String CONDITION_ATTRIBUTE_NAME  = "expr" ;
	public final String CONDITION_ATTRIBUTE_VALUE_NO = "#{userIdea=='no'}" ;
	public final String CONDITION_ATTRIBUTE_VALUE_YES = "#{userIdea=='yes'}" ;

	public Document addCondition(Document doc,String valueOfTransitionName){

		Element root = doc.getRootElement();
		for (Iterator iter = root.elementIterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			if(element.getName().matches(this.ELEMENT_NAME_FIRST)){
				Element second = this.getChildByNodeAndName(element, this.ELEMENT_NAME_SECOND,"name", valueOfTransitionName);
				if(second!=null){
					Element three = second.addElement(ELEMENT_NAME_THREE);
					three.addAttribute(CONDITION_ATTRIBUTE_NAME, CONDITION_ATTRIBUTE_VALUE_NO);
				}
			}
		}
		
		return doc ;
	}
	public Element getChildByNodeAndName(Element ele,String nodeName,String attributeName,String attributeValue){

		for (Iterator iter = ele.elementIterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			if(element.getName().matches(nodeName)){
				Attribute secondsAttri = element.attribute(attributeName);
				if(secondsAttri.getValue()!=null&&secondsAttri.getValue().equals(attributeValue)){
					return element;
				}
			}
		}
		return null ;
	}
}
