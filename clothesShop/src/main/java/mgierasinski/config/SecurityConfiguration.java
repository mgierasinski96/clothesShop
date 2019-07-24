package mgierasinski.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name="myAppUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
        auth.inMemoryAuthentication().withUser("employee").password("{noop}employee").roles("EMPLOYEE");
        //AppUser.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

      http.authorizeRequests()

//        .antMatchers("/appUserRole*").access("hasRole('ROLE_ADMIN')")
//              .antMatchers("/bluzy*").access("hasRole('ROLE_ADMIN')")
        //.and().formLogin().permitAll(); // with default login page
        .and().formLogin().loginPage("/login").permitAll() // with custom login page
        .usernameParameter("login").passwordParameter("password")
        .failureForwardUrl("/login.html?error")
        .and().logout().logoutSuccessUrl("/login.html?logout")
          .and().exceptionHandling().accessDeniedPage("/accessDenied");

    }
}

