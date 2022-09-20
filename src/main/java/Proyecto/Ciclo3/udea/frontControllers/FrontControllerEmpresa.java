package Proyecto.Ciclo3.udea.frontControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import Proyecto.Ciclo3.udea.services.EmpresaInterface;

@Controller
public class FrontControllerEmpresa {

    @Autowired
    EmpresaInterface empresaController;

    @GetMapping("/empresa")
    public String empresa() {
        return "empresa";
    }

    @GetMapping("/crearEmpresa")
    public String crearEmpresa() {
        return "crearEmpresa";
    }
}
