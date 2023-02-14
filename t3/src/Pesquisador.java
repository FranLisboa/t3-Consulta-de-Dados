public class Pesquisador implements Comparable<Pesquisador> {
    private int id_servidor;
    private String nome;
    private int id_unidade;
    private String unidade;
    private int id_centro;
    private String centro;
    private int coordenador;
    private int internos;
    private int externos;

    public Pesquisador(int id_servidor, String nome, int id_unidade, String unidade, int id_centro, String centro, int coordenador, int internos, int externos) {
        this.id_servidor = id_servidor;
        this.nome = nome;
        this.id_unidade = id_unidade;
        this.unidade = unidade;
        this.id_centro = id_centro;
        this.centro = centro;
        this.coordenador = coordenador;
        this.internos = internos;
        this.externos = externos;
    }

    public int getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(int id_servidor) {
        this.id_servidor = id_servidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(int id_unidade) {
        this.id_unidade = id_unidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public int getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(int coordenador) {
        this.coordenador = coordenador;
    }

    public int getInternos() {
        return internos;
    }

    public void setInternos(int internos) {
        this.internos = internos;
    }

    public int getExternos() {
        return externos;
    }

    public void setExternos(int externos) {
        this.externos = externos;
    }

    @Override
    public String toString() {
        return "Pesquisador{" +
                "id_servidor=" + id_servidor +
                ", nome=" + nome  +
                ", id_unidade=" + id_unidade +
                ", unidade=" + unidade  +
                ", id_centro=" + id_centro +
                ", centro=" + centro  +
                ", coordenador=" + coordenador +
                ", internos=" + internos +
                ", externos=" + externos +
                '}';
    }

    @Override
    public int compareTo(Pesquisador o) {
        int comparaNome= this.getNome().compareTo(o.getNome());
        return comparaNome;
    }

    public String resumoCSV(){
        return "\""+getId_servidor()+"\";\""+getNome()+"\";\""+ getId_unidade()+"\";\""+getUnidade()+"\";\""+getId_centro()+"\";\""+getCentro()+"\";\""+getCoordenador()+"\";\""+getInternos()+"\";\""+getExternos()+"\"";
    }
}
