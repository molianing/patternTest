package com.decorator.servers.sqldecorator.extend;

import com.decorator.server.SqlGenerater;
import com.decorator.server.SqlWork;

public class ATableNameBlankDe extends SqlGenerater {

	private SqlWork work ;

	public ATableNameBlankDe(SqlWork work){
		this.work=work;
	}

	@Override
	public String getSql(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(work.getSql());
		sb.append(SqlGenerater.in.getaTableName());
		sb.append(" ");
		return sb.toString();
	}
}
