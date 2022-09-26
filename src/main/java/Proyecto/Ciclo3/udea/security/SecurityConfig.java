package Proyecto.Ciclo3.udea.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("ALL")
@Configuration /* Decimos que esto es una configuracion */
@EnableWebSecurity /* Decimos que esta es la clase principal de seguridad */
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SuccessGoogle successGoogle;

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

        String[] permitted = new String[]{"/resources/**", "/static/img/**", "/static/Styles/**"};

        http.authorizeRequests()
                .antMatchers(permitted).permitAll()
            .antMatchers("/admin").hasRole("Administrador") /* Los usuarios que tengan el rol de admin son los que va a poder ingresar
            al path que esta en la linde 37 */
            .antMatchers("/user").hasAnyRole("Administrador", "Operario")
             /* Le estamos dando permisos tanto a admin como a user */
            .antMatchers("/").permitAll() /* Cualquiera tiene permiso de ingresar a este path, es lo que estamos diciendo */
            .antMatchers("/login*").permitAll() /* Cualquier cosa que tenga login (es lo que significa el (*)) lo van a poder ver cualquiera */
            .antMatchers("/oauth/**").permitAll()/* Permiso para Google, le estamos indicando la url para los permisos */
            .and() /* Y... */
            .formLogin() /* Otorgueme un formulario */
            .loginPage("/login") /* Lo estamos dirigiendo al path donde tenemos el login */
            .usernameParameter("correo") /* Este usuario que recibe viene de la plantilla del login en la
            linea 28 */
            .passwordParameter("contrasena") /* Esta contraseña viene de la plantilla del login en la
            linea 33 */
            .defaultSuccessUrl("/index") /* Le estamos diciendo que cuando inicie sesion correctamente
            entonces nos envie a la pagina del index */
            .and()
            .oauth2Login()
            .loginPage("/login")/* Estamos llamando nuestra pagina normal como lo hicimos en la linea 50 */
            .successHandler(successGoogle)/* Inyectamos el objeto */
            .and()  /* El logout es para denegar el acceso a personas diferentes de la base de datos */
            .logout() /* Definimos cuando la persona se loguee desde google hacia donde va si es erroneo o hacia donde va si es acertado */
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
    ;

        http.csrf().disable();

    }

}
