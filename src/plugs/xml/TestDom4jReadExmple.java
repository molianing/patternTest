package plugs.xml;
import java.util.HashMap;

/**
 * 测试Dom4jReadExmple解析的情况
 * @author cuiweibing
 * @since 2007.8.10
 */
public class TestDom4jReadExmple {
 public static void main(String[] args) {
     try{
       //获取解析完后的解析信息
       HashMap<String,String> hashMap;
       Dom4jReadExmple drb=new Dom4jReadExmple();
       //遍历整个XML文件
       hashMap = new HashMap<String,String>();
       drb.iterateWholeXML("studentInfo.xml", hashMap);
       System.out.println("姓名\t年龄\t学院\t学院领导\t电话\t\t备注");
       for(int i=0;i<hashMap.size();i+=6){
         int j=i/6;
         System.out.print(hashMap.get("name"+j)+"\t");
         System.out.print(hashMap.get("student-age"+j)+"\t");
         System.out.print(hashMap.get("college"+j)+"\t");
         System.out.print(hashMap.get("college-leader"+j)+"\t");
         System.out.print(hashMap.get("telephone"+j)+"\t");
         System.out.println(hashMap.get("notes"+j)+"\t");
       }
     }catch(Exception ex){
       ex.printStackTrace();
     }
   }
}