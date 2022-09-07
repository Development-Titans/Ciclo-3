package Proyecto.Ciclo3.udea.models;

public class ObjetoRespuesta {

    private String respuestaEmpresa = "La empresa no se encuentra";

    public ObjetoRespuesta(String respuestaEmpresa) {
        this.respuestaEmpresa = respuestaEmpresa;
    }

    public ObjetoRespuesta() {
    }

    public String getRespuestaEmpresa() {
        return respuestaEmpresa;
    }

    public void setRespuestaEmpresa(String respuestaEmpresa) {
        this.respuestaEmpresa = respuestaEmpresa;
    }
}
