package Proyecto.Ciclo3.udea.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);

    }

    @Bean /* Es parecida a la etiqueta @service, lo que hace es crear un objeto  */
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();

    }

    /* Implementamos la seguridad de http y sobreescribimos un metodo que existe en la clase
    que estamos extendiendo en la linea 13
    */

    /* ESTAMOS DEFINIENDO QUIENES PUEDEN INGRESAR A CIERTOS PATHS */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN") /* Los usuarios que tengan el rol de admin son los que va a poder ingresar
            al path que esta en la linde 37 */
            .antMatchers("/user").hasAnyRole("ADMIN", "USER") /* Le estamos dando permisos tanto a admin como a user */
    }
}
