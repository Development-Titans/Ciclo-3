package Proyecto.Ciclo3.udea.frontControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontControllerUsuarios {

    /*@Autowired
    private EmpleadoInterface controllersUsuarios;*/
    
    @GetMapping("/usuarios")
    public  String usuarios(){
        return "usuarios";
    }

    @GetMapping("/crearUsuario")
    public  String crearUsuario(){
        return "crearUsuario";
    }
}
