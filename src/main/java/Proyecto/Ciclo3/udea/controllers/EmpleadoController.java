package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.services.EmpleadoService;
import Proyecto.Ciclo3.udea.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService servEmpleado;

    //MOSTRAR EMPLEADOS
    @GetMapping("/enterprise")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return new ResponseEntity<>(servEmpleado.empleadoGetAll(), HttpStatus.OK);
    }

    //BUSCAR EMPLEADO POR ID
    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Object> getEmpleadoId(@PathVariable Integer id){
        try {
            Empleado e = servEmpleado.empleadoGetId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }catch (Exception e){
            ObjetoRespuesta s = new ObjetoRespuesta();
            return new ResponseEntity<>(s.getRespuestaEmpleado(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
