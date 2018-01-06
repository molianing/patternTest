package com.decorator.servers.sqldecorator;

import com.decorator.server.SqlGenerater;
import com.decorator.server.SqlWork;

public class CustomCommaSqlDecorator extends SqlGenerater {

	private String l = null ;
	private String r = null ;
	private SqlWork work ;

	public CustomCommaSqlDecorator(SqlWork work){
		this.work=work;
	}
	public CustomCommaSqlDecorator(String l,SqlWork work){
		this.l = l ;
		this.work=work;
	}
	public CustomCommaSqlDecorator(SqlWork work,String r){
		this.r = r;
		this.work=work;
	}
	public CustomCommaSqlDecorator(String l,SqlWork work,String r){
		this.l = l ;
		this.r = r;
		this.work=work;
	}

	@Override
	public String getSql(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(",");
		sb.append(this.getL());
		sb.append(work.getSql());
		sb.append(this.getR());
		return sb.toString();
	}
	
	private String getL(){
		if(l!=null){
			return l ;
		}else{
			return "" ;
		}
	}
	
	private String getR(){
		if(r!=null){
			return r;
		}else{
			return "";
		}
	}
}
