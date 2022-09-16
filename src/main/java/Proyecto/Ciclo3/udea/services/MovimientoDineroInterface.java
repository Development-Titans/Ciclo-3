package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;

import java.util.List;

public interface MovimientoDineroInterface {

    public List<MovimientoDinero> movimientoGetAll();
    public MovimientoDinero movimientoGetId(Integer id) throws Exception ;
    public String addMovimiento(MovimientoDinero registroMovimiento) throws Exception;
    public String updateMovimiento(MovimientoDinero mov, Integer id) throws Exception;
    public String deleteMovimiento(Integer id) throws Exception;

}
