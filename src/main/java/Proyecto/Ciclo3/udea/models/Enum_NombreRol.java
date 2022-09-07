package Proyecto.Ciclo3.udea.models;
import javax.persistence.ManyToOne;


public enum Enum_NombreRol {
    @ManyToOne
    Administrador, Operario;
}
