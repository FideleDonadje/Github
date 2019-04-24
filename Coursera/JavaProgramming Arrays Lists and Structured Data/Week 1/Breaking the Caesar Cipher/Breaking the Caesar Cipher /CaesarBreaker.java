
/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class CaesarBreaker
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CaesarBreaker
     */
    public CaesarBreaker()
    {
        // initialise instance variables
        x = 0;
    }
    
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }
    
  public int maxIndex(int[] values){
        int maxIndex=0;
        for(int k=0; k<values.length;k++){
            if(values[k]>values[maxIndex]){
               maxIndex=k;
            }
        }
        return maxIndex;
    }
    
    public void decrypt(int key, String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey= maxDex -4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        String message = cc.encrypt(encrypted, 26 - key);
    }
    
    public String halfOfString(String message, int start){
        String halfMessage="";
        for (int k=start; k < message.length(); k=k+2){
            halfMessage = halfMessage + message.charAt(k);
        }
        return halfMessage;
    }
    
    public int getKey(String s){
        int[] lettersFrequencies = countLetters(s);
        int MaxIndex = maxIndex(lettersFrequencies);
        return MaxIndex;
    }
    
    public void testDecryption(){
    
    }
    
}


