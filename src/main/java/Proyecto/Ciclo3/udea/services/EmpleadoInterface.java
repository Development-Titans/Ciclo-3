package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empleado;

import java.util.List;

public interface EmpleadoInterface {

    public List<Empleado> empleadoGetAll();

    public Empleado empleadoGetId(Integer id) throws Exception;

    public String addEmpleado (Empleado empresaRegistro) throws Exception;

    public String updateEmpleado (Empleado emp, Integer id) throws Exception;

    public String borrarEmpleado (Integer id) throws Exception;

}
