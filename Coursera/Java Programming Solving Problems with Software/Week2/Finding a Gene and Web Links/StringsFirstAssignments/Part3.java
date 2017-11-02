
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurences (String stringa, String stringb){
        int occurences=0;
        int index =0;
        int temp = stringb.indexOf(stringa);
        while (temp != -1){
            occurences = occurences + 1;
            index = temp + stringa.length(); 
            if(occurences >=2){
                return true;
            }
            temp = stringb.indexOf(stringa);
        }
        return false;
    }
    
    public String lastPart(String stringa, String stringb){
       int temp = stringb.indexOf(stringa);
       if (temp != -1){
           String output = stringb.substring(temp+ stringa.length(), stringb.length());
           return output ;
        }
        else{
          return stringb;  
        }
    }
    
    public void lastPart(){
    
    String stringa = "an";
    String stringb = "banana";
    System.out.println(lastPart(stringa, stringb));
    
    stringa = "by";
    stringb = "A story by Abby Long";
    System.out.println(lastPart(stringa, stringb));
    
    stringa = "zoo";
    stringb = "forest";
    System.out.println(lastPart(stringa, stringb));
    
    stringa = "atg";
    stringb = "ctgtatgta";
    System.out.println(lastPart(stringa, stringb));
    
    stringa = "tta";
    stringb = "ctgtatgta";
    System.out.println(lastPart(stringa, stringb));
   
    }
    
    public void testOccurences(){
    String stringa = "a";
    String stringb = "banana";
    System.out.println(twoOccurences(stringa, stringb));
    
    stringa = "by";
    stringb = "A story by Abby Long";
    System.out.println(twoOccurences(stringa, stringb));
    
    stringa = "atg";
    stringb = "ctgtatgta";
    System.out.println(twoOccurences(stringa, stringb));
    
    stringa = "tta";
    stringb = "ctgtatgta";
    System.out.println(twoOccurences(stringa, stringb));
    
    }
}
