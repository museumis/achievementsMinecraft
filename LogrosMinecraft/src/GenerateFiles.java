import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONWriter;

/**
 * Clase encargada de generar un datapack de logros
 * @author Ismael Martin Ramirez <br />
 * <a href="https://museumis.github.io/Si/">Web personal</a>
 *
 */
public class GenerateFiles {

	String nameDataPack = "fullitem_advancements";
	String nameData = "data";
	String namePackMcMeta = "pack.mcmeta";
	String nameDescripcion = "Full Item advancements";

	String id = "minecraft:";
	String rutaOutJson = "outJson" + File.separator;
	String rutaDirectorioGeneral ="C:"+ File.separator +"Users"+ File.separator +"Bri"+ File.separator +"AppData"+ File.separator +"Roaming"+ File.separator +".minecraft"+ File.separator +"saves"+ File.separator +"TEST"+File.separator+"datapacks" + File.separator;

	String rutaOutFunction = "outFunction" + File.separator;
	String rutaOutFunctionGlobal = "outFunctionGlobal" + File.separator;
	String rutaOutDataPack = "DataPack" + File.separator;
	String rutaOutFileJsonTxt = "OutFileJsonTxt" + File.separator + "allItemMinecraft"+Names.version.replaceAll("\\.","-")+".txt";


	File directorioGeneral;
	File directorioData;
	File directorioHojasFunction;
	File directorioHojasFunctions;
	File directorioHojasJson;
	File directorioAdvancements;
	String rutaFuncionGlobal = directorioHojasFunctions + File.separator + "update_score" + ".mcfunction";

	File direcFuncConstruccion, direcFuncDecoracion, direcFuncRedstone, direcFuncTransporte, direcFuncVarios,
			direcFuncAlimentacion, direcFuncHerramientas, direcFuncCombate, direcFuncPociones,direcFuncLibrosEncantados,direcFuncPocimas,direcFuncFlechasEncantadas;

	File direcJsonConstruccion, direcJsonDecoracion, direcJsonRedstone, direcJsonTransporte, direcJsonVarios,
			direcJsonAlimentacion, direcJsonHerramientas, direcJsonCombate, direcJsonPociones, direcJsonLibrosEncantados,direcJsonPocimas,direcJsonFlechasEncantadas;

	/**
	 * Gestion del proceso
	 */
	public void iniciar() {
		System.out.println("Generando DataPack...");
		
		generarDirectorios();
		addConstruccion();
		addDecoracion();
		addRedstone();
		addTransporte();
		addObjetosvarios();
		addAlimentacion();
		addHerramientas();
		addCombate();
		addPociones();
		addLibrosEncantados();
		addPocimas();
		addFlechas();
		
		generarJsonAllItem();
		
		System.out.println("DataPack generado.");		
	}
	
	/**
	 * Procedimiento para crear un fichero json de todos los item
	 * 
	 */
	public void generarJsonAllItem() {
		JSONObject raiz = new JSONObject();
		JSONObject arrItems = new JSONObject();	

		try {
			raiz.put("descripcion", "Item de Minecraft");
			raiz.put("version", Names.version);
			raiz.put("items", arrItems);
			
			arrItems.put("construccion", Names.construccion);
			arrItems.put("decoracion", Names.decoracion);
			arrItems.put("redstone", Names.redstone);
			arrItems.put("transporte", Names.transporte);
			arrItems.put("objetosvarios", Names.objetosvarios);
			arrItems.put("alimentacion", Names.alimentacion);
			arrItems.put("herramientas", Names.herramientas);
			arrItems.put("combate", Names.combate);
			arrItems.put("pociones", Names.pociones);
			arrItems.put("librosEncantados", Names.librosEncantados);
			arrItems.put("pocimas", Names.pocimas);
			arrItems.put("flechasencantadas", Names.flechasencantadas);
		
			ManejadorFichero saveJson = new ManejadorFichero();
			saveJson.guardarFichero(raiz.toString(), rutaOutFileJsonTxt);
			
		} catch (JSONException e) {
			e.printStackTrace();

		}

	}
	

	/**
	 * Procedimiento para procesar los item de construccion
	 */
	public void addConstruccion() {

		generarRootJson("bricks","Construccion","Obten todos los bloques de construcción","construccion",direcJsonConstruccion.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncConstruccion.getAbsolutePath());
		for (int i = 0; i < Names.construccion.length; i++) {
			generarJsonTxt(Names.construccion[i], direcJsonConstruccion.getAbsolutePath(),"construccion");
			generarFunction(Names.construccion[i], direcFuncConstruccion.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.construccion[i], "construccion");
		}

	}


	/**
	 * Procedimiento para procesar los item de decoracion
	 */
	public void addDecoracion() {

		generarRootJson("peony","Decoracion","Obten todos los bloques de decoracion","decoracion",direcJsonDecoracion.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncDecoracion.getAbsolutePath());
		for (int i = 0; i < Names.decoracion.length; i++) {
			generarJsonTxt(Names.decoracion[i], direcJsonDecoracion.getAbsolutePath(),"decoracion");
			generarFunction(Names.decoracion[i], direcFuncDecoracion.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.construccion[i], "decoracion");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de redstone
	 */
	public void addRedstone() {

		generarRootJson("redstone","Redstone","Obten todos los bloques de redstone","redstone",direcJsonRedstone.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncRedstone.getAbsolutePath());
		for (int i = 0; i < Names.redstone.length; i++) {
			generarJsonTxt(Names.redstone[i], direcJsonRedstone.getAbsolutePath(),"redstone");
			generarFunction(Names.redstone[i], direcFuncRedstone.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.redstone[i], "redstone");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de transporte
	 */
	public void addTransporte() {

		generarRootJson("powered_rail","Transporte","Obten todos los item de transporte","transporte",direcJsonTransporte.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncTransporte.getAbsolutePath());
		for (int i = 0; i < Names.transporte.length; i++) {
			generarJsonTxt(Names.transporte[i], direcJsonTransporte.getAbsolutePath(),"transporte");
			generarFunction(Names.transporte[i], direcFuncTransporte.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.transporte[i], "transporte");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de objetos varios
	 */
	public void addObjetosvarios() {

		generarRootJson("lava_bucket","Objetos Varios","Obten todos los objetos varios","objetosvarios",direcJsonVarios.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncVarios.getAbsolutePath());
		for (int i = 0; i < Names.objetosvarios.length; i++) {
			generarJsonTxt(Names.objetosvarios[i], direcJsonVarios.getAbsolutePath(),"objetosvarios");
			generarFunction(Names.objetosvarios[i], direcFuncVarios.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.objetosvarios[i], "objetosvarios");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de alimentacion
	 */
	public void addAlimentacion() {

		generarRootJson("apple","Alimentacion","Obten todos los item de alimentacion","alimentacion",direcJsonAlimentacion.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncAlimentacion.getAbsolutePath());
		for (int i = 0; i < Names.alimentacion.length; i++) {
			generarJsonTxt(Names.alimentacion[i], direcJsonAlimentacion.getAbsolutePath(),"alimentacion");
			generarFunction(Names.alimentacion[i], direcFuncAlimentacion.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.alimentacion[i], "alimentacion");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de herramienta
	 */
	public void addHerramientas() {

		generarRootJson("iron_axe","Herramientas","Obten todos los item de herramientas","herramientas",direcJsonHerramientas.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncHerramientas.getAbsolutePath());
		for (int i = 0; i < Names.herramientas.length; i++) {
			generarJsonTxt(Names.herramientas[i], direcJsonHerramientas.getAbsolutePath(),"herramientas");
			generarFunction(Names.herramientas[i], direcFuncHerramientas.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.herramientas[i], "herramientas");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de combate
	 */
	public void addCombate() {

		generarRootJson("golden_sword","Combate","Obten todos los item de combate","combate",direcJsonCombate.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncCombate.getAbsolutePath());
		for (int i = 0; i < Names.combate.length; i++) {
			generarJsonTxt(Names.combate[i], direcJsonCombate.getAbsolutePath(),"combate");
			generarFunction(Names.combate[i], direcFuncCombate.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.combate[i], "combate");
		}

	}
	

	/**
	 * Procedimiento para procesar los item de pociones
	 */
	public void addPociones() {		
	//	generarRootJson("potion{Potion:water}","Pociones","Obten todas las pociones","pociones",direcJsonPociones.getAbsolutePath(),"dead_tube_coral_block");
	//	generarRootJson("potion","Pociones","Obten todas las pociones","pociones",direcJsonPociones.getAbsolutePath(),"dead_tube_coral_block");
		generarRootJson("glass_bottle","Pociones","Obten todas las pociones","pociones",direcJsonPociones.getAbsolutePath(),"dead_tube_coral_block");

		generarRootFunction(direcFuncPociones.getAbsolutePath());
		for (int i = 0; i < Names.pociones.length; i++) {
			generarJsonTxt(Names.pociones[i], direcJsonPociones.getAbsolutePath(),"pociones");
			generarFunction(Names.pociones[i], direcFuncPociones.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.pociones[i], "pociones");
		}

	}

	/**
	 * Procedimiento para procesar los libros encantados
	 */
	public void addLibrosEncantados() {

		generarRootJson("enchanted_book","Libros Encantados","Obten todos los libros encantados","librosencantados",direcJsonLibrosEncantados.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncLibrosEncantados.getAbsolutePath());
		for (int i = 0; i < Names.librosEncantados.length; i++) {
			generarJsonTxtLibrosEncantados(Names.librosEncantados[i], direcJsonLibrosEncantados.getAbsolutePath(),"librosencantados");
			generarFunctionLibrosEncantados(Names.librosEncantados[i], direcFuncLibrosEncantados.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.librosEncantados[i], "librosencantados");
		}

	}
	
	/**
	 * Procedimiento para procesar los libros pocimas
	 */
	public void addPocimas() {

		generarRootJson("potion","Pocimas","Obten todas las potimas","pocimas",direcJsonPocimas.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncPocimas.getAbsolutePath());
		for (int i = 0; i < Names.pocimas.length; i++) {
			generarJsonTxtPocimas(Names.pocimas[i], direcJsonPocimas.getAbsolutePath(),"pocimas");
			generarFunction(Names.pocimas[i], direcFuncPocimas.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.pocimas[i], "pocimas");
		}

	}
	
	/**
	 * Procedimiento para procesar los libros flechas
	 */
	public void addFlechas() {

		generarRootJson("tipped_arrow","Flechas Encantadas","Obten todas las flechas encantadas","flechasencantadas",direcJsonFlechasEncantadas.getAbsolutePath(),"dead_tube_coral_block");
		generarRootFunction(direcFuncFlechasEncantadas.getAbsolutePath());
		for (int i = 0; i < Names.flechasencantadas.length; i++) {
			generarJsonTxt(Names.flechasencantadas[i], direcJsonFlechasEncantadas.getAbsolutePath(),"flechasencantadas");
			generarFunction(Names.flechasencantadas[i], direcFuncFlechasEncantadas.getAbsolutePath());
			sobreescribirFunctionGrlobal(Names.flechasencantadas[i], "flechasencantadas");
		}

	}
		
	/**
	 * Procedimiento para generar el fichero json raiz
	 *
	 * @param icono item icono para la pantalla de logros
	 * @param titulo titulo para la pantalla de logros
	 * @param descripcion para la pantalla de logros
	 * @param padre directorio padre del fichero
	 * @param directorio direccion del directorio
	 * @param nameBackground nombre del item para el fondo de la pantalla de logros
	 */
	public void generarRootJson(String icono,String titulo,String descripcion,String padre,String directorio,String nameBackground) {
		ManejadorFichero mFich = new ManejadorFichero();
		String contenido = "{\r\n" + "    \"display\": {\r\n" + "        \"icon\": {\r\n"
				+ "            \"item\": \"minecraft:"
				+ icono
				+ "\"\r\n" + "        },\r\n"
				+ "        \"title\": {\"translate\":\""
				+ titulo
				+ "\"},\r\n"
				+ "        \"description\": {\"translate\":\""
				+ descripcion
				+ "\"},\r\n"
				+ "        \"background\": \"minecraft:textures/block/"
				+ nameBackground
				+ ".png\",\r\n"
				+ "        \"show_toast\": false,\r\n" + "        \"announce_to_chat\": false\r\n" + "    },\r\n"
				+ "	\"rewards\": {\r\n" + "		\"function\": \"function:"
						+ padre
						+ "/root\"\r\n" + "    },		\r\n"
				+ "       \"criteria\": {\r\n" + "        \"item\": {\r\n"
				+ "            \"trigger\": \"minecraft:inventory_changed\",\r\n" + "            \"conditions\": {\r\n"
				+ "            }\r\n" + "        }\r\n" + "    }\r\n" + "}";

	mFich.guardarFichero(contenido, directorio + File.separator + "root.json");
	}

	/**
	 * Procedimiento para generar el fichero mcfunction raiz
	 */
	public void generarRootFunction(String directorio) {
		ManejadorFichero mFich = new ManejadorFichero();
		String contenido = "";

		if(directorio.contains("construccion")) {
			contenido="tellraw @s {\"color\":\"red\",\"bold\":\"true\",\"text\":\"Los logros por obtener todos los item del juego esta activado.\"}\r\n" + 
					"";
		}
		contenido+="scoreboard players add @s Advancements 1";
		mFich.guardarFichero(contenido, directorio + File.separator + "root.mcfunction");
	}

	/**
	 * Procedimiento para generar todos los directorios
	 */
	public void generarDirectorios() {

		directorioGeneral = new File(rutaOutDataPack + File.separator + nameDataPack);

		if (directorioGeneral.exists()) {
			directorioGeneral.delete();
		}

		directorioGeneral.mkdirs();

		directorioData = new File(directorioGeneral.getAbsolutePath() + File.separator + nameData);
		directorioData.mkdirs();
		generarPackMcMeta(directorioGeneral.getAbsolutePath() + File.separator + namePackMcMeta);

		directorioHojasFunction = new File(directorioData + File.separator + "function");
		directorioHojasFunctions = new File(directorioHojasFunction + File.separator + "functions");
		directorioHojasFunction.mkdirs();
		directorioHojasFunctions.mkdirs();
		functionGrlobal(directorioHojasFunctions + File.separator + "update_score" + ".mcfunction");

		direcFuncConstruccion = new File(directorioHojasFunctions + File.separator + "construccion");
		direcFuncConstruccion.mkdirs();
		direcFuncDecoracion = new File(directorioHojasFunctions + File.separator + "decoracion");
		direcFuncDecoracion.mkdirs();
		direcFuncRedstone = new File(directorioHojasFunctions + File.separator + "redstone");
		direcFuncRedstone.mkdirs();
		direcFuncTransporte = new File(directorioHojasFunctions + File.separator + "transporte");
		direcFuncTransporte.mkdirs();
		direcFuncVarios = new File(directorioHojasFunctions + File.separator + "objetosvarios");
		direcFuncVarios.mkdirs();
		direcFuncAlimentacion = new File(directorioHojasFunctions + File.separator + "alimentacion");
		direcFuncAlimentacion.mkdirs();
		direcFuncHerramientas = new File(directorioHojasFunctions + File.separator + "herramientas");
		direcFuncHerramientas.mkdirs();
		direcFuncCombate = new File(directorioHojasFunctions + File.separator + "combate");
		direcFuncCombate.mkdirs();
		direcFuncPociones = new File(directorioHojasFunctions + File.separator + "pociones");
		direcFuncPociones.mkdirs();
		direcFuncLibrosEncantados = new File(directorioHojasFunctions + File.separator + "librosencantados");
		direcFuncLibrosEncantados.mkdirs();
		direcFuncPocimas = new File(directorioHojasFunctions + File.separator + "pocimas");
		direcFuncPocimas.mkdirs();		
		direcFuncFlechasEncantadas = new File(directorioHojasFunctions + File.separator + "flechasencantadas");
		direcFuncFlechasEncantadas.mkdirs();

		directorioHojasJson = new File(directorioData + File.separator + "fullitem");
		directorioHojasJson.mkdirs();

		directorioAdvancements = new File(directorioHojasJson + File.separator + "advancements");
		directorioAdvancements.mkdirs();

		direcJsonConstruccion = new File(directorioAdvancements + File.separator + "construccion");
		direcJsonConstruccion.mkdirs();
		direcJsonDecoracion = new File(directorioAdvancements + File.separator + "decoracion");
		direcJsonDecoracion.mkdirs();
		direcJsonRedstone = new File(directorioAdvancements + File.separator + "redstone");
		direcJsonRedstone.mkdirs();
		direcJsonTransporte = new File(directorioAdvancements + File.separator + "transporte");
		direcJsonTransporte.mkdirs();
		direcJsonVarios = new File(directorioAdvancements + File.separator + "objetosvarios");
		direcJsonVarios.mkdirs();
		direcJsonAlimentacion = new File(directorioAdvancements + File.separator + "alimentacion");
		direcJsonAlimentacion.mkdirs();
		direcJsonHerramientas = new File(directorioAdvancements + File.separator + "herramientas");
		direcJsonHerramientas.mkdirs();
		direcJsonCombate = new File(directorioAdvancements + File.separator + "combate");
		direcJsonCombate.mkdirs();
		direcJsonPociones = new File(directorioAdvancements + File.separator + "pociones");
		direcJsonPociones.mkdirs();
		direcJsonLibrosEncantados = new File(directorioAdvancements + File.separator + "librosencantados");
		direcJsonLibrosEncantados.mkdirs();
		direcJsonPocimas = new File(directorioAdvancements + File.separator + "pocimas");
		direcJsonPocimas.mkdirs();
		direcJsonFlechasEncantadas = new File(directorioAdvancements + File.separator + "flechasencantadas");
		direcJsonFlechasEncantadas.mkdirs();

	}

	/**
	 * Procedimiento para crear los fichero json de cada item
	 * @param nameItem string del nombre del item
	 * @param ruta del directorio donde sera creado
	 * @param namePadre nombre del directorio padre
	 */
	public void generarJsonTxt(String nameItem, String ruta,String namePadre) {

		
		String nameItemFirsMayuscula = nameItem.substring(0, 1).toUpperCase() + nameItem.substring(1).replaceAll("_", " ");
		String txt = "{\r\n" + "  \"display\": {\r\n" + "    \"description\": {\r\n" + "      \"text\": \"Has obtenido "
				+ nameItemFirsMayuscula
				+ ".\",\r\n" + "      \"color\": \"yellow\"\r\n" + "    },\r\n" + "    \"title\": {\r\n"
				+ "      \"text\": \" " +
				nameItemFirsMayuscula
				+ " \",\r\n" + "      \"color\": \"white\"\r\n" + "    },\r\n"
				+ "    \"icon\": {\r\n" + "      \"item\": \"minecraft:" + nameItem + "\"\r\n" + "    },\r\n"
				+ "      \"frame\": \"goal\",\r\n" + "      \"show_toast\": true,\r\n"
				+ "      \"announce_to_chat\": true,\r\n" + "      \"hidden\": false\r\n" + "  },\r\n"
				+ "  \"criteria\": {\r\n" + "    \"stone\": {\r\n"
				+ "      \"trigger\": \"minecraft:inventory_changed\",\r\n" + "      \"conditions\": {\r\n"
				+ "        \"items\": [\r\n" + "          {\r\n" + "            \"" + "item\": \"minecraft:" + nameItem
				+ "\"\r\n" + "          }\r\n" + "        ]\r\n" + "      }\r\n" + "    }\r\n" + "  },\r\n"
				+ "  \"rewards\": {\r\n" + "    \"function\": \"function:"
						+ namePadre
						+ "/" + nameItem + "\"\r\n"
				+ "  },\r\n" + "  \"parent\": \"fullitem:"
						+ namePadre
						+ "/root\"\r\n" + "}";

	
	ManejadorFichero mFich = new ManejadorFichero();
	mFich.guardarFichero(txt, ruta + File.separator + nameItem.replaceAll("[^a-zA-Z]+","") + ".json");

	}

	/**
	 * Procedimiento para crear los ficheros mcfunction de cada item
	 * @param nameItem
	 * @param ruta
	 */
	public void generarFunction(String nameItem, String ruta) {
		String nameItemFirsMayuscula = nameItem.substring(0, 1).toUpperCase() + nameItem.substring(1).replaceAll("_", " ");

		String txt = "#tellraw @s {\"color\":\"yellow\",\"text\":\"¡Conseguiste " + nameItemFirsMayuscula + "!\"}\r\n"
				+ "scoreboard players add @s Advancements 1";
				
		ManejadorFichero mFich = new ManejadorFichero();
		mFich.guardarFichero(txt,ruta + File.separator + nameItem.replaceAll("[^a-zA-Z]+","") + ".mcfunction");
	}

	/**
	 * Procedimiento para sobreescribir el fichero enlace de los ficheros mcfunction
	 * @param nameItem nombre del item a incluir en el fichero general de mcfunction
	 * @param nameDirectorio donde se encuentra el fichero general de mcfunction
	 */
	public void sobreescribirFunctionGrlobal(String nameItem, String nameDirectorio) {
		String txt = "execute as @a[advancements={fullitem:" + nameDirectorio + "/" + nameItem
				+ "=true}] run scoreboard players add @s Advancements 1\r\n";

		File file = new File(directorioHojasFunctions + File.separator + "update_score" + ".mcfunction");

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(txt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Procemiento para crear el fichero descriptivo del datapack
	 *  @param ruta donde se situa el fichero
	 */
	public void generarPackMcMeta(String ruta) {
		ManejadorFichero mFich = new ManejadorFichero();
		String contenido = "{\r\n" + "  \"pack\": {\r\n" + "    \"pack_format\": 4,\r\n" + "    \"description\": \""
				+ nameDescripcion + "\"\r\n" + "  }\r\n" + "}";

		mFich.guardarFichero(contenido, ruta);

	}

	/**
	 * Procedimiento para crear el fichero enlace de los ficheros mcfunction
	 * @param nameItem nombre del item a incluir en el fichero general de mcfunction
	 * @param nameDirectorio donde se encuentra el fichero general de mcfunction
	 */
	public void functionGrlobal(String ruta) {
		String txt = "";

		File file = new File(ruta);

		if (!file.exists()) {
			txt = "# Iniciar score\r\n" + "scoreboard players set @s Advancements 0\r\n" + "\r\n"
					+ "# Listado de avances\n";
		}
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(txt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Procedimiento para crear los fichero fucntion.mc de los libros encantados
	 * @param nameItem nombre del libro 
	 * @param ruta
	 */
	public void generarFunctionLibrosEncantados(String nameItem, String ruta) {
		String nameItemFirsMayuscula = nameItem.substring(0, 1).toUpperCase() + nameItem.substring(1).replaceAll("_", " ");

		String txt = "#tellraw @s {\"color\":\"yellow\",\"text\":\"¡Conseguiste " + nameItemFirsMayuscula + "!\"}\r\n"
				+ "scoreboard players add @s Advancements 1";
				
		ManejadorFichero mFich = new ManejadorFichero();
		mFich.guardarFichero(txt,ruta + File.separator + nameItem + ".mcfunction");
	}

	/**
	 * Procedimiento para crear los fichero json de los libros encantados
	 * @param nameItem libro encantado concatenado con el nivel '-'
	 * @param ruta donde guardar el fichero
	 * @param namePadre root del ficehro json
	 */
	public void generarJsonTxtLibrosEncantados(String nameItem, String ruta,String namePadre) {

		String []libro = nameItem.split("-");
		String name = libro[0];
		String level = libro[1];
		
		String levelRomano = level.replaceAll("1","I").replaceAll("2","II").replaceAll("3","III").replaceAll("4","IV").replaceAll("5","V");
		String nameItemFirsMayuscula = name.substring(0, 1).toUpperCase() + name.substring(1).replaceAll("_", " ");
		
		String txt = "{\r\n" + 
				"  \"display\": {\r\n" + 
				"    \"description\": {\r\n" + 
				"      \"text\": \"Has obtenido "
				+ nameItemFirsMayuscula +" " + levelRomano
				+ "\",\r\n" + 
				"      \"color\": \"yellow\"\r\n" + 
				"    },\r\n" + 
				"    \"title\": {\r\n" + 
				"      \"text\": \" "
				+ nameItemFirsMayuscula +" " + levelRomano
				+ "\",\r\n" + 
				"      \"color\": \"white\"\r\n" + 
				"    },\r\n" + 
				"    \"icon\": {\r\n" + 
				"      \"item\": \"minecraft:enchanted_book\"\r\n" + 
				"    },\r\n" + 
				"      \"frame\": \"goal\",\r\n" + 
				"      \"show_toast\": true,\r\n" + 
				"      \"announce_to_chat\": true,\r\n" + 
				"      \"hidden\": false\r\n" + 
				"  },\r\n" + 
				"  \"criteria\": {\r\n" + 
				"    \"item\": {\r\n" + 
				"      \"trigger\": \"minecraft:inventory_changed\",\r\n" + 
				"      \"conditions\":{\r\n" + 
				"				\"items\": [\r\n" + 
				"					{\r\n" + 
				"						\"enchantments\": [\r\n" + 
				"							{\r\n" + 
				"								\"enchantment\": \"minecraft:"
				+  name 
				+ "\",\r\n" + 
				"								\"levels\":"
				+ level
				+ "\r\n" + 
				"							}\r\n" + 
				"						]\r\n" + 
				"					}\r\n" + 
				"				]\r\n" + 
				"			}\r\n" + 
				"    }\r\n" + 
				"  },\r\n" + 
				"  \"rewards\": {\r\n" + 
				"    \"function\": \"function:librosencantados/"
				+ nameItem
				+ "\"\r\n" + 
				"  },\r\n" + 
				"  \"parent\": \"fullitem:librosencantados/root\"\r\n" + 
				"}";

	
	ManejadorFichero mFich = new ManejadorFichero();
	mFich.guardarFichero(txt, ruta + File.separator + nameItem + ".json");

	}
	
	/**
	 * Procedimiento para crear los fichero json de las pociones
	 * @param nameItem libro encantado concatenado con el nivel '-'
	 * @param ruta donde guardar el fichero
	 * @param namePadre root del ficehro json
	 */
	public void generarJsonTxtPocimas(String nameItem, String ruta,String namePadre) {	
		
		String nameItemFirsMayuscula = nameItem.substring(0, 1).toUpperCase() + nameItem.substring(1).replaceAll("_", " ");
		
		String txt = "{\r\n" + 
				"  \"display\": {\r\n" + 
				"    \"description\": {\r\n" + 
				"      \"text\": \"Has elaborado "
				+ nameItemFirsMayuscula 
				+ ".\",\r\n" + 
				"      \"color\": \"yellow\"\r\n" + 
				"    },\r\n" + 
				"    \"title\": {\r\n" + 
				"      \"text\": \" "
				+ nameItemFirsMayuscula 
				+ " \",\r\n" + 
				"      \"color\": \"white\"\r\n" + 
				"    },\r\n" + 
				"    \"icon\": {\r\n" + 
				"      \"item\": \"minecraft:"
				+ "brewing_stand"
				+ "\"\r\n" + 
				"    },\r\n" + 
				"      \"frame\": \"goal\",\r\n" + 
				"      \"show_toast\": true,\r\n" + 
				"      \"announce_to_chat\": true,\r\n" + 
				"      \"hidden\": false\r\n" + 
				"  },\r\n" + 
				"    \"criteria\": {\r\n" + 
				"        \"potion\": {\r\n" + 
				"            \"trigger\": \"minecraft:brewed_potion\",\r\n" + 
				"            \"conditions\": {\r\n" + 
				"                \"potion\": \"minecraft:"
				+ nameItem
				+ "\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    },\r\n" + 
				"  \"rewards\": {\r\n" + 
				"    \"function\": \"function:pocimas/potion\"\r\n" + 
				"  },\r\n" + 
				"  \"parent\": \"fullitem:pocimas/root\"\r\n" + 
				"}";

	
	ManejadorFichero mFich = new ManejadorFichero();
	mFich.guardarFichero(txt, ruta + File.separator + nameItem + ".json");

	}

}
