package com.decorator.server;

public class StrGenerateDecorator extends StrGenerater {

	private String l = null ;
	private String r = null ;
	private Work work ;

	public StrGenerateDecorator(Work work){
		this.work=work;
	}
	public StrGenerateDecorator(String l,Work work){
		this.l = l ;
		this.work=work;
	}
	public StrGenerateDecorator(Work work,String r){
		this.r = r;
		this.work=work;
	}
	public StrGenerateDecorator(String l,Work work,String r){
		this.l = l ;
		this.r = r;
		this.work=work;
	}

	@Override
	public String getStr(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.getL());
		sb.append(work.getStr());
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
