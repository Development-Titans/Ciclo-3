package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {

}
