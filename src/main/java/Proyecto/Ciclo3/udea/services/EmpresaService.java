package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.models.ObjetoRespuesta;
import Proyecto.Ciclo3.udea.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements EmpresaInterface { // Se genera superclase de Inteface para que funcione

    @Autowired /* Crea inyecciones de esta variable*/
    private EmpresaRepository repoEmpresa;

    @Override // Inyeccion, oblica a crear una interface diferente al repositorio, sirve para enviar una peticion al repositorio
    public List<Empresa> empresaGetAll() {
        return repoEmpresa.findAll();
    }

    @Override
    public Empresa empresaGetId(Integer id) throws Exception {
        Optional<Empresa> s = repoEmpresa.findById(id);
        if (s.isPresent()) { /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
            }
        throw new Exception("La empresa no existe");

    }
}

