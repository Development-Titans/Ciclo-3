package Proyecto.Ciclo3.udea.models;

public class ObjetoRespuesta {

    private String respuestaEmpresa = "La empresa no se encuentra";
    private String respuestaEmpleado = "El empleado no se encuentra";

    public ObjetoRespuesta(String respuestaEmpresa, String respuestaEmpleado) {
        this.respuestaEmpresa = respuestaEmpresa;
        this.respuestaEmpleado = respuestaEmpleado;
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
}
