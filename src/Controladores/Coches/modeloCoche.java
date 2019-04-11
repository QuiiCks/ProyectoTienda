package Controladores.Coches;

public class modeloCoche {

	// Metodo para obtener modelos
	/**
	 * METODO PARA OBTENER LOS MODELOS SEGUN LA MARCA INDICADA
	 * 
	 * @param marca
	 * @return
	 */
	public static String[] getModelos(String marca) {
		String[] modelo = new String[15];
		if (marca.equalsIgnoreCase("Seat")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Ibiza";
			modelo[2] = "Leon";
			modelo[3] = "Alhambra";
			modelo[4] = "Altea";
			modelo[5] = "Toledo";
			modelo[6] = "Arona";
		}
		if (marca.equalsIgnoreCase("Opel")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Corsa";
			modelo[2] = "Astra";
			modelo[3] = "Zafira";
			modelo[4] = "Insignia";
			modelo[5] = "Combo";
			modelo[6] = "Cabrio";
		}
		if (marca.equalsIgnoreCase("Ford")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Fiesta";
			modelo[2] = "Focus";
			modelo[1] = "C-Max";
			modelo[2] = "Mondeo";
			modelo[1] = "Tourneo Connect";
			modelo[2] = "S-Max";
		}
		if (marca.equalsIgnoreCase("Renault")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Clio";
			modelo[2] = "Megane";
			modelo[3] = "Laguna";
			modelo[4] = "Captur";
			modelo[5] = "Talisman";
			modelo[6] = "Kadjar";
		}
		if (marca.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Captiva";
			modelo[2] = "Camaro";
			modelo[3] = "Aveo";
			modelo[4] = "Orlando";
		}
		if (marca.equalsIgnoreCase("Audi")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "A5";
			modelo[2] = "A6";
			modelo[3] = "A7";
			modelo[4] = "S7";
		}
		if (marca.equalsIgnoreCase("BMW")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "320D";
			modelo[2] = "X4";
			modelo[3] = "X5";
			modelo[4] = "X6";
		}

		if (marca.equalsIgnoreCase("Kia")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Picanto";
			modelo[2] = "Rio";
			modelo[3] = "Sportage";
			modelo[4] = "Optima";
			modelo[5] = "Nitro";
			modelo[6] = "Venga";
		}
		if (marca.equalsIgnoreCase("Lexus")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "GS";
			modelo[2] = "RX";
			modelo[3] = "CT";
			modelo[4] = "IS";
			modelo[5] = "NX";
			modelo[6] = "RC";
		}
		if (marca.equalsIgnoreCase("Mazda")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "CX-5";
			modelo[2] = "CX-3";
			modelo[3] = "CX-9";
			modelo[4] = "MX-5";
			modelo[5] = "Mazda6";
			modelo[6] = "Mazda5";
		}
		if (marca.equalsIgnoreCase("Mercedes")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Clase V";
			modelo[2] = "Clase C";
			modelo[3] = "Clase E";
			modelo[4] = "Clase S";
			modelo[5] = "Clase A";
			modelo[6] = "Clase B";
		}
		if (marca.equalsIgnoreCase("Peugeot")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "308";
			modelo[2] = "807";
			modelo[3] = "508";
			modelo[4] = "208";
			modelo[5] = "108";
			modelo[6] = "207";
		}
		if (marca.equalsIgnoreCase("Toyota")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Avensis";
			modelo[2] = "Yaris";
			modelo[3] = "Verso";
			modelo[4] = "Auris";
			modelo[5] = "Pryus";
			modelo[6] = "CH-R";
		}
		if (marca.equalsIgnoreCase("Volkswagen")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "Polo";
			modelo[2] = "Golf";
			modelo[3] = "Touran";
			modelo[4] = "Tiguan";
			modelo[5] = "Passat";
			modelo[6] = "California";

		}
		if (marca.equalsIgnoreCase("Volvo")) {
			modelo[0] = "Cualquiera";
			modelo[1] = "V70";
			modelo[2] = "S80";
			modelo[3] = "XC70";
			modelo[4] = "V60";
			modelo[5] = "S60";
			modelo[6] = "XC90";
		}
		return modelo;

	}

	/**
	 * METODO PARA RECOGER LOS MODELOS PARA AÑADIR
	 * 
	 * @param marca
	 * @return
	 */
	public static String[] getModelosAdd(String marca) {
		String[] modelo = new String[15];
		if (marca.equalsIgnoreCase("Seat")) {
			modelo[0] = "Ibiza";
			modelo[1] = "Leon";
			modelo[2] = "Alhambra";
			modelo[3] = "Altea";
			modelo[4] = "Toledo";
			modelo[5] = "Arona";
		}
		if (marca.equalsIgnoreCase("Opel")) {
			modelo[0] = "Corsa";
			modelo[1] = "Astra";
			modelo[2] = "Zafira";
			modelo[3] = "Insignia";
			modelo[4] = "Combo";
			modelo[5] = "Cabrio";
		}
		if (marca.equalsIgnoreCase("Ford")) {
			modelo[0] = "Fiesta";
			modelo[1] = "Focus";
			modelo[2] = "C-Max";
			modelo[3] = "Mondeo";
			modelo[4] = "Tourneo Connect";
			modelo[5] = "S-Max";
		}
		if (marca.equalsIgnoreCase("Renault")) {
			modelo[0] = "Clio";
			modelo[1] = "Megane";
			modelo[2] = "Laguna";
			modelo[3] = "Captur";
			modelo[4] = "Talisman";
			modelo[5] = "Kadjar";
		}
		if (marca.equalsIgnoreCase("Chevrolet")) {
			modelo[0] = "Captiva";
			modelo[1] = "Camaro";
			modelo[2] = "Aveo";
			modelo[3] = "Orlando";
		}
		if (marca.equalsIgnoreCase("Audi")) {
			modelo[0] = "A5";
			modelo[1] = "A6";
			modelo[2] = "A7";
			modelo[3] = "S7";
		}
		if (marca.equalsIgnoreCase("BMW")) {
			modelo[0] = "320D";
			modelo[1] = "X4";
			modelo[2] = "X5";
			modelo[3] = "X6";
		}

		if (marca.equalsIgnoreCase("Kia")) {
			modelo[0] = "Picanto";
			modelo[1] = "Rio";
			modelo[2] = "Sportage";
			modelo[3] = "Optima";
			modelo[4] = "Nitro";
			modelo[5] = "Venga";
		}
		if (marca.equalsIgnoreCase("Lexus")) {
			modelo[0] = "GS";
			modelo[1] = "RX";
			modelo[2] = "CT";
			modelo[3] = "IS";
			modelo[4] = "NX";
			modelo[5] = "RC";
		}
		if (marca.equalsIgnoreCase("Mazda")) {
			modelo[0] = "CX-5";
			modelo[1] = "CX-3";
			modelo[2] = "CX-9";
			modelo[3] = "MX-5";
			modelo[4] = "Mazda6";
			modelo[5] = "Mazda5";
		}
		if (marca.equalsIgnoreCase("Mercedes")) {
			modelo[0] = "Clase V";
			modelo[1] = "Clase C";
			modelo[2] = "Clase E";
			modelo[3] = "Clase S";
			modelo[4] = "Clase A";
			modelo[5] = "Clase B";
		}
		if (marca.equalsIgnoreCase("Peugeot")) {
			modelo[0] = "308";
			modelo[1] = "807";
			modelo[2] = "508";
			modelo[3] = "208";
			modelo[4] = "108";
			modelo[5] = "207";
		}
		if (marca.equalsIgnoreCase("Toyota")) {
			modelo[0] = "Avensis";
			modelo[1] = "Yaris";
			modelo[2] = "Verso";
			modelo[3] = "Auris";
			modelo[4] = "Pryus";
			modelo[5] = "CH-R";
		}
		if (marca.equalsIgnoreCase("Volkswagen")) {
			modelo[0] = "Polo";
			modelo[1] = "Golf";
			modelo[2] = "Touran";
			modelo[3] = "Tiguan";
			modelo[4] = "Passat";
			modelo[5] = "California";

		}
		if (marca.equalsIgnoreCase("Volvo")) {
			modelo[0] = "V70";
			modelo[1] = "S80";
			modelo[2] = "XC70";
			modelo[3] = "V60";
			modelo[4] = "S60";
			modelo[5] = "XC90";
		}
		return modelo;

	}
}
