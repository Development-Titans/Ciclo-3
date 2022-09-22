package Proyecto.Ciclo3.udea.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import Proyecto.Ciclo3.udea.services.EmpleadoInterface;

@Component /* Esto es un componente */
public class SuccessGoogle implements AuthenticationSuccessHandler{

    @Autowired
    EmpleadoInterface empleado;

    /* AQUI ES DONDE VIENE LA RESPUESTA CUANDO NOS AUTENTIQUEMOS */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal(); /* Nos va a traer el usuario que esta por default para la autentificacion */
        String correoUsuario = user.getEmail(); /* Nos trae el email de google con el que ingresa la persona */

        System.out.println("Correo de Google!! " + correoUsuario);
        try {
            /* Enviamos a buscar si el usuario lo tenemos en la base de datos */
            empleado.empleadoGetId(correoUsuario);
            response.sendRedirect("/index"); /* Redireccionamos a la pagina de index por si lo encuentra */
        } catch (Exception e) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            //throw new RuntimeException(e);
        } 
    
        
    
    
    }
    
}
