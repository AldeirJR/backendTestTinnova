import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EleicoesTest {
    
    @Test
    void testCalcularPercentualValidos() {
        Eleicoes eleicao = new Eleicoes(1000, 800, 150, 50);
        double percentualValidos = eleicao.calcularPercentualValidos();
        assertEquals(80.0, percentualValidos, 0.001, "O percentual de votos válidos deve ser 80%");
    }
    
    @Test
    void testCalcularPercentualBrancos() {
        Eleicoes eleicao = new Eleicoes(1000, 800, 150, 50);
        double percentualBrancos = eleicao.calcularPercentualBrancos();
        assertEquals(15.0, percentualBrancos, 0.001, "O percentual de votos brancos deve ser 15%");
    }
    
    @Test
    void testCalcularPercentualNulos() {
        Eleicoes eleicao = new Eleicoes(1000, 800, 150, 50);
        double percentualNulos = eleicao.calcularPercentualNulos();
        assertEquals(5.0, percentualNulos, 0.001, "O percentual de votos nulos deve ser 5%");
    }
}
