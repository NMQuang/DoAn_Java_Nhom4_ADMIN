package foodGroup4Quanly.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import foodGroup4Quanly.entity.AccountAdmin;

public class AccountAdminUserDetails extends User{
	
	private AccountAdmin accountAdmin;
	
	public AccountAdmin getAccountAdmin() {
		return accountAdmin;
	}

	public AccountAdminUserDetails(AccountAdmin account,
			Collection<? extends GrantedAuthority> authorities) {
		super(account.getUsername(), account.getPassword(), authorities);
		this.accountAdmin = account;
	}

}
