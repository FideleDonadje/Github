
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna){
    //Find the index of the start codon "ATG" and the index of the first stop codon ""
    
    //Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1){
        return "";
    }
    int stopIndex = dna.indexOf("TAA",startIndex + 3);
    
    if ((stopIndex-startIndex)%3 == 0){
        return dna.substring(startIndex,stopIndex+3);
    }
    return "";
  }
  public String mystery(String dna) {
  int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}
 public void mysteryTest(){
    String dna = "AATGCTAGGGTAATATGGT";
    System.out.println(dna);
    System.out.println(mystery(dna));
    }
  
  public void testFindSimpleGene(){
    //               *  6   *
    String dna = "AATGCTAGGGTAATATGGT";
    System.out.println("DNA Strand is " + dna);
    String gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    //            *   12       *
    dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
    System.out.println("DNA Strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    //          *     10   *
    dna = "TTAATGGGGAATTTTGTAAGT";
    System.out.println("DNA Strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
  }
}
