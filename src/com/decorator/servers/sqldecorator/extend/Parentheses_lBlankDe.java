package com.decorator.servers.sqldecorator.extend;

import com.decorator.server.SqlGenerater;
import com.decorator.server.SqlWork;

public class Parentheses_lBlankDe extends SqlGenerater {

	private SqlWork work ;

	public Parentheses_lBlankDe(SqlWork work){
		this.work=work;
	}

	@Override
	public String getSql(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(work.getSql());
		sb.append(SqlGenerater.in.getParentheses_l());
		sb.append(" ");
		return sb.toString();
	}
}
