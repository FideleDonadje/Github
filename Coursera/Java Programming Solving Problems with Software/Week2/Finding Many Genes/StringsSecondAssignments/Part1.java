
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        while (true){
            int startIndex = 0;
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty())
            {
                break;
            }
            System.out.println(gene);
            startIndex = dna.indexOf(gene,startIndex)+ gene.length();
        }
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
