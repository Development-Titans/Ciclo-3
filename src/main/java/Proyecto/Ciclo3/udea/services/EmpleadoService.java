package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements EmpleadoInterface {

    @Autowired
    private EmpleadoRepository repoEmpleado;


    // VER EMPRESAS
    @Override
    public List<Empleado> empleadoGetAll(){
        return repoEmpleado.findAll();
    }


    // BUSCAR POR ID
    @Override
    public Empleado empleadoGetId(Integer id) throws Exception{
        Optional<Empleado> s = repoEmpleado.findById(id);
        if (s.isPresent()){ /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
        }
        throw new Exception("El empleado que busca no existe");

    }

    //CREAR EMPLEADO
    @Override
    public String addEmpleado(Empleado empleadoRegistro) throws Exception{
        try {/* Se valida que el id no exista*/
            empleadoGetId(empleadoRegistro.getIdEmpleado());/* Si encuentra el id pasa a la linea 44*/
        }catch (Exception e){
            repoEmpleado.save(empleadoRegistro); /* Sino encuentra el id, se ingresan los datos*/
            return "Se agrego el empleado exitosamente";
        }
        throw new Exception("El empleado que intenta agregar ya existe");
    }

    // ACTUALIZAR EMPLEADO
    @Override
    public String updateEmpleado(Empleado emp, Integer id) throws Exception{ /* Recibimos los parametros del controlador */
        try {
            Empleado g = empleadoGetId(id);
            g.setIdEmpleado(id); // Se modifica id
            g.setNombre(emp.getNombre());
            g.setCorreo(emp.getCorreo());
            g.setPerfil(emp.getPerfil());
            g.setRol(emp.getRol());
            g.setFechaActualizacion(emp.getFechaActualizacion());
            g.setFechaCreacion(emp.getFechaCreacion());
            repoEmpleado.save(g); // Finalmente se guarda lo que se modifico en la variable g y quedan actualizados los datos
            return "Se actualizaron los datos con exito";
        }catch (Exception e){
            throw new Exception("El id que intenta actualizar no esta en la base de datos");
        }
    }

    // BORRAR DATOS
    @Override
    public String borrarEmpleado(Integer id) throws Exception{
        try {
            repoEmpleado.deleteById(id); // Si encuentra el id entonces borra la empresa
            return "El empleado se elimino con exito";
        }catch (Exception e){
            throw new Exception("El id del empleado que quiere eliminar no se encuentra");
        }
    }
}
