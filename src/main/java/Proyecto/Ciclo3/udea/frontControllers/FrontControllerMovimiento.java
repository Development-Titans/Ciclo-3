package Proyecto.Ciclo3.udea.frontControllers;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import Proyecto.Ciclo3.udea.services.MovimientoDineroInterface;
import Proyecto.Ciclo3.udea.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class FrontControllerMovimiento {

    @Autowired
    private MovimientoDineroInterface service;

    //Constructor
    public FrontControllerMovimiento(MovimientoDineroService service){
        this.service = service;
    }

    //Metodo para mostrar todos los registros
    @GetMapping("/movimientoDinero")
    public String movimientoDinero(Model model){
        List<MovimientoDinero> movimientoDinero = this.service.movimientoGetAll();
        model.addAttribute("movimientoDinero", movimientoDinero);
        return "movimientoDinero";
    }

    @GetMapping("/crearTransacciones")
    public String crearMovimiento(){
        return "crearTransacciones";
    }
}
