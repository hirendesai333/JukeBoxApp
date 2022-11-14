package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.Song;

public class JukeBoxApp {

	// songs list file path
	public static String filePath = "/Users/hirendesai/eclipse-workspace/JukeBoxApp/SongListMore.txt";

	// songs list array to store and perform sort function on itself.
	public static ArrayList<Song> songsList = new ArrayList<>();

	public static void main(String[] args) {

		try {
			// scanner class to read data from the file
			Scanner scanner = new Scanner(new File(filePath));

			// first checking next line has data or not if yes then add it to the songs list
			while (scanner.hasNextLine()) {
				addSong(scanner.nextLine());
			}

			// close the scanner to prevent from causes
			scanner.close();

			// printing songs list using Song Object
			System.out.println("=========== Songs list before sorted: =============");
			for (Song s : songsList) {
				System.out.println("Title: "+s.getTitle());
				System.out.println("Artist: "+s.getArtist());
				System.out.println("Rating: "+s.getRating());
				System.out.println("BPM: "+s.getBpm()+"\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	static void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songsList.add(nextSong);
	}
}