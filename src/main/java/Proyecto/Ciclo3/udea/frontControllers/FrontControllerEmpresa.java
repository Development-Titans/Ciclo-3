package Proyecto.Ciclo3.udea.frontControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.services.EmpresaService;

@Controller
// @RequestMapping ("/")
public class FrontControllerEmpresa {

    @Autowired
    private EmpresaService empresaController;

    // @GetMapping("/empresa")
    // public String empresaGetAll() {
    // return "empresa";
    // }

    @GetMapping("/empresa")
    public String lista(Model model) {
        List<Empresa> x = empresaController.empresaGetAll();
        model.addAttribute("x", x);
        return "empresa";
    }

    @GetMapping("/crearEmpresa")
    public String crearEmpresa(@ModelAttribute Empresa empresa, Model model) {
        model.addAttribute("empresa", new Empresa());
        return "crearEmpresa";
    }

    @PostMapping("/crearEmpresa")
    public String agregar(@ModelAttribute Empresa empresa, Model model) throws Exception {
        empresaController.addempresa(empresa);
        return "redirect:/empresa";
    }

}
