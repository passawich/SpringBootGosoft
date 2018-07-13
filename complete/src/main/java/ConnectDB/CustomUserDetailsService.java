package ConnectDB;

//import org.springframework.stereotype.Component;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import Model.ApplicationUser;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService{
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		ApplicationUser applicationUser = loadApplicationUserByUsername(username);
//		return new User(applicationUser.getUser(),applicationUser.getPass()
//				,AuthorityUtils.createAuthorityList("ROLE_USER"));
//	}
//	
//	public ApplicationUser loadApplicationUserByUsername(String user) {
//		ApplicationUser userr = new ApplicationUser();
//		userr.setUser("batman");
//		userr.setPass("123");
//		return userr;
//	}
//}
