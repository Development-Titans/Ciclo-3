package Proyecto.Ciclo3.udea.frontControllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontControllerEmpresa {

    /*@Autowired
    private EmpresaInterface empresaController;*/

    @GetMapping("/empresa")
    public  String empresa(){
        return "empresa";
    }   

    @GetMapping("/crearEmpresa")
    public String crearEmpresa(){
        return "crearEmpresa";
    }
}
