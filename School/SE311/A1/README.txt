Fidele Donadje
fd96
SE311

A1: Implementation of KWIC in Java using Oriented Object Architecture


OVERVIEW
-------------------------------------------------------------------------------------
We implemented KWIC using the Object Oriented Architecture. We used 4 eperate objects:

Alphabetizer : This class is responsible of getting the keys, sorting them using vectors

CircularShift: This class contains all the meethods used to perform the circular shift on the data

Input: This class handles the input of data. Getting the file name, reading the file and parsing the data 

Output: This class handles the display of the data. hashtables, vectors , file input.

Kwic: This class is the main driver and execute the program.

IMPLEMENTATION
-------------------------------------------------------------------------------------

INPUT

	We read the file and store the data in a stringBuffer. We parse this buffer using the split() function 
and the correct delimiters to get each line.Those line are stored in an array of string. The same thing 
is done for the kwic file and the stopwords file.

CIRCULARSHIFT

	The circular shift takes each line and proccesses it. It is done by getting first the list of words in each line,
iterate through them, circular shift each of them and store the result in a hashtable. The keys are the word in context
and the values are the string associated with them.
	To circular shift, we locate the word first. We then create a new string containing the substring from the word to the 
last word(addRight) and the substring from the first word to the current word.

ALPHABETIZING

	Alphabetizing gets all the keys in a vector and sort them using sort. We then remove the stopwords if needed to get the 
final vector of kwic values.
	
OUTPUT
	We have several methods to display the data at different states with different objects: hashtables, vectors , stringbuffer,
array of string 

KWIC
	It just contains all the previous objects and use them to produce the kwic values 