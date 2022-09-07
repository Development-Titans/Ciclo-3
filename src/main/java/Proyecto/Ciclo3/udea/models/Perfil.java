package Proyecto.Ciclo3.udea.models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_perfil")
    private Integer idPerfil;
    private String imagen;
    private String telefono;
    @OneToOne(mappedBy = "perfil")
    private Empleado usuario;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    public Perfil() {
    }

    public Perfil(Integer idPerfil, String imagen, String telefono, Empleado usuario, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.idPerfil = idPerfil;
        this.imagen = imagen;
        this.telefono = telefono;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public long getId() {
        return idPerfil;
    }

    public void setId(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
