package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
