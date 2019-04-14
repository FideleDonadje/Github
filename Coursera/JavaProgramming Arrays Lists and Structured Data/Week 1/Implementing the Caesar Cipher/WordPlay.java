
/**
 * Write a description of WordPlay here.
 *  program to transform words from a file into another form, such as replacing
vowels with an asterix.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        /*
         *  isVowel has one parameter named ch​. 
         *  This method returns true if
         *  ch​is a vowel (one of a, e, i, o, or u or the uppercase versions) 
         *  and false otherwise
         */
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u')
        {
            return true;
        }
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' ||ch == 'U')
        {
            return true;
        }
        return false;
    }
    
    public String replaceVowel(String phrase, char ch){
        /*
         * replaceVowels​has two parameters, a String named phrase​
         * and a character named ch​. This method should return a String 
         * that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch
         */
        StringBuilder sb = new StringBuilder(phrase);
        for (int i =0; i < sb.length() ; i++ ){
            if (isVowel(sb.charAt(i))){
                sb.setCharAt(i,ch);
            }
        }
        return sb.toString();
    }
    
    public String emphasize(String phrase, char ch){
    /*
     *  emphasize​with two parameters, a String named phrase​and a
     *  character named ch​returns a String that is the string phrase but with
     *  the character ch​(upper­ or lowercase) replaced by
     *  ○ ‘*’if it is in an odd number location in the string (e.g. the first character has an
     *  odd number location but an even index, it is at index 0)
     *  ○ ‘+’if it is in an even number location in the string (e.g. the second character has
     *  an even number location but an odd index, it is at index 1)
     */
        StringBuilder sb = new StringBuilder(phrase);
        for (int i =0; i < sb.length() ; i++ ){
            if (sb.charAt(i) == ch){  
                if ( ((i+1)%2) == 0){
                    sb.setCharAt(i,'+');
                }
                else {
                    sb.setCharAt(i,'*');  
                }
                
            }
        } 
        return sb.toString();
    }
    
    public void TestisVowel(){
        if (isVowel('P')) System.out.println("P is a vowel !");
        if (isVowel('a')) System.out.println("a is a vowel !");
        if (isVowel('E')) System.out.println("E is a vowel !");
        if (isVowel('T')) System.out.println("T is a vowel !");
    }
    public void TestreplaceVowel(){
        String phrase = "Hello World";
        System.out.println(phrase + " " + replaceVowel(phrase,'*'));
        phrase = "Welcome Back";
        System.out.println(phrase + " " + replaceVowel(phrase,'*'));
        phrase = "MERCI BEAUCOUP";
        System.out.println(phrase + " " + replaceVowel(phrase,'*'));
    
    }
    
    public void Testemphasize(){
        String phrase = "dna ctgaaactga";
        System.out.println(phrase + " " + emphasize(phrase,'a'));
        phrase = "“Mary Bella Abracadabra";
        System.out.println(phrase + " " + emphasize(phrase,'a'));
        
    }
    
}
