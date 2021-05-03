package week4;

import acm.program.ConsoleProgram;
import java.io.*;
import java.util.*;

public class Histograms extends ConsoleProgram{ 
	
public static void main(String[] args) {

    int[] data = new int[200];
    @SuppressWarnings("resource")
	Scanner sc = new Scanner("MidtermScores.txt");

    /*reading filename*/
    String fileName = sc.nextLine();
    int index = 0;

    /*Reading file*/
    File file = new File(fileName);
    Scanner inputFile = null;
	try {
		inputFile = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
        /*Going through each element*/
        while (inputFile.hasNext()) {
            if (inputFile.hasNextInt()) {
                /*Storing numbers read from text into array*/
                data[index] = inputFile.nextInt();
                index++;
            } else {
                inputFile.next();
            }
        }
    } finally {
        /*Closing file*/
        inputFile.close();
    }

    String[] Stars = {" 1-10 |", "11- 20 | ", "21- 30 | ", "31- 40 | ", "41- 50 | ",
        "51- 60 | ", "61- 70 | ", "71- 80 | ", "81- 90 | ", "91-100 | "};

    /*Going through array values*/
    for (int i = 0; i < index; i++) {
        int num = data[i];
        if (num < 11) {
            Stars[0] += "*";
        } else if (num < 21) {
            Stars[1] += "*";
        } else if (num < 31) {
            Stars[2] += "*";
        } else if (num < 41) {
            Stars[3] += "*";
        } else if (num < 51) {
            Stars[4] += "*";
        } else if (num < 61) {
            Stars[5] += "*";
        } else if (num < 71) {
            Stars[6] += "*";
        } else if (num < 81) {
            Stars[7] += "*";
        } else if (num < 91) {
            Stars[8] += "*";
        } else {
            Stars[9] += "*";
        }
    }

    /*Finally printing the results*/
    for (int i = 0; i < 10; i++) {
        System.out.println(Stars[i]);
    }
}
}