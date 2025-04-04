package entity;

public class Voto {
    private int codigo;
    private int voto;
    private String validador; //hash
    //datahora
    public Voto() {
    }
    public Voto(int codigo, int voto, String validador) {
        this.codigo = codigo;
        this.voto = voto;
        this.validador = validador;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getVoto() {
        return voto;
    }
    public void setVoto(int voto) {
        this.voto = voto;
    }
    public String getValidador() {
        return validador;
    }
    public void setValidador(String validador) {
        this.validador = validador;
    }
    
}
