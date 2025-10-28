package model;

public class Publicacao {
    private String id;
    private String plataforma;
    private String conteudo;
    private String status;
    private long timestamp;

    public Publicacao(String id, String plataforma, String conteudo) {
        this.id = id;
        this.plataforma = plataforma;
        this.conteudo = conteudo;
        this.status = "publicado";
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() { return id; }
    public String getPlataforma() { return plataforma; }
    public String getStatus() { return status; }
}
