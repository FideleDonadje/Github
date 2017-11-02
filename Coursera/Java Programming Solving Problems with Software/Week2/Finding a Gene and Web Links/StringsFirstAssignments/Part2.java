
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){
    //Find the index of the start codon "ATG" and the index of the first stop codon ""
    
    //Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string
    if (Character.isLowerCase(dna.charAt(0))){
           stopCodon = stopCodon.toLowerCase();
           startCodon = startCodon.toLowerCase();
        }
    int startIndex = dna.indexOf(startCodon);
    if (startIndex == -1){
        return "";
    }
    int stopIndex = dna.indexOf(stopCodon,startIndex + 3);
    
    if ((stopIndex-startIndex)%3 == 0){
        String gene = dna.substring(startIndex,stopIndex+3);
        return gene;
    }
    return "";
  }
  
  public void testFindSimpleGene(){
    String startCodon = "ATG";
    String stopCodon = "TAA";  
    //               *  6   *
    String dna = "AATGCTAGGGTAATATGGT";
    System.out.println("DNA Strand is " + dna);
    String gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);
    //            *   12       *
    dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
    System.out.println("DNA Strand is " + dna);
    gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);
    //          *     10   *
    dna = "TTAATGGGGAATTTTGTAAGT";
    System.out.println("DNA Strand is " + dna);
    gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);
    //            *   12       *
    dna = "atcctatgcttcggctgctctaatatggt";
    System.out.println("DNA Strand is " + dna);
    gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);
  }
}
