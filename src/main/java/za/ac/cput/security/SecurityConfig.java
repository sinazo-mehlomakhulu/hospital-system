package za.ac.cput.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configureCredentials(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin").password("pass123").roles("ADMIN")
                .and().withUser("Client").password("123pass").roles("USER");
    }

    protected void configureEndpoint(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/post").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/get").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/get").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete").hasRole("ADMIN")
                .and().csrf().disable();
    }

}
