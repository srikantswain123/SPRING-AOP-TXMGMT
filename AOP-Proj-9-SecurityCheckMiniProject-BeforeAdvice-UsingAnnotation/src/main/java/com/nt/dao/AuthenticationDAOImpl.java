package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nt.bo.UserDetailsBO;
@Component("authdao")
public class AuthenticationDAOImpl implements IAuthenticationDAO {
	private  static final String AUTH_QUERY="SELECT COUNT(*) FROM  USERINFO WHERE UNAME=? AND PWD=?";
	@Autowired
	private JdbcTemplate jt;


	@Override
	public int authenticate(UserDetailsBO bo) {
		int  count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}

}
