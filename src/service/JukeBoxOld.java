package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dto.Song;

public class JukeBoxOld {

	// songs list file path
	public static String filePath = "/Users/hirendesai/eclipse-workspace/JukeBoxApp/SongList.txt";

	// songs list array to store and perform sort function on itself.
	public static ArrayList<String> songsList = new ArrayList<>();

	public static void main(String[] args) {

		try {
			// scanner class to read data from the file
			Scanner scanner = new Scanner(new File(filePath));

			// first checking next line has data or not if yes then add it to the songs list
			while (scanner.hasNextLine()) {
				songsList.add(scanner.nextLine());
			}

			// printing songs list before sorting
			System.out.println("=========== Songs list before sorted: =============");
			for (String s : songsList) {
				System.out.println(s);
			}

			// close the scanner to prevent from causes
			scanner.close();

			// sorting ArrayList in ascending order
			Collections.sort(songsList);

			// for each loop to print array list after sorting
			System.out.println("\n=========== Songs list After sorted: =============");
			for (String s : songsList) {
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}