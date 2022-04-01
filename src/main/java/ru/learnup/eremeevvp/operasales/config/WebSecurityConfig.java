package ru.learnup.eremeevvp.operasales.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/list").permitAll()
                .antMatchers(HttpMethod.POST,"/tickets").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/list").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/list").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/list").hasRole("ADMIN")

                .and()
                .formLogin();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

}