package com.decorator.servers.sqldecorator.common;

import com.decorator.server.SqlGenerater;
import com.decorator.server.SqlWork;

public class RTableCnNameDe extends SqlGenerater {

	private SqlWork work ;

	public RTableCnNameDe(SqlWork work){
		this.work=work;
	}

	@Override
	public String getSql(){
		return this.localGetStr();
	}
	
	public String localGetStr(){
		StringBuffer sb = new StringBuffer();
		sb.append(work.getSql());
		sb.append(SqlGenerater.in.getrTableCnName());
		return sb.toString();
	}
}
