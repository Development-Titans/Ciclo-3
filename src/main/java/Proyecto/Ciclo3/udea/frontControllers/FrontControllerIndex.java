package Proyecto.Ciclo3.udea.frontControllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Proyecto.Ciclo3.udea.models.Empleado;

@Controller
public class FrontControllerIndex {

    //@RequestMapping(value="/",method = RequestMethod.GET)
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    

    @GetMapping("/")
    public String getLogin(Model model){
        model.addAttribute("formEmpleado",new Empleado());
        return "login";
    }

    
}
