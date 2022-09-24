package Proyecto.Ciclo3.udea.frontControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.Roles;
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
    public  String crearUsuario(@ModelAttribute Empleado raichu, Model model){
        model.addAttribute("raichu", new Empleado()); /* Esta linea va al html para crear un usuario */
        model.addAttribute("rolecillos", Roles.values()); /* Esta linea me lleva los roles hacia donde esta la variable
        rolecillos en el html y trae los roles desde la clase roles. Es decir que rolecillos es lo mismo que Roles.values()
        tiene o almacena lo que traemos de la otra clase y en el html con el iterador each recorremos cada valor y lo mostramos */
        return "crearUsuario";
    }

    @RequestMapping(value = "/crearusuario", method = RequestMethod.POST)
    public String agregar(@ModelAttribute Empleado raichu, Model model)throws Exception{
        controllersUsuarios.addEmpleado(raichu);
        return "redirect:/usuarios";
    }

    /* Estamos borrando un usuario */

    @PostMapping("/crearusuario/{id}")
    public String deleteUsuario(@PathVariable String id, Model model){
        try{
            controllersUsuarios.borrarEmpleado(id);
            return "redirect:/usuarios";
        }catch (Exception e){
            return "redirect:/error";
        }
    }

    /* Esta Mostrando la plantilla de actualizar un usuario */

    @PostMapping("/actualizarUsuario")
    public String actualizar(Model model){
        return "actualizarUsuario";
    }

    @GetMapping("/usuarios/{id}")
    public String getusuarios(@PathVariable String id, Model model){
        try {
            model.addAttribute("actualizarUser", controllersUsuarios.empleadoGetId(id)); /* Estamos buscando y almacenando el objeto
            en actualizarUser, esto nos trae todos los datos de ese usuario */
            model.addAttribute("rolecillos", Roles.values()); /* Traemos los roles que vamos a mostrar para actualizar */
            return "actualizarUsuario"; /* Los enviamos a la plantilla de actualizarUsuario */
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}
