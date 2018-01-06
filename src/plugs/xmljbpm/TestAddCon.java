package plugs.xmljbpm;

public class TestAddCon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadXml load = new LoadXml() ;
		AddConditionForDecisionTransition add = new AddConditionForDecisionTransition() ;
		StoreXml store = new StoreXml() ;
		store.store(add.addCondition(load.load("全省实例类销售品管理流程fix.jpdl.xml"),"re 发起工单4"),"fix1.jpdl.xml");
	}

}
