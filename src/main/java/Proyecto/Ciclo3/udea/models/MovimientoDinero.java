package Proyecto.Ciclo3.udea.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "movimiento_dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movimento_dinero")
    @JsonIgnore
    private Integer idMovimientoDinero;

    private String concepto;

    private float monto;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_empleado", insertable = false, updatable = false)/* Esto se hace porque no vamos a crear ni
    actualizar empleados desde esta tabla, por ende se va a mapear o guiar desde el id de empleado directamente y aqui solo se va
    asignar un id de lo que ya esta creado */
    private Empleado usuario;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false) /* Esto se hace porque no vamos a crear ni
    actualizar empresas desde esta tabla, por ende se va a mapear o guiar desde el id de empresa directamente y aqui solo se va
    asignar un id de lo que ya esta creado */
    private Empresa empresa;
    @Column(name = "fecha_creacion")

    private LocalDate fechaCreacion;
    @Column(name = "fecha_actualizacion")

    private LocalDate fechaActualizacion;

    public MovimientoDinero() {
    }

    public MovimientoDinero(Integer idMovimientoDinero, String concepto, float monto, Empleado usuario, Empresa empresa, LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.idMovimientoDinero = idMovimientoDinero;
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = empresa;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return idMovimientoDinero;
    }

    public void setId(Integer idMovimientoDinero) {
        this.idMovimientoDinero = idMovimientoDinero;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
