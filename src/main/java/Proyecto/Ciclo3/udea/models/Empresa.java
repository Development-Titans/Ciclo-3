package Proyecto.Ciclo3.udea.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa") // Se organiza el nombre por buenas practicas
    private Integer idEmpresa;
    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;
    private String director;
    private String correo;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa") // Se mapea porque es la que maneja la cantidad
    private List<Empleado> usuario;
    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> Transaccion;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String correo, String director, String nombre, String nit, String telefono, String direccion, List<Empleado> usuario, List<MovimientoDinero> transaccion, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.correo = correo;
        Transaccion = transaccion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return idEmpresa;
    }

    public void setId(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Empleado> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Empleado> usuario) {
        this.usuario = usuario;
    }

    public List<MovimientoDinero> getTransaccion() {
        return Transaccion;
    }

    public void setTransaccion(List<MovimientoDinero> transaccion) {
        Transaccion = transaccion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
