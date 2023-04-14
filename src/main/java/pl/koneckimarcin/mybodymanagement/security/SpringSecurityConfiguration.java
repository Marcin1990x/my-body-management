package pl.koneckimarcin.mybodymanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails newUserDetails = createNewUser("Marcin", "dupa");

        return new InMemoryUserDetailsManager(newUserDetails);
    }

    private UserDetails createNewUser(String username, String password) {

        Function<String, String> passwordEncoder =
                input -> passwordEncoder().encode(input);

        UserDetails newUser = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("ADMIN", "USER")
                .build();
        return newUser;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // give access to /h2-console
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();
    }

}
