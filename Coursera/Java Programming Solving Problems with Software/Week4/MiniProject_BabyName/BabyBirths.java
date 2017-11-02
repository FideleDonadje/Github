
/**
 * This is a program that use CSV Parsing to perform several operations to 
 * get several informations about the baby names in the USA
 * 
 * @author (Omiodjo F Donadje) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void printNames(){
        //Print the name, the gender and the number of names given
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
        System.out.print("Name : " + rec.get(0) + " ");
        System.out.print("Gender : " + rec.get(1) + " ");
        System.out.println("Num : " + rec.get(2) + " ");
        }
        
    }
    public void totalBirths(FileResource fr){
        //Print the total number of births by sex in a csv file
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            totalBirths = totalBirths + 1 ;
            if(rec.get(1).equals("M")){
                totalBoys = totalBoys + 1;
            }
            else{
                totalGirls = totalGirls + 1;
            }
            
        }
            System.out.println("total births = " + totalBirths);
            System.out.println("total girls = " + totalGirls);
            System.out.println("total boys = " + totalBoys);
        
    }
    
    public int getRank(int year, String name, String gender){
        //returns the rank of the name in the file for the given gender,
        //where rank 1 is the name with the largest number of births.
         int rankM=1;
         int rankF=1;
         String filename = "yob"+year+".csv";
         FileResource fr = new FileResource(filename);
         for (CSVRecord rec : fr.getCSVParser()){
            if (rec.get(0).equals(name) && rec.get(1).equals(gender)){
                if (gender == "M"){
                    return rankM +1 ;
                }
                else {
                    return rankF + 1;
                }
            }
            if (rec.get(1).equals("M")){
                rankM = rankM + 1;
            }
            if (rec.get(1).equals("F")){
                rankF = rankF + 1;
            }
         }
            return -1;
    }
            
         
    public String getName(int year, int rank, String gender){
        /*
         *  returns the name of the person in the file at this rank, for the given gender, 
         *  where rank 1 is the name with the largest number of births. 
         *  If the rank does not exist in the file, then “NO NAME” is returned.
         */
        String filename = "yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        int rankM = 1;
        int rankF = 1;
        for (CSVRecord rec : fr.getCSVParser()){
            if (rec.get(1).equals("M")){
                rankM = rankM + 1;
            }
            if (rec.get(1).equals("F")) {
                rankF = rankF + 1;
            }
            if ((rank == rankM) || (rank ==rankF)){
                if (rec.get(1).equals(gender)){
                    return rec.get(0);
                }
                
            }
        }
        return "NO NAME";
    }
   
    int yearOfHighestRank(String name, String gender){
        /*
         * returns an integer, the year with the highest rank for the name and gender.
         * If the name and gender are not in any of the selected files, 
         * it should return -1. 
         */
        
        int highestRank = 0;
        int currentRank = 0;
        int year = 0;
        int yearRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            year = Integer.parseInt(f.getName().substring(3,7));
            currentRank = getRank(year,name,gender);
                if (highestRank == 0){
                    highestRank = currentRank;
                    yearRank = year;
                }
                else {
                    if (currentRank < highestRank){
                       highestRank = currentRank ;
                       yearRank = year;
                    }
                }
                    
        }
        if (highestRank == 0){
            return -1;
        }
        else {
            return yearRank;
        }
        
     }
     
    double getAverageRank(String name, String gender){
        /*
         * returns a double representing the average rank of the name and gender over the selected files.
         * It should return -1.0 if the name is not ranked in any of the selected files
         */
        int year = 0;
        int rank = 0;
        double count = 0;
        double sumRank = 0;
        double result = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            year = Integer.parseInt(f.getName().substring(3,7));
            rank = getRank(year,name,gender);
            if (rank != -1.0){
                count = count + 1;
                sumRank = rank + sumRank;
            }
            
        }
        if (sumRank !=0){
            System.out.println("the sum is : " + sumRank);
            System.out.println("the count is : " + count);
            result = sumRank/count;
            return result;
        }
       
            return -1;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        /*
         * returns an integer, the total number of births of those names with the same gender 
         * and same year who are ranked higher than name.
         */
        String filename = "yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser()){
            if (rec.get(1).equals(gender)){
                
                if (rec.get(0).equals(name)){
                    totalBirths = Integer.parseInt(rec.get(2)) + totalBirths;
                    break;
                }
                else {
                    totalBirths = Integer.parseInt(rec.get(2)) + totalBirths;
                }
            }
            
        }
        return totalBirths;
    }
    public void TestGetTotalBirthsRankedHigher(){
        System.out.println("Higher births : " + getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }
    
    public void TestGetAverageRank(){
        System.out.println("Average Rank for Mason Male is  : " + getAverageRank("Mason","M"));
        System.out.println("Average Rank for Jacob Male is : " + getAverageRank("Jacob","M"));
    }
       
    public void TestYearOfHighestRank(){
        int rank = yearOfHighestRank("Genevieve","F");
        System.out.println("The year of highest rank of gen is " + rank);
        rank = yearOfHighestRank("Mich","M");
        System.out.println("The year of highest rank of Mich is " + rank);
    }
   
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int currentRank = getRank(year, name,gender);
        String newName = getName(newYear, currentRank,gender);
        System.out.print(name + " was born in " + year + " would be ");
        System.out.println(newName + " if " + " she was born in " + newYear);
    }
    
    public void TestWhatIsNameInYear(){
        whatIsNameInYear("Susan",1972, 2014, "F");
    }
    
    public void TestGetRank(){
        System.out.println("The rank of Mason in the file is " + 
        getRank(1971,"Frank","M"));
    }
    
    public void TestGetName(){
        System.out.println("The name at rank 2 for a female is " + 
        getName(2014, 0, "F"));
    }
    
    
    public void testPrintNames(){
    printNames();
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

}
