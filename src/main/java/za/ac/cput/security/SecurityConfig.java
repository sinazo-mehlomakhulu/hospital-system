package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin123").roles("ADMIN")
                .and()
                .withUser("user").password("user123").roles("USER")
                .and()
                //hiding the passwords
                .withUser("admin").password(encoder().encode("12345")).roles("ADMIN")
                .and()
                .withUser("client").password(encoder().encode("54321")).roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/hospital-system/doctor").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/hospital-system/doctor").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }



    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}