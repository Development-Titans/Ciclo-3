package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.services.EmpleadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoInterface servEmpleado;

    // MOSTRAR EMPLEADOS

    @GetMapping("/users")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return new ResponseEntity<>(servEmpleado.empleadoGetAll(), HttpStatus.OK);
    }

    // BUSCAR EMPLEADO POR ID

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getEmpleadoId(@PathVariable Integer id){
        try {
            Empleado e = servEmpleado.empleadoGetId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }catch (Exception e){
            ObjetoRespuesta s = new ObjetoRespuesta();
            return new ResponseEntity<>(s.getRespuestaEmpleado(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // CREAR DATOS

    @PostMapping("/users")
    public ResponseEntity<String> crearDatos(@RequestBody Empleado empleadoRegistro){
        try {
            String men = servEmpleado.addEmpleado(empleadoRegistro);
            return new ResponseEntity<>(men, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("El empleado ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR DATOS

    @PatchMapping("/users/{id}")
    public ResponseEntity<String> actualizarDatos(@RequestBody Empleado empleadoRegistro, @PathVariable Integer id){
        try {
            servEmpleado.updateEmpleado(empleadoRegistro, id);
            return new ResponseEntity<>("Se actualizo el empleado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("El id del empleado no esta en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BORRAR
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> borrarDatos(@PathVariable Integer id){
        try {
            servEmpleado.borrarEmpleado(id); // Se envia el id que se va a eliminar
            return new ResponseEntity<>("El empleado se borro con exito", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("El id del empleado no se logro encontrar para eliminarla", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
