package com.decorator.servers.sqldecorator.extend;

import com.decorator.server.SqlGenerater;
import com.decorator.server.SqlWork;

public class AndBlankDe extends SqlGenerater {

	private SqlWork work ;

	public AndBlankDe(SqlWork work){
		this.work=work;
	}

	@Override
	public String getSql(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(work.getSql());
		sb.append("and");
		sb.append(" ");
		return sb.toString();
	}
}
