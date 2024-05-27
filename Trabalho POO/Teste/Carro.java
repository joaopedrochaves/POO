class Carro {
    private String modelo;
    private String marca;
    private int cavalos;
    private int ano;
    public Carro(String modelo, String marca, int cavalos, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.cavalos = cavalos;
        this.ano = ano;
    }
    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Marca: " + marca + ", Cavalos: " + cavalos + ", Ano: " + ano;
    }
}