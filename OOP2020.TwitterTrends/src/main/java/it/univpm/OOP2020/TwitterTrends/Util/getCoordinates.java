package it.univpm.OOP2020.TwitterTrends.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.univpm.OOP2020.TwitterTrends.exception.BadDataInput;
import it.univpm.OOP2020.TwitterTrends.exception.IncorrectFileLocation;
import it.univpm.OOP2020.TwitterTrends.model.Coordinata;

/**
 * This class allows to get a list of coordinates by means of an input file
 * 
 * @author Andrea Camilloni
 *
 */
public class getCoordinates {
	/**
	 * sourceFile describes the file PATH + the file name
	 */
	private String sourceFile;
	/**
	 * list of Coordinates
	 */
	private List<Coordinata> listCoordinate;

	/**
	 * Constructor
	 * 
	 * @param file
	 */
	public getCoordinates(String file) {
		this.sourceFile = file;
	}

	public getCoordinates() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * getPlaceFromeFile(),by means of the input file,create a list of coordinates
	 * with only the PlaceName and with lat,long parameters empty
	 * 
	 * @throws IOException
	 */
	private void getPlaceFromeFile() throws IOException {
		BufferedReader reader = null;
		String line;
		String[] place = null;
		listCoordinate = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(new File(sourceFile)));
			line = reader.readLine();
			place = line.split(",");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String string : place) {
			Coordinata c = new Coordinata();
			c.setPlaceName(string);
			listCoordinate.add(c);
		}

	}
	/**
	 * This method return an array with latitude and longitude of placeName 
	 * @param placeName
	 * @return
	 * @throws BadDataInput
	 */
	public String[] getLatLong(String placeName) throws BadDataInput{
		JSONObject tmp = null;
		JSONArray tmpArray = null;
		///getPlaceFromeFile();
		String data;
		String long_lat[];
		String jsonString = new urlConnection("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/geo/" + placeName).getJSON();

		try {
			tmp = (JSONObject) JSONValue.parseWithException(jsonString);
			tmpArray = (JSONArray) JSONValue.parseWithException(tmp.get("features").toString());
			if (tmpArray.isEmpty())
				throw new BadDataInput("No coordinates found! Try another location");
			tmp = (JSONObject) JSONValue.parseWithException(tmpArray.get(0).toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = tmp.get("center").toString();
		long_lat = data.substring(1, data.length() - 1).split(",");
		if (Double.parseDouble(long_lat[0]) < -180 || Double.parseDouble(long_lat[0]) > 180
				|| Double.parseDouble(long_lat[1]) < -180 || Double.parseDouble(long_lat[1]) > 180)
			throw new BadDataInput("Error in input coordinates from GEO! Try with an other location");

		return long_lat;
		
	}
	
	/**
	 * getCoordinatesRequest() returns a list of Coordinates characterized by
	 * PlaceName and lat,long parameters
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws BadDataInput
	 */
	public List<Coordinata> getCoordinatesRequest() throws MalformedURLException, IOException, BadDataInput {
		getPlaceFromeFile();
		
		for (Coordinata coordinata : listCoordinate) {
			
//			String jsonString = new urlConnection("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/geo/" + coordinata.getPlaceName()).getJSON();
//
//			try {
//				tmp = (JSONObject) JSONValue.parseWithException(jsonString);
//				tmpArray = (JSONArray) JSONValue.parseWithException(tmp.get("features").toString());
//				if (tmpArray.isEmpty())
//					throw new BadDataInput("No coordinates found! Try another location");
//				tmp = (JSONObject) JSONValue.parseWithException(tmpArray.get(0).toString());
//
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			data = tmp.get("center").toString();
//			long_lat = data.substring(1, data.length() - 1).split(",");
//			if (Double.parseDouble(long_lat[0]) < -180 || Double.parseDouble(long_lat[0]) > 180
//					|| Double.parseDouble(long_lat[1]) < -180 || Double.parseDouble(long_lat[1]) > 180)
//				throw new BadDataInput("Error in input coordinates from GEO! Try with an other location");
			String[] tmp=getLatLong(coordinata.getPlaceName());
			coordinata.setLon(Double.parseDouble(tmp[0]));
			coordinata.setLat(Double.parseDouble(tmp[1]));

		}
		return listCoordinate;

	}

	
	
	//Questo metodo veniva utilizzato inizialmente per leggere latitudine e longitudine da file di testo
	/**
	 * This method is not implemented.
	 * 
	 * getCoordinatesFromFile() allows to return list of coordinates entered by the
	 * user in the sourceFile
	 * 
	 * @return
	 * @throws IOException
	 * @throws IncorrectFileLocation
	 */
	public List<Coordinata> getCoordinatesFromFile() throws IOException, IncorrectFileLocation {
		BufferedReader reader = null;
		String line = null;
		Scanner scanner = null;
		listCoordinate = new ArrayList<>();
		int index = 0;
		try {
			reader = new BufferedReader(new FileReader(new File(sourceFile))); // il file deve contenere dati lat e long

			while ((line = reader.readLine()) != null) {
				if (line.split(",").length != 2)
					throw new IncorrectFileLocation();
				Coordinata coord = new Coordinata();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");

				while (scanner.hasNext()) {
					String data = scanner.next();
					if (Double.valueOf(data) < -180 || Double.valueOf(data) > 180)
						throw new IncorrectFileLocation(data);
					if (index == 0)
						coord.setLat(Double.valueOf(data));
					else if (index == 1)
						coord.setLon(Double.valueOf(data));
					else
						System.out.println("Too many input.Invalid data:" + data);
					index++;
				}
				index = 0;
				listCoordinate.add(coord);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File location.txt non trovato!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return listCoordinate;
	}

}
