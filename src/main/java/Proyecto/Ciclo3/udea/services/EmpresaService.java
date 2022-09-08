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

    // VER EMPRESAS
    @Override // Inyeccion, oblica a crear una interface diferente al repositorio, sirve para enviar una peticion al repositorio
    public List<Empresa> empresaGetAll() {
        return repoEmpresa.findAll();
    }

    // VER EMPRESA BUSCADA POR ID
    @Override
    public Empresa empresaGetId(Integer id) throws Exception {
        Optional<Empresa> s = repoEmpresa.findById(id);
        if (s.isPresent()) { /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
            }
        throw new Exception("La empresa no existe");

    }

    // CREAR UNA EMPRESA
    @Override
    public String addempresa(Empresa empresa_parametro) throws Exception{
        try {/* Se valida que el id no exista*/
            empresaGetId(empresa_parametro.getId());/* Si encuentra el id pasa a la linea 44*/
        }catch (Exception e){
            repoEmpresa.save(empresa_parametro); /* Sino encuentra el id, se ingresan los datos*/
            return "Se agrego la empresa exitosamente";
        }
        throw new Exception("La empresa que intenta agregar ya existe");
    }

    // ACTUALIZACION DE DATOS
    @Override
    public String actualizarEmpresa(Empresa emp, Integer id) throws Exception{ /* Recibimos los parametros del
        controlador */
        try {
            Empresa g = empresaGetId(id); /* Se busca el id en el metodo de la linea 26, si encuentra el id
            entonces guarda todos los datos de esa empresa en la variable g, en las siguientes lineas se modifican los
            datos*/
            g.setId(id); // Se modifica id
            g.setNombre(emp.getNombre()); /* El emp viene del parametro y el getnombre es el metodo para mostrar o colocar
            el nombre de la empresa que envia el usuario y se cambia el nombre al mismo tiempo */
            g.setNit(emp.getNit());
            g.setTelefono(emp.getTelefono());
            g.setDireccion(emp.getDireccion());
            g.setFechaActualizacion(emp.getFechaActualizacion());
            g.setFechaCreacion(emp.getFechaCreacion());
            repoEmpresa.save(g); // Finalmente se guarda lo que se modifico en la variable g y quedan actualizados los datos
            return "Se actualizaron los datos con exito";
        }catch (Exception e){
            throw new Exception("El id que intenta actualizar no esta en la base de datos");
        }
    }

    // BORRAR DATOS
    @Override
    public String borrar(Integer id) throws Exception{
        try {
            repoEmpresa.deleteById(id); // Si encuentra el id entonces borra la empresa
            return "La empresa se elimino con exito";
        }catch (Exception e){
            throw new Exception("El id de la empresa que quiere eliminar no se encuentra");
        }
    }
}



