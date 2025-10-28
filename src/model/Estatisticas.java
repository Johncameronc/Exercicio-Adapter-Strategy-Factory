package model;

public class Estatisticas {
    private int curtidas;
    private int compartilhamentos;
    private int comentarios;
    private int visualizacoes;

    public Estatisticas(int curtidas, int compartilhamentos, int comentarios, int visualizacoes) {
        this.curtidas = curtidas;
        this.compartilhamentos = compartilhamentos;
        this.comentarios = comentarios;
        this.visualizacoes = visualizacoes;
    }

    public int getCurtidas() { return curtidas; }
    public int getCompartilhamentos() { return compartilhamentos; }
    public int getComentarios() { return comentarios; }
    public int getVisualizacoes() { return visualizacoes; }
}
