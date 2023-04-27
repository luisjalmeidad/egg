package com.egg.noticia;


import com.egg.noticia.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioService)
                .passwordEncoder((new BCryptPasswordEncoder()));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/noticia/*").hasAnyRole("USER", "ADMIN", "JOURNALIST")
                    .antMatchers("/css/*","/js/*","/img/*","/**")
                    .permitAll()
                .and().formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/logincheck")
                    .usernameParameter("nombre")
                    .passwordParameter(("clave"))
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .permitAll()
                .and().csrf()
                    .disable();

    }
}
