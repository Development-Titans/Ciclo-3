package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
