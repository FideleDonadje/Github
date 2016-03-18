Fidele Donadje
fd96
SE311

A1: Implementation of KWIC in Java using the Pipe and Filter Architecture


OVERVIEW
-------------------------------------------------------------------------------------
We implemented KWIC using the Pipe and Filter Architecture.The Pipe and Filter Architecture uses pipes to transfer data to filters. In this Achitecture style,

we have a set of input streams and output streams using pipes.

A pipe read from a filter, store the data/ make it available to the next filter. It was a little bit complex to try to implement it in java.

We have 3 pipes 

InputCircularPipe: get the outpout from the input filter and set it as an input for the CircularShiftFilter. The data here is a array of string containing the lines of the files and also the list of stop words

CircularAlphabetizerPipe: get the output from the CircularShift and set it as the input for the Alphabetizer. The data here is a hashtable containing the keys and the phrases

AlphabetizerOutputPipe: get the output of the Alphabetizer and set it as the input for the Output. The data here is the list of keys, the hashtable and the stop words list 

We have 4 filters

InputFilter: reads the files,parses the data and write the results in the InputCircularPipe: 

CircularShiftFilter: reads the InputCircularPipe, performs the circular shift and write the results in the CircularAlphabetizerPipe.

AphabetizingOutputFilter: reads the CircularAlphabetizerPipe, perform the alphabetization and writes in the AlphabetizerOutputPipe.

Output: read AlphabetizerOutputPipe and display the results 





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

In addition, some changes were made to those classes to better implement the Pipe and Filter Architecture.

	We stored all the data in the objects(each object has different inputs and outputs they get from the pipes and do all the processes in objects instead of calling each method in the Kwic object. We have a method called filter()
in each object that takes the input, processes it and store the result in an output attribute.

	The filters have the same structure, They have inputs which are the data they need to transfer and several methods. They have some setters and getters, the read method and the write method.
In our case, we didn't use the pipes to write in the filters. We have the filters read the pipes instead 