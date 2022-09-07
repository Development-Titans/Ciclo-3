package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repoEmpresa;

    @Autowired
    public List<Empresa> empresaGetAll(){
        return repoEmpresa.findAll();
    }

    public Empresa empresaGetId(Integer id) throws Exception{

        Optional<Empresa> s = repoEmpresa.findById(id);
        if (s.isPresent()){ /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
            }
        throw new Exception("La empresa que busca no existe");

    }





}

