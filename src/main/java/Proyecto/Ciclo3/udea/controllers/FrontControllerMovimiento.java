package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import Proyecto.Ciclo3.udea.services.MovimientoDineroInterface;
import Proyecto.Ciclo3.udea.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //@RequestMapping(value="/",method = RequestMethod.GET)
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Metodo para mostrar todos los registros
    @GetMapping("/movimientoDinero")
    public String movimientoDinero(Model model){
        List<MovimientoDinero> movimientoDinero = this.service.movimientoGetAll();
        model.addAttribute("movimientoDinero", movimientoDinero);
        return "movimientoDinero";
    }

    @GetMapping("/usuarios")
    public  String usuarios(){
        return "usuarios";
    }

    @GetMapping("/empresa")
    public  String empresa(){
        return "empresa";
    }

}