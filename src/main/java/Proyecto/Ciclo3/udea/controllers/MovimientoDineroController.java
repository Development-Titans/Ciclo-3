package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.services.MovimientoDineroInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoDineroController {

    @Autowired // Se cambio el tipo de dato a la interfaz para que funcionen los metodos con inyeccion
    private MovimientoDineroInterface servMovimiento;

    // MOSTRAR MOVIMIENTOS

    @GetMapping("/enterprise/movements")
    public ResponseEntity<List<MovimientoDinero>> getMovimiento(){
        return new ResponseEntity<>(servMovimiento.movimientoGetAll(), HttpStatus.OK);
    }

    // BUSCAR MOVIMIENTO POR ID

    /* Para probarla se coloca de la siguiente forma http://localhost:8080/enterprise/movements/1 el 1 es el id a
    consultar*/
    @GetMapping("/enterprise/{id}/movements")
    public ResponseEntity<Object> getMovimientoId(@PathVariable Integer id) {
        try {
            MovimientoDinero e = servMovimiento.movimientoGetId(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }catch (Exception e){
            ObjetoRespuesta s = new ObjetoRespuesta(); /* Se inicializa un objeto de respuesta*/
            return new ResponseEntity<>(s.getRespuestaMovimiento(), HttpStatus.INTERNAL_SERVER_ERROR); /* Se muestra el error
            por si no encuentra el id */
        }
    }

    // CREAR DATOS

    @PostMapping("/enterprise/movements")
    public ResponseEntity<String> crearDatos(@RequestBody MovimientoDinero movimientoRegistro){
        try { /* Retorna un mensaje de exito o de error */
            String men = servMovimiento.addMovimiento(movimientoRegistro);/* La variable men se crea aqui mismo y servMovimiento
            es la variable que hay en esta clase */
            return new ResponseEntity<>(men, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("El movimineto de dinero ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR DATOS

    /* Para probar este metodo nos vamos a la url http://localhost:8080/enterprise/movements/1 en postman, seleccionamos el
    metodo Patch, seleccionamos el boton body, seleccionamos raw, luego cambiamos text por JSON
     */

    @PatchMapping("/enterprise/{id}/movements")
    public ResponseEntity<String> actualizarDatos(@RequestBody MovimientoDinero movimientoRegistro, @PathVariable Integer id){ /* En el
        parametro estamos enviando la informacion y el id que vamos actualizar*/
        try {
            servMovimiento.updateMovimiento(movimientoRegistro, id);/* ServMovimiento es la variable de esta clase
            se invoca el metodo que esta en la clse servicio y se envian los paramtros*/
            return new ResponseEntity<>("Se actualizo el movimiento de dinero correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("El id del movimineto de dinero no esta en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BORRAR DATOS

    @DeleteMapping("/enterprise/{id}/movements")
    public ResponseEntity<String> borrarEmpleado(@PathVariable Integer id){
        try {
            servMovimiento.deleteMovimiento(id);// Se envia el id que se va a eliminar
            return new ResponseEntity<>("El movimineto de dinero se borro con exito", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("El id de movimiento de dinero no se logro encontrar para eliminarla", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
