//package Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import ConnectDB.CustomUserDetailsService;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	private final CustomUserDetailsService customUserDetailseService;
//	
//	@Autowired
//	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//		this.customUserDetailseService = customUserDetailsService;
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//	
//	}
//}
