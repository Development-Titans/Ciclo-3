package Proyecto.Ciclo3.udea.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    private String fechaCreacion;
    @Column(name = "fecha_actualizacion")

    private String fechaActualizacion;

    private float ingresos;

    private float egresos;

    public MovimientoDinero() {
    }

    public MovimientoDinero(Integer idMovimientoDinero, String concepto, float monto, float ingresos, float egresos, Empleado usuario, Empresa empresa, String fechaCreacion, String fechaActualizacion) {
        this.idMovimientoDinero = idMovimientoDinero;
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = empresa;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.egresos = egresos;
        this.ingresos = ingresos;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public float getIngresos() {
        return ingresos;
    }

    public void setIngresos(float ingresos) {
        this.ingresos = ingresos;
    }

    public float getEgresos() {
        return egresos;
    }

    public void setEgresos(float egresos) {
        this.egresos = egresos;
    }

    
}
