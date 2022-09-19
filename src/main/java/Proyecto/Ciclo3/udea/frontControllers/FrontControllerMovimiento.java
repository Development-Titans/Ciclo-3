package Proyecto.Ciclo3.udea.frontControllers;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import Proyecto.Ciclo3.udea.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class FrontControllerMovimiento {
    
    @Autowired
    private MovimientoDineroService controlador;

    @GetMapping("/movimientoDinero")
    public String dinero(Model model){
        List<MovimientoDinero> x = controlador.movimientoGetAll();
        model.addAttribute("x", x);
        return "movimientoDinero";
    }

    @GetMapping("/nuevoMovimiento")
    public String nuevoMovimiento(@ModelAttribute MovimientoDinero movimientoDinero, Model model){
        model.addAttribute("movimientoDinero", new MovimientoDinero());
        return "crearTransacciones";
    }
 
    @PostMapping("/nuevoMovimiento")
    public String nuevo(@ModelAttribute MovimientoDinero movimientoDinero, Model model) throws Exception{
        controlador.addMovimiento(movimientoDinero);
        return "redirect:/movimientoDinero";
    }

}
