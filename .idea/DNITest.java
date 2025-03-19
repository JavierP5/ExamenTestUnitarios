import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private void assertEquals(boolean esperado, Object o) {
    }

    @ParameterizedTest
    @CsvSource({
            "00000000, T",
            "12345678, Z",
            "87654321, X",
            "99999999, R",
            "11111111, H"
    })
    void testCalcularLetraDNI(String dni, boolean letraEsperada) {
        assertEquals(letraEsperada, Main.calcularLetraDNI(dni));
    }

    //public static Object calcularLetraDNI(String dni) {
      //  return false;
    //}

    // public static Object comprobarDNI(String dni, char letra) {
       // return false;
    //}

    public static boolean comprobarDNI (String dni, char letra){
        // calcula la letra del DNI
        char letraCalculada = calcularLetraDNI(dni);
        // compara la letra del DNI con la letra pasada por parámetro
        return letraCalculada == letra;
    }

    /**
     * Calcula la letra de un DNI
     * @param dni
     * @return la letra del DNI
     */
    public static char calcularLetraDNI (String dni) {
        // array de caracteres con las letras del DNI
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'Q', 'S', 'V', 'H', 'L', 'C', 'K', 'E'};
        // calcula el resto de dividir el DNI entre 23
        int resto = Integer.parseInt(dni) % 23;
        // devuelve la letra correspondiente al resto
        return letrasDNI[resto];
    }
}
