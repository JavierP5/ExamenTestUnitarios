import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DNITest {

    @ParameterizedTest
    @CsvSource({
            "00000000, T, true", // Caso correcto
            "12345678, Z, true", // Caso correcto
            "87654321, X, true", // Caso correcto
            "99999999, R, true", // Caso correcto
            "11111111, H, true", // Caso correcto
            "12345678, A, false",  // Letra incorrecta
            "ABCDEFGH, Z, false",  // Contiene letras
            "123, Z, false",       // Longitud incorrecta
            "'', Z, false"         // Vacío
    })
    void testComprobarDNI(String dni, char letra, boolean esperado) {
        assertEquals(esperado, Main.comprobarDNI(dni, letra));
    }

    @ParameterizedTest
    @CsvSource({
            "00000000, T",
            "12345678, Z",
            "87654321, X",
            "99999999, R",
            "11111111, H"
    })
    void testCalcularLetraDNI(String dni, char letraEsperada) {
        assertEquals(letraEsperada, Main.calcularLetraDNI(dni));
    }
}
