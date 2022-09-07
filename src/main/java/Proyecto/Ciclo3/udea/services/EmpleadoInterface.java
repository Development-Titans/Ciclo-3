package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empleado;

import java.util.List;

public interface EmpleadoInterface {

    public List<Empleado> empleadoGetAll();

    public Empleado empleadoGetId(Integer id) throws Exception;
}
