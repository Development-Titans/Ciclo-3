package Proyecto.Ciclo3.udea.controllers;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.services.EmpresaInterface;
import Proyecto.Ciclo3.udea.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/enterprise")/* Para probarlo se copio los datos que mostro en el metodo get de la linea 28
    con todas las llaves e informacion, de la siguiente forma:
    {
    "nombre": "Juan manuel",
    "nit": "145284",
    "telefono": "14526894",
    "direccion": "Cra 16 # 2 - 15",
    "usuario": [
        {
            "idEmpleado": 1,
            "nombre": "Juan Taborda",
            "correo": "alejandro@gmail.com",
            "rol": "Administrador",
            "fechaCreacion": "2022-09-16",
            "fechaActualizacion": "2022-09-20"
        }
    ],
    "fechaCreacion": "2022-10-17",
    "fechaActualizacion": "2022-07-21",
    "id_empresa": 3,
    "transaccion": [
        {
            "id": 2
        }
        ]
    }

    Las lineas 44, 45, 46, 47, 58, 59, y 60 son los datos nuevos para la tabla empresa, los demas datos no se cambian, esos
    ya vienen definidos por las otras clases, si se cambian generan error*/
    public ResponseEntity<String> crearDatos(@RequestBody Empresa empresa_parametro){
        try { /* Retorna un mensaje de exito o de error */
            String men = servEmpresa.addempresa(empresa_parametro); /* La variable men se crea aqui mismo y servEmpresa
            es la variable que hay en esta clase */
            return new ResponseEntity<>(men, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("La empresa ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
