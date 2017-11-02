
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser){
    /*
     * returns the CSVRecord with the hottest temperature in the file and 
     * thus all the information about the hottest temperature, 
     * such as the hour of the hottest temperature.
     */
        
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser){
            if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("Temperature"));
                double largestTemp = Double.parseDouble(largestSoFar.get("Temperature"));
                if (currentTemp > largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
    /*
     * returns the CSVRecord with the coldest temperature in the file 
     * and thus all the information about the coldest temperature, 
     * such as the hour of the coldest temperature.
     */
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow : parser){
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp == -9999){
                    lowestSoFar = lowestSoFar;
                }
                if (currentTemp < lowestTemp){
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }
    
    public File fileWithColdestTemperature(){
    /*
     * return a string that is the name of the file 
     * from selected files that has the coldest temperature. 
     */    
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        File fileLowest = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if (lowestSoFar == null){
                lowestSoFar = current;
                fileLowest = f;
            }
            else {
                double currentTemp = Double.parseDouble(current.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp == -9999){
                    lowestSoFar = lowestSoFar;
                }
                if (currentTemp < lowestTemp){
                    lowestSoFar = current;
                    fileLowest = f;
                }
            }
        }
        return fileLowest;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
    /*
     * returns the CSVRecord that has the lowest humidity.
     * If there is a tie, then return the first such record that was found.
     */
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow : parser){
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            }
            else {
                if (currentRow.get("Humidity")!= "N/A"){
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
                if (currentTemp < lowestTemp){
                    lowestSoFar = currentRow;
                }
            }
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles (){
    /*
     *  returns a CSVRecord that has the lowest humidity over all the files.
     *  If there is a tie, then return the first such record that was found
     */
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        File fileLowest = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            if (lowestSoFar == null){
                lowestSoFar = lowestHumidityInFile(fr.getCSVParser());
            }
            else {
                CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
                double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHum = Double.parseDouble(lowestSoFar.get("Humidity"));
                if (currentHum < lowestHum){
                    lowestSoFar = currentRow;
                }
        }
      }
      return lowestSoFar;
    }
    
    public double averageTemperatureinFile(CSVParser parser){
    /*
     * returns a double that represents the average temperature in the file
     */
        double sumTemp = 0;
        int count = 0 ;
        for (CSVRecord currentRow : parser){
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            sumTemp = sumTemp + currentTemp;
            count = count +1;
        }
        return (sumTemp/count);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
    /*
     * returns a double that represents the average temperature of only those temperatures 
     * when the humidity was greater than or equal to value.
     */
        double sumTemp = 0;
        int count = 0 ;
        for (CSVRecord currentRow : parser){
            
            if (Double.parseDouble(currentRow.get("Humidity")) > value){
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                sumTemp = sumTemp + currentTemp;
                count = count +1;
            }
            
        }
        return (sumTemp/count);
       }

    
    public void testLowestHumidiyInFile(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      CSVRecord csv = lowestHumidityInFile(parser);  
      System.out.println("Lowest Humidity Was : " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testFileWithColdestTemperature(){
        
        File fileLowest = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + fileLowest.getName());
        FileResource fr = new FileResource(fileLowest);
        String filename = fileLowest.getName();
        String date = filename.substring(filename.indexOf("weather-"));
        CSVRecord lowestRecord = coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest Temperature is " + lowestRecord.get("TemperatureF") );
        System.out.println("All the Temperatures on the coldest day were : ");
        for (CSVRecord record : fr.getCSVParser()){
            System.out.print(record.get("DateUTC") + " " );
            System.out.print(record.get("TimeEST") + " " );
            System.out.println(record.get("TemperatureF") + " " );
            
        }
        
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowestInManyFile = lowestHumidityInManyFiles();
        System.out.print("The lowest humidity was " + lowestInManyFile.get("Humidity") );
        System.out.println(" at : " + lowestInManyFile.get("DateUTC"));
    }
    
    public void TestAverageTemperatureinFile(){
        FileResource fr = new FileResource();
        System.out.println("The Average Temperature in the file is : " + averageTemperatureinFile(fr.getCSVParser()));
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double averageHighHum = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        if (averageHighHum >0){
       System.out.println("The Average Temperature in the file is : " + averageHighHum);
    }
    else {
         System.out.println("No temperatures with that humidity");
    }
    }
}
