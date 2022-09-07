package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empleado;
import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repoEmpleado;

    @Autowired
    public List<Empleado> empleadoGetAll(){
        return repoEmpleado.findAll();
    }

    public Empleado empleadoGetId(Integer id) throws Exception{

        Optional<Empleado> s = repoEmpleado.findById(id);
        if (s.isPresent()){ /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
        }
        throw new Exception("El empleado que busca no existe");

    }
}
