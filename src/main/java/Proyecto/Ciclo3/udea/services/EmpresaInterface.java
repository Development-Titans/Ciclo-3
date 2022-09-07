package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empresa;

import java.util.List;

public interface EmpresaInterface {

    public List<Empresa> empresaGetAll();
    public Empresa empresaGetId(Integer id) throws Exception ;
}
