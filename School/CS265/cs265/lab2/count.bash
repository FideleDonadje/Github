#!/bin/bash
#count-print the nb of lines,word to stdout
#
#Fidele Donadje
#we store the name od all the file first in a variable
files=$(ls);

#we then display the number of words and lines for each variable
echo "lines words  file"
wc -lw $files
