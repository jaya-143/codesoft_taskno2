package codeSoft_numbergame;
import java.util.*;
import java.io.*;

public class  Wordcounter{
	 public static void main(String[] args) {
		 
// 1.Prompt the user to enter a text or provide a file to count the words
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE TEXT OR WORD TO COUNT:");

// 2.Read the input text or file and store it in a string
        String input_words = scanner.nextLine();

// 9.Input validation to handle the input text         
        if (input_words.isEmpty()) {
            System.out.println("Input is empty. Please provide some word or text");
            return;
        }
        if (new File(input_words).isFile()) {
            try {
                Scanner fileScanner = new Scanner(new File(input_words));
                StringBuilder file_Content = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    file_Content.append(fileScanner.nextLine()).append(" ");
                }
                input_words = file_Content.toString();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please provide a valid path.");
                return;
            }
        }

// 3.Split the string into an array of words using space or punctuation as delimiters
        String[] words;
        words = input_words.split("\\s+|\\p{Punct}");
        
// 4.Initialize a counter variable to keep track of the number of words
        int word_Count = 0;
        
        Set<String> stop_Words = new HashSet<>(Arrays.asList("a", "an", "at" , "and", "but", "in", "or", "on","the"));
        
        Map<String, Integer> word_Frequency = new HashMap<>();
        
// 5.Iterate through the array of words and increment the counter for each word encountered
        for (String word : words) {
        	
	         if (!word.isEmpty()) {
	              word_Count++;
	              if (!stop_Words.contains(word.toLowerCase())) {
	                  word_Frequency.put(word, word_Frequency.getOrDefault(word, 0) + 1);
	                }
	              }
	          }
        
// 6. display the total count of words to the user        
        System.out.println("Total words: " + word_Count);
        
// 7.Ignoring common words or stop words        
       System.out.println("Unique words: " + word_Frequency.size());
       System.out.println("Word frequency:");
       for (Map.Entry<String, Integer> entry : word_Frequency.entrySet()) {
           System.out.println(entry.getKey() + ": " + entry.getValue());
       }         
	}   
}      
 
