package cl.foxcorp.mov.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.repository.UserRepository;

@Service
public class MyAppUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		cl.foxcorp.mov.entity.User user = userRepository.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
		UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(),
				Arrays.asList(authority));
		return userDetails;
	}
}