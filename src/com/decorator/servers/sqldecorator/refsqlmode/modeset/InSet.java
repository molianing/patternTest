package com.decorator.servers.sqldecorator.refsqlmode.modeset;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.decorator.servers.sqldecorator.refsqlmode.In;


public class InSet {

	/**准备关联查询标准.sql*/
	public static final String PREPARE_REF_SEARCH_STANDARD="E:\\doone\\SQL\\ECP关联查询\\准备关联查询标准.sql" ;

	/**应用程序sql获取.sql*/
	public static final String APPLICATION_SQL_FETCH="E:\\doone\\SQL\\ECP程序_控制\\应用程序sql.sql" ;
	/**应用程序sql获取.sql*/
	public static final String DEPLOY_HELPER_SRC_FILE="E:\\doone\\SQL\\ECP程序_控制\\发布helper.sql" ;
	
	/**生成关头联串sql*/
	public static final String GENERATE_SERIAL_SQL="E:\\doone\\SQL\\ECP链\\关联链源内容.sql" ;
		
	private String [] inLine;

	   public static void main(String[] args){
		   InSet inSet = new InSet();
		   inSet.getInSet(PREPARE_REF_SEARCH_STANDARD);
		   In in = inSet.getIn();    

		   System.out.println(in.getShortFileName());
		   System.out.println(in.getSelect());
		   System.out.println(in.getStar());
		   System.out.println(in.getBlank());
		   System.out.println(in.getFrom());
		   System.out.println(in.getWhere());
		   System.out.println(in.getPoint());
		   System.out.println(in.getSemicolon());
		   System.out.println(in.getMinus());
		   System.out.println(in.getDoubleMinus());
		   System.out.println(in.getTabBlank());
		   System.out.println(in.getaTableName());
		   System.out.println(in.getaAlias());
		   System.out.println(in.getaTableCnName());
		   System.out.println(in.getaIdName());
		   System.out.println(in.getaIdCnName());
		   System.out.println(in.getrTableName());
		   System.out.println(in.getrAlias());
		   System.out.println(in.getrTableCnName());
		   System.out.println(in.getbTableName());
		   System.out.println(in.getbAlias());
		   System.out.println(in.getbTableCnName());
		   System.out.println(in.getbIdName());
		   System.out.println(in.getbIdCnName());
		   System.out.println(in.getForUpdate());
		   System.out.println(in.getParentheses_l());
		   System.out.println(in.getParentheses_r());
		   System.out.println(in.getIn());

	   }
	   
	   public In getIn_2table(){
			In in = new In();
			/*短文件名 组合-策略*/in.setShortFileName(inLine[0].trim());
			/* select*/in.setSelect("select");
			/*星号 **/in.setStar("*");
			/*空格  */in.setBlank(" ");
			/* from*/in.setFrom("from");
			/* where*/in.setWhere("where");
			/*?.*/in.setPoint(".");
			/*分号 ;*/in.setSemicolon(";");
			/*减号 -*/in.setMinus("-");
			/*双减?--*/in.setDoubleMinus("--");
			/*tab空格        */in.setTabBlank("       ");
			String line2 = inLine[1];
			String[] tmptab = line2.split(in.getBlank());
			for(int i=0;i<tmptab.length;i++){
				if(tmptab[i].endsWith(in.getFrom())){
					/*a表名 TF_PPM_OFFER_COMB*/in.setaTableName(tmptab[i+1]);
					/*a别名 co*/in.setaAlias(tmptab[i+2]);
					
					String idN = tmptab[i+4].substring((in.getaAlias()+in.getPoint()).length());
					if(idN.indexOf(in.getSemicolon())!=-1){
						idN=idN.substring(0,idN.indexOf(in.getSemicolon()));
					}
					/*a主键?offer_comb_id*/in.setaIdName(idN);
					break;
				}
			}
			/*a表中文名 */in.setaTableCnName(line2.substring(line2.indexOf(in.getDoubleMinus())+2));
			/*a主键中文?组合*/in.setaIdCnName(in.getShortFileName().split(in.getMinus())[0]+" id");
			
			String line3 = inLine[2];//select * from TF_PPM_DISTRIBUTION_SEL sel where sel.offer_comb_id and sel.distribution_item_id　;-
			line3=line3.replaceAll("     ", " ");
			line3=line3.replaceAll("    ", " ");
			line3=line3.replaceAll("   ", " ");
			line3=line3.replaceAll("  ", " ");
			String[] tmptab3 = line3.split(in.getBlank());
			String aliasPointIda = null,aliasPointIdr = null,idN=null;
			for(int i=0;i<tmptab3.length;i++){
				if(tmptab3[i].equalsIgnoreCase(in.getFrom())){
					/*r表名 TF_PPM_OFFER_COMB*/in.setrTableName(tmptab3[i+1]);
					/*r别名 co*/in.setrAlias(tmptab3[i+2]);
					aliasPointIda=tmptab3[i+4];//获得2id
					aliasPointIdr=tmptab3[i+6];
					
					//id验证
					if(tmptab3.length<=11){//只有一个id的情况
						aliasPointIda=aliasPointIda.substring((in.getrAlias()+in.getPoint()).length());
						
						if(aliasPointIda.indexOf(in.getSemicolon())!=-1){
							aliasPointIda=aliasPointIda.substring(0, aliasPointIda.indexOf(in.getSemicolon()));
						}
						idN=aliasPointIda;
						break;
					}
					
					aliasPointIda=aliasPointIda.substring((in.getrAlias()+in.getPoint()).length());
					aliasPointIdr=aliasPointIdr.substring((in.getrAlias()+in.getPoint()).length());
					
					if(aliasPointIda.indexOf(in.getSemicolon())!=-1){
						aliasPointIda=aliasPointIda.substring(0, aliasPointIda.indexOf(in.getSemicolon()));
					}
					if(aliasPointIdr.indexOf(in.getSemicolon())!=-1){
						aliasPointIdr=aliasPointIdr.substring(0, aliasPointIdr.indexOf(in.getSemicolon()));
					}
					if(aliasPointIda.equalsIgnoreCase(in.getaIdName())){
						idN=aliasPointIdr;
					}else{
						idN=aliasPointIda;
					}
					break;
				}
			}
			/*r表中文名 */in.setrTableCnName(line3.substring(line3.indexOf(in.getDoubleMinus())+2));
			

			/*b主键?offer_comb_id*/in.setbIdName(idN);//复用于２表时，做为子表的主键
			

			
			/*b主键中文?组合*/in.setbIdCnName(in.getShortFileName().split(in.getMinus())[1]+" id");
			
			/* for update*/in.setForUpdate("for update");
			/*左括?(*/in.setParentheses_l("(");
			/*右括?)*/in.setParentheses_r(" )");
			/*in in*/in.setIn("in");

			return in ;
		}
	   
	public In getIn_3table(){
		In in = new In();
		/*短文件名 组合-策略*/in.setShortFileName(inLine[0].trim());
		/* select*/in.setSelect("select");
		/*星号 **/in.setStar("*");
		/*空格  */in.setBlank(" ");
		/* from*/in.setFrom("from");
		/* where*/in.setWhere("where");
		/*?.*/in.setPoint(".");
		/*分号 ;*/in.setSemicolon(";");
		/*减号 -*/in.setMinus("-");
		/*双减?--*/in.setDoubleMinus("--");
		/*tab空格        */in.setTabBlank("       ");
		String line2 = inLine[1];
		String[] tmptab = line2.split(in.getBlank());
		for(int i=0;i<tmptab.length;i++){
			if(tmptab[i].endsWith(in.getFrom())){
				/*a表名 TF_PPM_OFFER_COMB*/in.setaTableName(tmptab[i+1]);
				/*a别名 co*/in.setaAlias(tmptab[i+2]);
				
				String idN = tmptab[i+4].substring((in.getaAlias()+in.getPoint()).length());
				if(idN.indexOf(in.getSemicolon())!=-1){
					idN=idN.substring(0,idN.indexOf(in.getSemicolon()));
				}
				/*a主键?offer_comb_id*/in.setaIdName(idN);
				break;
			}
		}
		/*a表中文名 */in.setaTableCnName(line2.substring(line2.indexOf(in.getDoubleMinus())+2));
		/*a主键中文?组合*/in.setaIdCnName(in.getShortFileName().split(in.getMinus())[0]+" id");
		
		String line3 = inLine[2];
		String[] tmptab3 = line3.split(in.getBlank());
		for(int i=0;i<tmptab3.length;i++){
			if(tmptab3[i].equalsIgnoreCase(in.getFrom())){
				/*r表名 TF_PPM_OFFER_COMB*/in.setrTableName(tmptab3[i+1]);
				/*r别名 co*/in.setrAlias(tmptab3[i+2]);
//				break;
				continue ;
			}else
			if(tmptab3[i].equalsIgnoreCase(in.getWhere())){
				String r_a_id = tmptab3[i+1];
				String r_b_id= tmptab3[i+2];
				in.setR_aIdName(getAfterP(r_a_id,null));
				in.setR_bIdName(getBeforeP(getAfterP(r_b_id,null),";"));
			}
		}
		/*r表中文名 */in.setrTableCnName(line3.substring(line3.indexOf(in.getDoubleMinus())+2));
		//

		String line4 = inLine[3];
//		   System.out.println(inLine[3]);
		String[] tmptab4 = line4.split(in.getBlank());
		for(int i=0;i<tmptab4.length;i++){
			if(tmptab4[i].equalsIgnoreCase(in.getFrom())){
				
				/*b表名 TF_PPM_OFFER_COMB*/in.setbTableName(tmptab4[i+1]);
				/*b别名 co*/in.setbAlias(tmptab4[i+2]);
				

				String idN = tmptab4[i+4].substring((in.getbAlias()+in.getPoint()).length());
				if(idN.indexOf(in.getSemicolon())!=-1){
					idN=idN.substring(0,idN.indexOf(in.getSemicolon()));
				}
				/*b主键?offer_comb_id*/in.setbIdName(idN);
			}
			
		}
		/*c表中文名 */in.setbTableCnName(line4.substring(line4.indexOf(in.getDoubleMinus())+2));
		
		/*b主键中文?组合*/in.setbIdCnName(in.getShortFileName().split(in.getMinus())[1]+" id");
		
		/* for update*/in.setForUpdate("for update");
		/*左括?(*/in.setParentheses_l("(");
		/*右括?)*/in.setParentheses_r(" )");
		/*in in*/in.setIn("in");

		return in ;
	}
	   
	public In getIn(){
		
		if(inLine[1].indexOf("-")==-1){//打印草稿
			printTitle();
			printDraft();
			printSrc();
			return null;
		}else{//初始化值
			//打原始数据
			

			System.out.println("--"+inLine[0]+"\n");
			String li =inLine[3] ;
			if(li!=null&&li.length()>0){
				li = li.trim();
			}
			
			if(li==null||li.length()==0){
				return getIn_2table();//2表
			}else{
				return getIn_3table();//3表
			}
		}
		

		
	}
	
	public void printSrc(){
//
//		if(li==null||li.length()==0){
////			System.out.println("/*");
////			printOldSrc(2);
////			System.out.println("--第１表换第３表");
////			printOldSrcreverse(2);
////			System.out.println("*/");
//			return getIn_2table();//2表
//		}else{
////			System.out.println("/*");
////			printOldSrc(3);
////			System.out.println("--第１表换第３表");
////			printOldSrcreverse(3);
////			System.out.println("*/");
//			return getIn_3table();//3表
//		}
	}

	public void printOldSrc(int where){

		if(inLine!=null && inLine.length>0){
			if(where==2){
				System.out.println(inLine[1]);
				System.out.println(inLine[2]);
			}if(where==3){
				System.out.println(inLine[1]);
				System.out.println(inLine[2]);
				System.out.println(inLine[3]);
			}

			System.out.println("/*");
			System.out.println("--第１表换第３表");
			System.out.println(inLine[2]);
			System.out.println(inLine[1]);
			System.out.println(inLine[0]);
			System.out.println("*/");
		}
	}
	public void printOldSrcreverse(int where){

		if(inLine!=null && inLine.length>0){
			if(where==2){
				System.out.println(inLine[1]);
				System.out.println(inLine[2]);
			}if(where==3){
				System.out.println(inLine[1]);
				System.out.println(inLine[2]);
				System.out.println(inLine[3]);
			}

		}
	}
	
	public String [] getInLine(){
		return inLine;
	}
	
	
	public void getInSet(String fileAllPath){
		

	       BufferedReader read=null;
	       String s=null;
	       try {
	           read=new BufferedReader(new InputStreamReader(new FileInputStream(fileAllPath),"UTF-8"));
	           int i = 0;
	           while ((s = read.readLine()) != null) {
	        	   if(inLine==null){
	        		   inLine = new String[100000];
	        	   }
	        	   inLine[i++]=s;
//	               System.out.println(s);
	           }
	       } catch (FileNotFoundException ex) {
	           System.out.println("找不到指定文件！！");
	       }catch (IOException e) {
	           System.out.println("文件读取有误！");
	       }finally{
	           try {
	               read.close();
	           } catch (IOException ex) {
	               System.out.println(ex.getMessage());
	           }
	       }
	
	}
	public void getInSet(String fileAllPath,String charset){
		

	       BufferedReader read=null;
	       String s=null;
	       try {
	           read=new BufferedReader(new InputStreamReader(new FileInputStream(fileAllPath),charset));
	           int i = 0;
	           while ((s = read.readLine()) != null) {
	        	   if(inLine==null){
	        		   inLine = new String[100000];
	        	   }
	        	   inLine[i++]=s;
//	               System.out.println(s);
	           }
	       } catch (FileNotFoundException ex) {
	           System.out.println("找不到指定文件！！");
	       }catch (IOException e) {
	           System.out.println("文件读取有误！");
	       }finally{
	           try {
	               read.close();
	           } catch (IOException ex) {
	               System.out.println(ex.getMessage());
	           }
	       }
	
	}
	
	/***
	 * 加载文本文件，返回内容为一字符串
        String demoMsg = inSet.getInString(demoFileName,"gbk");
	 * @return 
	 */
	public String getInString(String fileAllPath, String code) {


		char[] buffer = new char[5120000];
//		File file = new File(fileAllPath);
	    
		try {
			Reader r = new InputStreamReader(new FileInputStream(fileAllPath),code);
			int dataLen = r.read(buffer);
			if(dataLen == -1){
				return null;
			}else{
				return new String(buffer,0,dataLen);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**打印出草稿*/
	public void printDraft(){
		
		for(int i=0;i<3;i++){

			String table = null,tabelCn=null,alias = null;
			String s = inLine[i];
			if(i>=2&&s==null){//仅支持２表时
				break;
			}
			String tm = s.replaceAll("[^x00-xff]", "**");
			int fir = tm.indexOf("*");
			int end = tm.lastIndexOf("*");
//			System.out.println(s);
//			System.out.println(tm);
			
			if(i>=2&&fir==-1){//仅支持２表时
				break;
			}
			
			table = tm.substring(0,fir);
			alias=tm.substring(end+1);
			tabelCn=s.replaceAll(table, "");
			tabelCn=tabelCn.replaceAll(alias, "");
			if(alias==null||alias.length()==0||alias.trim().length()==0){
				System.out.println("无别名  行"+i);
				System.exit(0);
			}
			
			if(i==1){
				System.out.print("       ");
			}
			

			System.out.print("select * from ");
			System.out.print(table);
			System.out.print(" ");
			System.out.print(alias);
			System.out.print(" where ");
			System.out.print(alias);
			System.out.print(" ; -- ");
			System.out.println(tabelCn);
			
//			System.out.println(table);
//			System.out.println(tabelCn);
//			System.out.println(alias);
		}
	}

		/**打印出草稿*/
		public void printTitle(){
			//打印标题　开始
//			System.out.println("标题");
			String tmpEndTitle="";
			
			for(int i=0;i<3;i++){

				String table = null,tabelCn=null,alias = null;
				String s = inLine[i];
				if(i>=2&&s==null){//仅支持２表时
					break;
				}
				String tm = s.replaceAll("[^x00-xff]", "**");
				int fir = tm.indexOf("*");
				int end = tm.lastIndexOf("*");
//				System.out.println(s);
//				System.out.println(tm);
				
				if(i>=2&&fir==-1){//仅支持２表时
					System.out.println(tmpEndTitle);
					break;
				}
				
				table = tm.substring(0,fir);
				alias=tm.substring(end+1);
				tabelCn=s.replaceAll(table, "");
				tabelCn=tabelCn.replaceAll(alias, "");
				if(alias==null||alias.length()==0||alias.trim().length()==0){
					System.out.println("无别名  行"+i);
					System.exit(0);
				}
				
				if(i==0){
					System.out.print(tabelCn.trim()+"-");
				}else if(i==1){
					tmpEndTitle=tabelCn.trim();
				}else if(i==2){
					System.out.println(tabelCn.trim());
				}
				//打印标题　结束
			}
		
//		TF_PPM_PREFERENTIAL_ITEM销售品定价项pren
//		TF_PPM_PRODUCTBALANCE销售品结算配置表bala
//		select * from TF_PPM_PREFERENTIAL_ITEM pren where pren ;--销售品定价项
//		       select * from TF_PPM_PRODUCTBALANCE bala where bala ;--销售品结算配置表
//		select * from TF_PPM_OFFER_COMB co where co.offer_comb_id  ;--销售品组合
	}

	public String getAfterP(String ins,String p){
		if(p==null || p==""){
			p=".";
		}
		String xx = "";
		if(ins!=null && ins.indexOf(p)!=-1){
			xx =ins.substring(ins.indexOf(p)+p.length());
		}else if(ins!=null){
			return ins;
		}
		return xx ;
	}
	public String getBeforeP(String ins,String p){
		if(p==null || p==""){
			p=".";
		}
		String xx = "";
		if(ins!=null && ins.indexOf(p)!=-1){
			xx =ins.substring(0,ins.indexOf(p));
		}else if(ins!=null){
			return ins;
		}
		return xx ;
	}
}
