package Security;
//import Model.User;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.web.filter.GenericFilterBean;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.auth0.jwt.JWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//
//import javax.imageio.IIOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.time.ZoneOffset;
//import java.time.ZonedDateTime;
//import java.time.temporal.ChronoUnit;
//import static Security.SecurityConstants.*;
//
//@Configuration
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//	private AuthenticationManager authenticationManager;
//	
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//    	this.authenticationManager = authenticationManager;
//    }
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		try {
//			System.out.println("do filter.");
//			String token = request.getHeader(HEADER_STRING);
//			JWT.create();
//			if(token == null) {
//				System.out.println(JWT.create());
//				System.out.println(JWT.decode(TOKEN_PREFIX));
//				System.out.println("no token");
//			}
//			filterChain.doFilter(request, response);
//		}
//		catch(Exception e){
//			System.out.println(e);
//			throw new RuntimeException(e);
//		}
//	}
//    
//    
//}