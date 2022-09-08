package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.Empresa;
import Proyecto.Ciclo3.udea.models.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {

}
