# 📄 Examen de Test Unitarios - COD  

Este repositorio contiene la implementación de la clase Main para validar un DNI español y su correspondiente test unitario con JUnit 5.  
## 📌 Contenido  

    1. Descripción del Código  
    2. Errores Detectados  
    3. Cambios Necesarios en los Tests  
    4. Instrucciones para Ejecutar los Tests  
    5. Estructura del Proyecto  

## 📜 Descripción del Código  

El código contiene una clase Main que incluye dos métodos principales:  

    comprobarDNI(String dni, char letra):  
    📌 Verifica si la letra del DNI es correcta según las reglas del DNI español.  
    calcularLetraDNI(String dni):  
    📌 Calcula la letra correspondiente al número del DNI utilizando el módulo 23.  

Los tests se encuentran en la clase DNITest.java y verifican el funcionamiento correcto del código utilizando JUnit 5 y pruebas parametrizadas.  

## ❌ Errores Detectados  

Se encontró un error en la validación del DNI:  

   ### Problema:  
    No se comprueba si el DNI tiene 8 caracteres y solo números antes de calcular su letra.  
    Esto puede generar un NumberFormatException si la entrada es incorrecta (ejemplo: "123", "ABCDEFGH", "").  

   ### Solución Implementada:  
    Se agregó una validación en comprobarDNI para asegurar que el DNI: ✅ Tiene 8 caracteres  
    ✅ Contiene solo dígitos  

## 🔹 Código corregido:  

public static boolean comprobarDNI(String dni, char letra) {  
    // Validar que el DNI tenga 8 caracteres numéricos  
    if (dni == null || dni.length() != 8 || !dni.matches("\\d+")) {  
        return false; // DNI inválido  
    }  
    
    // Calcular la letra esperada  
    char letraCalculada = calcularLetraDNI(dni);  
    return letraCalculada == letra;  
}  

## 🔄 Cambios Necesarios en los Tests  

Si no hubiera una comprobación previa de la longitud del DNI, los tests deberían incluir más casos de entrada inválida:  

@ParameterizedTest  
@CsvSource({  
    "123, Z, false",      // DNI demasiado corto  
    "123456789, T, false",// DNI demasiado largo  
    "'', Z, false",       // DNI vacío  
    "ABCDEFGH, Z, false"  // DNI con letras  
})  
void testDNIInvalido(String dni, char letra, boolean esperado) {  
    assertEquals(esperado, Main.comprobarDNI(dni, letra));  
}  

Esto garantizaría que el código detecte DNIs incorrectos correctamente.  
## ⚙️ Instrucciones para Ejecutar los Tests  

### 🔹 Opción 1: Desde IntelliJ IDEA o Eclipse  

    Abre el proyecto.  
    Haz clic derecho sobre DNITest.java.  
    Selecciona "Run DNITest" para ejecutar los tests.  

### 🔹 Opción 2: Desde la Terminal  

    Si usas Maven, ejecuta:  

mvn test  

Si usas Gradle, ejecuta:  

    gradle test  

## 📂 Estructura del Proyecto  

📦 proyecto-dni  
 ┣ 📂 src  
 ┃ ┣ 📂 main  
 ┃ ┃ ┗ 📜 Main.java  # Código principal  
 ┃ ┣ 📂 test  
 ┃ ┃ ┗ 📜 DNITest.java  # Tests unitarios  
 ┣ 📜 pom.xml  # Dependencias Maven (JUnit 5)  
 ┣ 📜 README.md  # Este archivo  

## ✅ Conclusión  

    Se han implementado tests unitarios parametrizados para validar el DNI.  
    Se detectó y corrigió un error en la validación de la entrada.  
    Se explicaron los cambios necesarios en los tests en caso de que la validación no existiera previamente.  

¡Ahora el código es más robusto y confiable! 🚀  
