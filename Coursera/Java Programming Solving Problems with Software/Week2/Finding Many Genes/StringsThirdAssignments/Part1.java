
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
       int indexStopCodon = dna.indexOf(stopCodon,startIndex+3);
       while (indexStopCodon !=-1)
       {
           if ((indexStopCodon-startIndex)%3 ==0)
           {
               return indexStopCodon;
            }
            else{
                indexStopCodon = dna.indexOf(stopCodon,indexStopCodon+1);
            }
            
        }
      return dna.length(); 
    }
    
    public String findGene(String dna, int position){
        int indexStart = dna.indexOf("ATG",position);
        if (indexStart ==-1){
            return "";
        }
        int indexTAA = findStopCodon(dna,indexStart,"TAA");
        int indexTAG = findStopCodon(dna,indexStart,"TAG");
        int indexTGA = findStopCodon(dna,indexStart,"TGA");
        int temp = Math.min(indexTAA,indexTAG);
        int indexStop = Math.min(temp,indexTGA);
        if (indexStop == dna.length()){
            return "";
        }
        String gene = dna.substring(indexStart, indexStop+3);
        return gene;
    
    }
    public void printAllGenes(String dna){
        int count = 0;
        int count60 = 0;
        int startIndex = 0;
        while (true){
            
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty())
            {
                break;
            }
            if (gene.length() >60)
            {
                count60 = count60 + 1;
            }
            count = count +1;
            System.out.println(gene);
            startIndex = dna.indexOf(gene,startIndex) + gene.length();
        }
        System.out.println("Number of genes : " + count);
        System.out.println("Number of genes > 60 : " + count60);
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource allGenes = new StorageResource();
        int startIndex = 0;
        int count = 0;
        while (true){
            
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty())
            {
                break;
            }
            allGenes.add(gene);
            count = count +1 ;
            System.out.println(gene);
            startIndex = dna.indexOf(gene,startIndex)+ gene.length();
        }
        System.out.println("Number of dna : " + count);
        return allGenes;
    }
    
    public float cgRatio(String dna){
        int cCount=0;
        int gCount=0;
        int cIndex= dna.indexOf('C',0);
        int gIndex= dna.indexOf('G',0);
        while (cIndex!=-1){
            cCount+=1;
            cIndex = dna.indexOf('C',cIndex+1);
            
        }
        while (gIndex!=-1){
            gCount+=1;
            gIndex = dna.indexOf('G',gIndex+1);
            
        }
        float ratio = (float)(gCount+cCount)/(float)dna.length();
        return ratio;
    
    }
    
    public void processGenes(StorageResource sr){
        int lengthCount=0;
        int cgRatio35 = 0;
        int temp =0;
        String longestString = "";
        for(String s : sr.data()){
        
        if (s.length() > 9){
            lengthCount+=1;
            System.out.println(s);
        }
        if (cgRatio(s) > 0.35){
            cgRatio35 +=1;
            System.out.println(s);
        }
        
        if (s.length() > temp){
            longestString =s;
            temp = s.length();
        }
        
    }
    System.out.println("The longest string is : " + longestString);
    System.out.println("The number of ratio35 : " + cgRatio35);
    System.out.println("The length is : " + temp);
    
    }
    
    public void testProcessGenesFile(){
    FileResource fr = new FileResource("GRch38dnapart.fa");
    String dna = fr.asString().toUpperCase();
    int index = 0;
    int count = 0;
    int indexCtg = dna.indexOf("CTG");
    while (indexCtg != -1){
        count = count +1;
        index = indexCtg +3;
        indexCtg = dna.indexOf("CTG",index);
        }
    System.out.println("Count is : " + count );
    
      
    System.out.println("The number of CTG is " + count);
    
    
        
    //printAllGenes(dna);
    //StorageResource sr = getAllGenes(dna);
    //processGenes(sr);
    //dna = "ATGCCGGCTTAA";
    
    //dna = "ATGCCGCGTTAA";
    //printAllGenes(dna);
    
    }
    
    
    public void testCGratio(){
        // ratio = 5/11 = 0.45
        String dna = "ATGCCGGTTAA";
        System.out.println("The ratio of the dna " + dna + " is "+cgRatio(dna));
        // ratio = 0/10 =0
        dna = "ATTTAATTAA";
        System.out.println("The ratio of the dna " + dna + " is "+cgRatio(dna));
        // ratio = 5/10 = 0.5
        dna = "ATGCCGGTTAA";
        System.out.println("The ratio of the dna " + dna + " is "+cgRatio(dna));
        // ratio = 4/9 = 0.44
        dna = "ATGCCATAG";
        System.out.println("The ratio of the dna " + dna + " is "+cgRatio(dna));
        
        
    }
    
    public void testStopCodon(){
        //            01234567890123456789012345
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex!=9) System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex!=21) System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if (dex!=26) System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if (dex!=26) System.out.println("error on 26");
        System.out.println("Test Finished");
    
    }
}
