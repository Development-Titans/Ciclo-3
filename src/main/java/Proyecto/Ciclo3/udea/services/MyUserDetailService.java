package Proyecto.Ciclo3.udea.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.security.MyUserDetail;

@Service
public class MyUserDetailService implements UserDetailsService {

    /* En este metodo viene a buscar el usuario y lo compara con el de la base de datos */

    @Autowired
    EmpleadoInterface empleadoInteface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            System.out.println(username);
            Empleado user = empleadoInteface.empleadoGetId(username); /* Busca en la base de datos por el nombre  y lo trae */
            System.out.println(user);
            return new MyUserDetail(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
    
}
