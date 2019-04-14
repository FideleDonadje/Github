
/**
 * Write a description of CaesarCipher here.
 * You will start with the Caesar Cipher algorithm you learned about in the videos, and you will
 * make some enhancements to it, so that it works with all letters (both uppercase and lowercase)
 * and to make it a little bit harder to decrypt.
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    
    public String encrypt(String phrase, int key){
        StringBuilder encrypted = new StringBuilder(phrase);
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetUpper = alphabetUpperCase.substring(key) + alphabetUpperCase.substring(0,key);
        String shiftedAlphabetLower = alphabetLowerCase.substring(key) + alphabetLowerCase.substring(0,key);
        
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            
            if (Character.isLowerCase(currChar)){
                int index = alphabetLowerCase.indexOf(currChar);
                if (index !=-1){
                    char newChar = shiftedAlphabetLower.charAt(index);
                    encrypted.setCharAt(i,newChar);
                    
                }
            }
            
                if (Character.isUpperCase(currChar)){
                int index = alphabetUpperCase.indexOf(currChar);
                if (index !=-1){
                    char newChar = shiftedAlphabetUpper.charAt(index);
                    encrypted.setCharAt(i,newChar);
                    
                }
            }
                    
        }
        
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
    /*
     *  returns a String that has been encrypted using the following algorithm.
     *  Parameter key1​is used to encrypt every other character with 
     *  the Caesar Cipher algorithm, starting with the first character
     *  and key2​is used to encrypt every other character, starting with 
     *  the second character.
     */
    StringBuilder encrypted = new StringBuilder(input);
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetUpperKey1 = alphabetUpperCase.substring(key1) + alphabetUpperCase.substring(0,key1);
        String shiftedAlphabetLowerKey1 = alphabetLowerCase.substring(key1) + alphabetLowerCase.substring(0,key1);
        String shiftedAlphabetUpperKey2 = alphabetUpperCase.substring(key2) + alphabetUpperCase.substring(0,key2);
        String shiftedAlphabetLowerKey2 = alphabetLowerCase.substring(key2) + alphabetLowerCase.substring(0,key2);
        
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            if ( i%2 == 0){
                encryptChar(encrypted, shiftedAlphabetUpperKey1,shiftedAlphabetLowerKey1,currChar,i);
        }
        
            if (i%2 != 0){
                encryptChar(encrypted, shiftedAlphabetUpperKey2,shiftedAlphabetLowerKey2,currChar,i);
        }   
        }
        return encrypted.toString();
    }
    
    public void encryptChar(StringBuilder encrypted, String shiftedAlphabetUpper, String shiftedAlphabetLower, char currChar, int i){
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (Character.isLowerCase(currChar)){
                int index = alphabetLowerCase.indexOf(currChar);
                if (index !=-1){
                    char newChar = shiftedAlphabetLower.charAt(index);
                    encrypted.setCharAt(i,newChar);
                    
                }
            }
            
        if (Character.isUpperCase(currChar)){
                int index = alphabetUpperCase.indexOf(currChar);
                if (index !=-1){
                    char newChar = shiftedAlphabetUpper.charAt(index);
                    encrypted.setCharAt(i,newChar);
                    
                }
            }   
}
    
    public void testCeasar(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String mess = encrypt("FIRST LEGION ATTACK EAST FLANK !", 23);
        System.out.println(mess);
        mess = encrypt("First Legion Attack East Flank !", 23);
        System.out.println(mess);
        mess = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println(mess);
        mess = encryptTwoKeys("First Legion", 23,17);
        System.out.println(mess);
        mess = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21);
        System.out.println(mess);
        
    }
    

}
