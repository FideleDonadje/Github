
/**
 * program to figure out the most common word length of words from a file. To
solve this problem you will need to keep track of how many words from a file are of each
possible length. You should group all words of length 30 or more together, and you should not
count basic punctuation that are the first or last characters of a group of characters.
 *
 * @author (Omiodjo F Donadje)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class WordLengths
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WordLengths
     */
    public WordLengths()
    {
        // initialise instance variables
        x = 0;
    }
    
    public void countWordlengths(FileResource resource, int []counts)
    {
        
        for(String words : resource.words()){
            int wordLength=0;
            for (int k=0; k<words.length();k++){
                if(Character.isLetter(words.charAt(k))){
                    wordLength+=1;
                }
            }
            if (wordLength >30 ){
                counts[31]+=1;
                }
            else{
                counts[wordLength] +=1;   
                }
            }
    }
    public int indexOfMax(int[] values){
        int maxIndex=0;
        for(int k=0; k<values.length;k++){
            if(values[k]>values[maxIndex]){
               maxIndex=k;
            }
        }
        return maxIndex;
    }
    
    public void testCountWordLengths()
    {
        FileResource fr = new FileResource();
        int[] counts = new int[32];
        countWordlengths(fr,counts);
        for (int k=0; k<counts.length; k++){
            if(counts[k]>0){
            System.out.println("There are " + counts[k]+ " words of length " + k);
           }
        }
        
        System.out.println("There most common word length is  " + indexOfMax(counts));
    }
}

