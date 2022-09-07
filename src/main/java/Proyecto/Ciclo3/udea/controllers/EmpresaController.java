package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.services.EmpresaInterface;
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
    @Autowired // Se cambio el tipo de dato a la interfaz para que funcionen los metodos con inyeccion
    private EmpresaInterface servEmpresa;

    // MOSTRAR EMPRESAS

    @GetMapping("/enterprise")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        return new ResponseEntity<>(servEmpresa.empresaGetAll(), HttpStatus.OK);
    }

    // BUSCAR EMPRESA POR ID

    @GetMapping("/enterprise/{id}") /* Para probarla se coloca de la siguiente forma http://localhost:8080/enterprise/enterprise/1*/
    public ResponseEntity<Object> getEmpresasId(@PathVariable Integer id) {
        try {
            Empresa e = servEmpresa.empresaGetId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }catch (Exception e){
            ObjetoRespuesta s = new ObjetoRespuesta(); /* Se inicializa un objeto de respuesta*/
            return new ResponseEntity<>(s.getRespuestaEmpresa(), HttpStatus.INTERNAL_SERVER_ERROR); /* Se muestra el error
            por si no encuentra el id */
        }

    }
}


