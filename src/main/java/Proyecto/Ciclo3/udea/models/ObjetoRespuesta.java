package Proyecto.Ciclo3.udea.models;

public class ObjetoRespuesta {

    private String respuestaEmpresa = "La empresa no se encuentra";
    private String respuestaEmpleado = "El empleado no se encuentra";
    private String respuestaMovimiento = "El Movimiento de dinero no se encuentra";

    public ObjetoRespuesta(String respuestaEmpresa, String respuestaEmpleado, String respuestaMovimiento) {
        this.respuestaEmpresa = respuestaEmpresa;
        this.respuestaEmpleado = respuestaEmpleado;
        this.respuestaMovimiento = respuestaMovimiento;
    }

    public ObjetoRespuesta() {
    }

    public String getRespuestaEmpresa() {
        return respuestaEmpresa;
    }

    public void setRespuestaEmpresa(String respuestaEmpresa) {
        this.respuestaEmpresa = respuestaEmpresa;
    }

    public String getRespuestaEmpleado() {
        return respuestaEmpleado;
    }

    public void setRespuestaEmpleado(String respuestaEmpleado) {
        this.respuestaEmpleado = respuestaEmpleado;
    }

    public String getRespuestaMovimiento() {
        return respuestaMovimiento;
    }

    public void setRespuestaMovimiento(String respuestaMovimiento) {
        this.respuestaMovimiento = respuestaMovimiento;
    }
}
