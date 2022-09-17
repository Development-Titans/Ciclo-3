package Proyecto.Ciclo3.udea.frontControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.services.EmpleadoService;


@Controller
public class FrontControllerUsuarios {

    @Autowired
    private EmpleadoService controllersUsuarios;
    
    @GetMapping("/usuarios")
    public  String usuarios(Model model){
        List<Empleado> trabajador = controllersUsuarios.empleadoGetAll();
        model.addAttribute("pikachu", trabajador);
        return "usuarios";
    }

    @RequestMapping(value = "/crearusuario", method = RequestMethod.GET)
    public  String crearUsuario(@ModelAttribute Empleado raichu, Model model) throws Exception{
        model.addAttribute("raichu", new Empleado());
        return "crearUsuario";
    }

    @RequestMapping(value = "/crearusuario", method = RequestMethod.POST)
    public String agregar(@ModelAttribute Model model, Empleado raichu)throws Exception{
        controllersUsuarios.addEmpleado(raichu);
        return "redirect:/usuarios";
    }

}
