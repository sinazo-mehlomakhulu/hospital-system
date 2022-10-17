package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder encoder(){
        //Encodes our passwords for a more secure login system
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService (BCryptPasswordEncoder bCryptPasswordEncoder){
    //Creating the roles for the system
        InMemoryUserDetailsManager man = new InMemoryUserDetailsManager();
        man.createUser(User.withUsername("admin-user")
                .password(bCryptPasswordEncoder.encode("65ff7492d30"))
                .roles("ADMIN")
                .build()
                );

        man.createUser(User.withUsername("client-user")
                .password(bCryptPasswordEncoder.encode("1253208465b"))
                .roles("USER")
                .build()
        );
        return man;
    }

        @Bean
      public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
       //Allocating the roles permissions
        httpSecurity.httpBasic()
                .and().csrf().disable().formLogin().disable()
                //Place all roles for different domains below =>
                
                //Path matcher For the Hospital System
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/**/hospitalroom/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/**/hospitalroom/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/hospitalroom/read/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET, "/**/hospitalroom/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Nurse System
                .antMatchers(HttpMethod.POST, "/**/nurse/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/**/nurse/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/nurse/read/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET, "/**/nurse/find-all").hasAnyRole("USER","ADMIN")


                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);



            return httpSecurity.build();
    }
}

