package it.univpm.OOP2020.TwitterTrends.Util;

/**
 * @author Andrea Camilloni
 *
 */

public class Distance {

	private double latA, lonA, latB, lonB;
	

	/**
	 * 
	 */
	public Distance() {
		super();
	}

	/**
	 * @param latA
	 * @param lonA
	 * @param latB
	 * @param lonB
	 */
	public Distance(double latA, double lonA, double latB, double lonB) {
		super();
		this.latA = latA;
		this.lonA = lonA;
		this.latB = latB;
		this.lonB = lonB;
	}

	public double distanza(String a0, String a1, String b0, String b1) {

		latA = stringToDouble(a0);
		lonA = stringToDouble(a1);
		latB = stringToDouble(b0);
		lonB = stringToDouble(b1);

		/* Definisce le costanti e le variabili */
		double R = 6371;
		double pigreco = 3.1415927;
		double lat_alfa, lat_beta;
		double lon_alfa, lon_beta;
		double fi;
		double p, d;
		/* Converte i gradi in radianti */
		lat_alfa = pigreco * latA / 180;
		lat_beta = pigreco * latB / 180;
		lon_alfa = pigreco * lonA / 180;
		lon_beta = pigreco * lonB / 180;
		/* Calcola l'angolo compreso fi */
		fi = Math.abs(lon_alfa - lon_beta);
		/* Calcola il terzo lato del triangolo sferico */
		p = Math.acos(Math.sin(lat_beta) * Math.sin(lat_alfa) + Math.cos(lat_beta) * Math.cos(lat_alfa) * Math.cos(fi));
		/*
		 * Calcola la distanza sulla superficie terrestre R = ~6371 km
		 */
		d = p * R;
		return (d);
	}

	private double stringToDouble(String a) {
		return Double.parseDouble(a);
	}
}
