package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    /* Update es para actualizar, luego sigue el nombre de la clase o de la tabla, la u le estamos diciendo
    que todo lo de Empresa va a estar en la variable u. El set es porque vamos a setear o a cambiar los campos, que vamos
    a indicar. luego va u.nombre donde u es la clase y "nombre" es el nombre del atributo que esta en esa clase
    o tabla y vamos a cambiar, despues colocamos los : y alli colocamos el nombre del parametro que traemos en el metodo,
    hacemos esto mismo con los demas parametro que deseamos actualizar... Luego le escribimos WHERE el cual indica en que
    id vamos a realizar estas modificaciones, es decir que sigue u.nombrevariableid= :iddelparametro*/
    /* @Modifying */ /* Le decimos al repositorio que vamos a modificar los datos con el siguiente metodo */
    /* @Query("UPDATE Empresa u SET u.nombre= :nombre, u.nit= :nit, u.telefono= :telefono, u.direccion= :direccion, u.fechaActualizacion= :fechaActualizacion, u.fechaCreacion= :fechaCreacion WHERE u.id_empresa= :id")
    /* public int actualizar(String nombre, String nit, String telefono, String direccion, LocalDate fecha_creacion,
    LocalDate fechaActualizacion, Integer id); */

}

