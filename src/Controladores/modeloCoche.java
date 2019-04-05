package Controladores;

public class modeloCoche {
	
	//Metodo para obtener modelos
	/**
	 * METODO PARA OBTENER LOS MODELOS SEGUN LA MARCA INDICADA
	 * @param marca
	 * @return
	 */
	public static String[] getModelos(String marca) {
		String [] modelo = new String[5];
		if (marca.equalsIgnoreCase("Seat")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Ibiza";
			modelo[2] = "Leon";
		}
		if (marca.equalsIgnoreCase("Opel")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Corsa";
			modelo[2] = "Astra";
		}
		if (marca.equalsIgnoreCase("Ford")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Fiesta";
			modelo[2] = "Focus";
		}
		if (marca.equalsIgnoreCase("Renault")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Clio";
			modelo[2] = "Megane";
		}
		if (marca.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Captiva";
			modelo[2] = "Camaro";
		}
		return modelo;
		
	}
	/**
	 * METODO PARA RECOGER LOS MODELOS PARA AÑADIR
	 * @param marca
	 * @return
	 */
	public static String[] getModelosAdd(String marca) {
		String [] modelo = new String[5];
		if (marca.equalsIgnoreCase("Seat")) {
			modelo[0] = "Ibiza";
			modelo[1] = "Leon";
		}
		if (marca.equalsIgnoreCase("Opel")) {
			modelo[0] = "Corsa";
			modelo[1] = "Astra";
		}
		if (marca.equalsIgnoreCase("Ford")) {
			modelo[0] = "Fiesta";
			modelo[1] = "Focus";
		}
		if (marca.equalsIgnoreCase("Renault")) {
			modelo[0] = "Clio";
			modelo[1] = "Megane";
		}
		if (marca.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Captiva";
			modelo[1] = "Camaro";
		}
		return modelo;
		
	}
}
