import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase para la gestion de ficheros
 * @author Ismael <br />
 * <a href="https://museumis.github.io/Si/">Web personal</a>
 *
 */
public class ManejadorFichero {

	public ManejadorFichero() {

	}

	/**
	 * Devuelve el fichero completo en forma de cadena
	 * 
	 * @return una cadena que contiene el fichero apunando por la rutadelficheo
	 */
	public String cargarFicher(String rutaFichero) {
		String archivo = "";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(rutaFichero));
			String linea;
			while ((linea = br.readLine()) != null) {
				archivo += linea + "\n";
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace(); 

		} catch (IOException e) {
			e.printStackTrace(); 

		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace(); 
			
		}

		return archivo;
	}

	/**
	 * Guardar fichero apuntado en {@link #rutaFichero}
	 * 
	 * @param contenido texto del fichero
	 * 
	 */
	public void guardarFichero(String contenido, String rutaFichero)  {
		BufferedWriter bw=null;
		try {
			bw = new BufferedWriter(new FileWriter(rutaFichero));
			bw.write(contenido);
		} catch (IOException e) {
			e.printStackTrace(); 
			
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace(); 
			
		}

	}

}
