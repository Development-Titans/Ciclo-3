package Proyecto.Ciclo3.udea.services;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import Proyecto.Ciclo3.udea.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService implements MovimientoDineroInterface {

    @Autowired /* Crea inyecciones de esta variable*/
    private MovimientoDineroRepository repoMovimiento;

    // VER EMPRESAS

    @Override // Inyeccion, oblica a crear una interface diferente al repositorio, sirve para enviar una peticion al repositorio
    public List<MovimientoDinero> movimientoGetAll() {
        return repoMovimiento.findAll();
    }

    // VER MOVIMIENTO BUSCADA POR ID

    @Override
    public MovimientoDinero movimientoGetId(Integer id) throws Exception {
        Optional<MovimientoDinero> s = repoMovimiento.findById(id);
        if (s.isPresent()) { /* Si hay datos en la variable entonces: */
            return s.get(); /* Devuelve lo que tiene dentro la variable para verla en controladores*/
        }
        throw new Exception("El movimiento de dinero no existe");

    }

    // CREAR UN MOVIMIENTO

    @Override
    public String addMovimiento(MovimientoDinero movimientoRegistro) throws Exception{
        try {/* Se valida que el id no exista*/
            movimientoGetId(movimientoRegistro.getId());//Problemas con el tipo de variable
        }catch (Exception e){
            repoMovimiento.save(movimientoRegistro);/* Sino encuentra el id, se ingresan los datos*/
            return "Se agrego el movimineto de dinero exitosamente";
        }
        throw new Exception("El movimiento de dinero que intenta agregar ya existe");
    }

    // ACTUALIZACION DE DATOS

    @Override
    public String updateMovimiento(MovimientoDinero mov, Integer id) throws Exception{ /* Recibimos los parametros del
        controlador */
        try {
            MovimientoDinero g = movimientoGetId(id); /* Se busca el id en el metodo de la linea 26, si encuentra el id
            entonces guarda todos los datos de esa empresa en la variable g, en las siguientes lineas se modifican los
            datos*/
            g.setId(id); // Se modifica id
            g.setConcepto(mov.getConcepto());
            g.setMonto(mov.getMonto());
            g.setEmpresa(mov.getEmpresa());
            g.setFechaCreacion(mov.getFechaCreacion());
            g.setFechaActualizacion(mov.getFechaActualizacion());
            repoMovimiento.save(g); // Finalmente se guarda lo que se modifico en la variable g y quedan actualizados los datos
            return "Se actualizaron los datos con exito";
        }catch (Exception e){
            throw new Exception("El id que intenta actualizar no esta en la base de datos");
        }
    }

    // BORRAR DATOS

    @Override
    public String deleteMovimiento(Integer id) throws Exception{
        try {
            repoMovimiento.deleteById(id); // Si encuentra el id entonces borra el movimiento
            return "El movimiento de dinero se elemino con exito se elimino con exito";
        }catch (Exception e){
            throw new Exception("El id del movimineto de dinero que quiere eliminar no se encuentra");
        }
    }

}
