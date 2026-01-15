import java.io.*;
import java.util.HashMap;

public class Datos {
  public static void main(String[] args) {
    File f = new File("./codigos_postales_hmo.csv");
    // Aqui almacenamos los codigos postales y hacemos el contador
    HashMap<String, Integer> hash = new HashMap<>();
    String linea;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
      br.readLine(); // Leemos el archivo sin el encabezado

      while ((linea = br.readLine()) != null) {
        String[] palabra = linea.split(",");

        if (palabra.length >= 2) {
          String cp = palabra[1].trim();
          // aqui vamos incrementando el numero de asentamientos de los codigos
          hash.put(cp, hash.getOrDefault(cp, 0) + 1);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // para finalmente mostrar los resultados
    for (String cp : hash.keySet()) {
      System.out.println("Código postal: " + cp + " - Número de asentamientos: " + hash.get(cp));
    }
  }
}