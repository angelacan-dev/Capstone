package week4;

import java.io.*;
import acm.program.ConsoleProgram;


public class WordCount extends ConsoleProgram {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	public void run()
    {
        File file = new File("lear.txt");
        FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
          
        String line;
          
        // Initializing counters
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int lineCount = 1;
        int whitespaceCount = 0;
          
        // Reading line by line from the 
        // file until a null is returned
        try {
			while((line = reader.readLine()) != null)
			{
			    if(line.equals(""))
			    		break;
			    
			     else {
			    	lineCount++;
			        characterCount += line.length();
			          
			        // \\s+ is the space delimiter in java
			        String[] wordList = line.split("\\s+");
			          
			        countWord += wordList.length;
			        whitespaceCount += countWord -1;
			          
			        // [!?.:]+ is the sentence delimiter in java
			        String[] sentenceList = line.split("[!?.:]+");
			          
			        sentenceCount += sentenceList.length;
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        System.out.println("Total word count = " + countWord);
        System.out.println("Total number of characters = " + characterCount);
        System.out.println("Total number of lines = " + lineCount);
    }
}