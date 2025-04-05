public class Eleicoes {
    
    // Atributos
    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;
    
    // Construtor
    public Eleicoes(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }
    
    // Método para calcular percentual de votos válidos
    public double calcularPercentualValidos() {
        return (double) votosValidos / totalEleitores * 100.0;
    }
    
    // Método para calcular percentual de votos brancos
    public double calcularPercentualBrancos() {
        return (double) votosBrancos / totalEleitores * 100.0;
    }
    
    // Método para calcular percentual de votos nulos
    public double calcularPercentualNulos() {
        return (double) votosNulos / totalEleitores * 100.0;
    }
    
    // Método principal para teste
    public static void main(String[] args) {
        Eleicoes eleicao = new Eleicoes(1000, 800, 150, 50);
        System.out.printf("Percentual de votos válidos: %.2f%%\n", eleicao.calcularPercentualValidos());
        System.out.printf("Percentual de votos brancos: %.2f%%\n", eleicao.calcularPercentualBrancos());
        System.out.printf("Percentual de votos nulos: %.2f%%\n", eleicao.calcularPercentualNulos());
    }
}
