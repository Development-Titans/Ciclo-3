package Proyecto.Ciclo3.udea.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado") // Cambiando nombre de la columna por buenas practicas
    private Integer idEmpleado;
    private String nombre;
    private String correo;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;
    @Enumerated(EnumType.STRING)
    private Enum_NombreRol rol;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false) /* Esto se hace porque NO vamos a crear
    empresas desde esta tabla, por ende se va a mapear o guiar desde el id de empresa directamente y aqui solo se va
    asignar un id de lo que ya esta creado */
    private Empresa empresa;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<MovimientoDinero> transaccion;
    @Column(name = "fecha_creacion") // Cambiando nombre de la columna por buenas practicas
    private LocalDate fechaCreacion;
    @Column(name = "fecha_actualizacion") // Cambiando nombre de la columna por buenas practicas
    private LocalDate fechaActualizacion;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String correo, Perfil perfil, Enum_NombreRol rol, Empresa empresa, List<MovimientoDinero> transaccion, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.rol = rol;
        this.empresa = empresa;
        this.transaccion = transaccion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Enum_NombreRol getRol() {
        return rol;
    }

    public void setRol(Enum_NombreRol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<MovimientoDinero> transaccion) {
        this.transaccion = transaccion;
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
