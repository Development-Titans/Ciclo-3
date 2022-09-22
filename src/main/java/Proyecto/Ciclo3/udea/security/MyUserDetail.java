package Proyecto.Ciclo3.udea.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.Roles;

public class MyUserDetail implements UserDetails{

    private String correo;
    private String password;
    private List<GrantedAuthority> authorities;

    public MyUserDetail(Empleado empleado){
        this.correo = empleado.getCorreo(); /* El usuario y constraseña que vienen de base de datos */
        this.password = empleado.getContrasena();
        List <GrantedAuthority> roles = new ArrayList<>(); /* Los roles o listado de roles que se ha de implementar */
        /* Vamos a realizar una transformacion para que nos funcione */

        // ADMIN,USER,EMPLEADO,APRENDIZ
        for(Roles rol: empleado.getRol()) { /* Vamos a recorrer lo que viene en la linea 17 para agregarlo a la otra
            lista sino no nos funcionaria */
            roles.add( /* Agregamos a la arraylist los roles */
                new SimpleGrantedAuthority(rol.name()) /* Vamos agregando uno a uno los roles */
            );
        }
        
        this.authorities = roles; /* La lista de roles que tuvimos que convertir a string porque en enum no funciona */
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
