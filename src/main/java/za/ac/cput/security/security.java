package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("12345"))
                .roles("ADMIN")
                .and()
                .withUser("client")
                .password(encoder().encode("54321"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/hospital system/**/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/read").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/hospital system/**/find-all").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }

    @Bean
    public PasswordEncoder encoder(){
        //Encodes our passwords for a more secure login system
        return new BCryptPasswordEncoder();
    }
}
