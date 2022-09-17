package Proyecto.Ciclo3.udea.frontControllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControllerIndex {

    //@RequestMapping(value="/",method = RequestMethod.GET)
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
