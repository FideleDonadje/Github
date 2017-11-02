
/**
 * Write a description of WhichCountriesExport here.
 * This a program that extract diffent information about countries and their exports 
 * in a CSV file
 * @author (Omiodjo F Donadje) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    /*
     * returns a string of information about the country or 
     * returns “NOT FOUND” if there is no information about the country.
     * The format of the string returned is the country,
     * followed by “: “, followed by a list of the countries’ exports,
     * followed by “: “, followed by the countries export value.
     */
    public String countryInfo(CSVParser parser, String country){
        String result ="";
        for (CSVRecord record : parser){
            String countries = record.get("Country");
            if (countries.contains(country)){
                result = ( country + " : "+ record.get("Exports")+ " : " +record.get("Value (dollars)"));
                return result;
            }
            
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
    /*
     * This method prints the names of all the countries 
     * that have both exportItem1 and exportItem2 as export items.
     */
        for (CSVRecord record : parser){
        String exports = record.get("Exports");
        if (exports.contains(exportItem1) && exports.contains(exportItem2)){
           System.out.println(record.get("Country")); 
        }
    }
    } 
    
    public int numberOfExporters(CSVParser parser, String exportItem1){
        //This method returns the number of countries that export exportItem.
        int count = 0;
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1)){
                count = count +1;
            }
        }
        return count ;
    }
    
    public void bigExporters(CSVParser parser, String amount){
    /*
     * This method prints the names of countries and their Value amount for all countries 
     * whose Value (dollars) string is longer than the amount string.
     */
        for (CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                System.out.println(record.get("Country") + " "+ value);
            }
        }
    }
    
    public void tester(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    //System.out.println(numberOfExporters(parser, "cocoa"));
    //System.out.println(countryInfo(parser,"Nauru"));
    //listExportersTwoProducts(parser,"cotton","flowers");
    //System.out.println(numberOfExporters(parser, "gold"));
    bigExporters(parser, "$999,999,999,999");
    }
    

}
