package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaController {
    @Autowired
    private EmpresaService servEmpresa;

    // MOSTRAR EMPRESAS

    @GetMapping("/enterprise")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        return new ResponseEntity<>(servEmpresa.empresaGetAll(), HttpStatus.OK);
    }

    // BUSCAR EMPRESA POR ID

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Empresa> getEmpresasId(@PathVariable Integer id) throws Exception{
        try {
            Empresa e = servEmpresa.empresaGetId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("El id de la empresa no se encontro");
        }

    }
}
