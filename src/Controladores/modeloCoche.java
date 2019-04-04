package Controladores;

public class modeloCoche {
	
	//Metodo para obtener modelos
	public static String[] getModelos(String pais) {
		String [] modelo = new String[5];
		if (pais.equalsIgnoreCase("Seat")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Ibiza";
			modelo[2] = "Leon";
		}
		if (pais.equalsIgnoreCase("Opel")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Corsa";
			modelo[2] = "Astra";
		}
		if (pais.equalsIgnoreCase("Ford")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Fiesta";
			modelo[2] = "Focus";
		}
		if (pais.equalsIgnoreCase("Renault")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Clio";
			modelo[2] = "Megane";
		}
		if (pais.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Captiva";
			modelo[2] = "Camaro";
		}
		return modelo;
		
	}
	public static String[] getModelosAdd(String pais) {
		String [] modelo = new String[5];
		if (pais.equalsIgnoreCase("Seat")) {
			modelo[0] = "Ibiza";
			modelo[1] = "Leon";
		}
		if (pais.equalsIgnoreCase("Opel")) {
			modelo[0] = "Corsa";
			modelo[1] = "Astra";
		}
		if (pais.equalsIgnoreCase("Ford")) {
			modelo[0] = "Fiesta";
			modelo[1] = "Focus";
		}
		if (pais.equalsIgnoreCase("Renault")) {
			modelo[0] = "Clio";
			modelo[1] = "Megane";
		}
		if (pais.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Captiva";
			modelo[1] = "Camaro";
		}
		return modelo;
		
	}
}
