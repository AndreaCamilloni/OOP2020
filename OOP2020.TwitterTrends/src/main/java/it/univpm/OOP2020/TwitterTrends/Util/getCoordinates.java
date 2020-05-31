package it.univpm.OOP2020.TwitterTrends.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.univpm.OOP2020.TwitterTrends.exception.IncorrectFileLocation;
import it.univpm.OOP2020.TwitterTrends.model.Coordinata;

public class getCoordinates {
	private String sourceFile;
	private List<Coordinata> listCoordinate;
	public getCoordinates(String file)
	{
		this.sourceFile=file;
	}
	public getCoordinates(String lat, String lon)
	{
		
	}
	
	public List<Coordinata> getCoordinatesFromFile() throws IOException, IncorrectFileLocation {
		BufferedReader reader = null;
		String line = null;
		Scanner scanner = null;
		listCoordinate = new ArrayList<>();
		int index = 0;
		try {
			reader = new BufferedReader(new FileReader(new File(sourceFile)));

			while ((line = reader.readLine()) != null) {
				if(line.split(",").length!=2) throw new IncorrectFileLocation();
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
