package Proyecto.Ciclo3.udea.repositories;

import Proyecto.Ciclo3.udea.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    
    @Modifying
    @Query("UPDATE Empleado u SET u.nombre= :nombre, u.contrasena= :contrasena WHERE u.correo= :correo")
    public int update(String nombre, String contrasena, String correo);
}

