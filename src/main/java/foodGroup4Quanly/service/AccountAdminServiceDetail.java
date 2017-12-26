package foodGroup4Quanly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.common.AccountAdminUserDetails;
import foodGroup4Quanly.dao.AccountAdminDao;
import foodGroup4Quanly.entity.AccountAdmin;

@Transactional
public class AccountAdminServiceDetail implements UserDetailsService{

	@Autowired
	private AccountAdminDao accountAdminDao;
	
	public void setAccountAdminDao(AccountAdminDao accountAdminDao) {
		this.accountAdminDao = accountAdminDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		AccountAdmin ac = accountAdminDao.get(username);
		System.out.println("USERNAME" + ac);
		if(ac!= null)
			System.out.println(ac.getUsername());
		if (ac == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		List<String> roles = new ArrayList<String>();
		roles.add(ac.getQuyen());
		List<GrantedAuthority> grandList = new ArrayList<>();
		for (String role : roles) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role);
			grandList.add(authority);
		}
		
		return new AccountAdminUserDetails(ac, grandList);
	}

}
