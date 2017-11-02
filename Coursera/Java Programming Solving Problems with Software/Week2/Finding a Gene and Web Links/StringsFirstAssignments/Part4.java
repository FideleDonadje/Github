
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    public void findYoutube(String url){
        URLResource ur = new URLResource (url);
        for (String s : ur.lines()){
            int pos = s.toLowerCase().indexOf("youtube.com");
            if (pos != -1){
                int startIndex = s.lastIndexOf("\"",pos);
                int stopIndex = s.indexOf("\"",pos+1);
                System.out.println(s.substring(startIndex+1,stopIndex));

            }
                    }
    }
    
    public void test(){
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        findYoutube(url);
    }

}

