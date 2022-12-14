package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empleado;

import java.util.List;

public interface EmpleadoInterface {

    public List<Empleado> empleadoGetAll();

    public Empleado empleadoGetId(String correo) throws Exception;

    public String addEmpleado (Empleado empresaRegistro) throws Exception;

    public String updateEmpleado (Empleado emp, String correo) throws Exception;

    public String borrarEmpleado (String correo) throws Exception;

}
