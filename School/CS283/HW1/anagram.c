#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "anagram.h"


int hashBaseMaxValue = 1;
int main(int argc, char** argv)
{
  //Check for input file
  if(argv[1] == NULL)
  {
     printf("Please provide an input dictionary file.\n");
     return -1;
  }


  hashBaseMaxValue = hash_base_max(argv[1]);

  //Try to open the file read only
  FILE* dict = fopen(argv[1], "r");

  //Check to see if the file opened
  if(dict == NULL)
  {
      printf("Failed to open the file : %s\n",argv[1]);
      return -1;
  }

  //We construct the table from the dictionary
  constructHashTable(dict);

  //printHashTable(&table);

  //Check that a word is provided
  if(argv[2] == NULL)
  {
    printf("We cannot find anagrams if you do not give us a word\n");
    return -1;
  }
  else
  {
    //We print the anagrams of the word
    printAnagrams(argv[2]);
  }

  fclose(dict);
}

//FUNCTIONS DEFINITIONS

void printAnagrams(char * word)
{
  //We hash the world
  int hashvalue = hash(word);

  //We find the hash corresponding to the
  struct LinkNode * iterNode = &(table.nodeHeads[hashvalue]); //Start iterator at the head node's address
  while(iterNode !=NULL)
  {
    if( isAnagram(word,iterNode->word) )
    {
      //Print word
      printf("%s\n",iterNode->word);
    }
    //Go to next item in linked list
    iterNode = iterNode->next;
  }
}

bool isAnagram(char * word0, char * word)
{
  //Make a copy of word for modifing, word1
  size_t stringSize = (strlen(word)+1) * sizeof(char);
  char * word1 = malloc( stringSize );
  if(word1 !=NULL)
  {
    strncpy(word1,word,stringSize);
  }

  //The 2 words must have the same length and the same ascii sum
  int word0len = strlen(word0);
  int word1len = strlen(word1);
  if(word0len != word1len)
  {
    return false;
  }
  //And ascii sum
  if(ascii_sum(word0) != ascii_sum(word1))
  {
    return false;
  }

  //Final check
  //Loop through word0
  int i,j;
  bool charFound;
  for(i=0; i< word0len; i++)
  {
    //Find char word0[i] in word1
    //Loop through word1 until word0[i] is found
    charFound = false;
    for(j=0; j < word1len; j++)
    {
      if(word0[i] ==word1[j])
      {
	word1[j] = ' '; //space to mark
	charFound = true;
	break;
      }
    }
    if(charFound == false)
    {
    //Made it through a loop without finding a matching char
    return false;
    }
  }
  return true;
}

void constructHashTable(FILE * file)
{
  // Read each line of the file
  char word[128];
  while(fgets(word, sizeof(word), file) != NULL)
  {
      int hashvalue = hash(word);//Hash changes word to all lowercase and removes newlines
      //Build the hash table
      struct LinkNode * node = &(table.nodeHeads[hashvalue]);
      append(&node,word);
  }
  return;
}

void printHashTable(struct HashTable * table)
{
  //Debug function
  int i;
  for(i=0; i <= numHashBuckets +1;i++)
  {
    printf("\nHASH VALUE: %d= ",i);
    struct LinkNode * iterNode = &(table->nodeHeads[i]);
    while(iterNode != NULL)
    {
      printf("%s\n",iterNode->word);
      iterNode = iterNode->next;
    }
  }
}


void append(struct LinkNode** head,char * word)
{

  if( (*head)->word ==NULL)
  {
    //Allocate space for word in container
    size_t stringSize = (strlen(word)+1) * sizeof(char);
    (*head)->word = malloc( stringSize );
    if((*head)->word != NULL)
    {
      //Copy from word passed in into new allocated space
      strncpy((*head)->word,word,stringSize);

      //set the next item to null
      (*head)->next = NULL;
    }
    else
    {
      printf("Malloc Error.");
      return;
    }
  }
  //Nodes exists, add new node to beginning of list
  else
  {
    //Need new LinkNode (container)
    struct LinkNode * newNode = malloc(sizeof(struct LinkNode));
    if(newNode != NULL)
    {
      //Allocate space for new word in new container
      size_t stringSize = (strlen(word)+1) * sizeof(char);
      newNode->word = malloc( stringSize );
      if(newNode->word != NULL)
      {
	//Copy from word passed in into new allocated space
	strncpy(newNode->word,word,stringSize);

	//Append new node between head and first node
	newNode->next = (*head)->next;
	(*head)->next = newNode;
      }
      else
      {
	printf("Malloc Error.");
	return;
      }
    }
    else
    {
      printf("Malloc Error.");
      return;
    }
  }
}

int hash(char * word)
{
  //Change input to lower case
  int i;
  int len = strlen(word);
  //Don't modify last char - null char
  for(i=0; i < len; i++)
  {
    //To get rid of newline change it to null term
    if(word[i]=='\n')
    {
      word[i]='\0';
    }
    else
        //We lower case all the letter to make our life easier
    {
      word[i] = tolower(word[i]);
    }
  }

  return (hash_base(word)/(float)hashBaseMaxValue)*numHashBuckets;
}

int ascii_sum(char * word)
{
  //Simple function to return ascii sum
  int i = 0;
  int sum = 0;
  //Loop to end of word
  while(word[i] !='\0' && word[i] !='\n' && word[i] != EOF)
  {
    sum+=word[i];
    i++;
  }
  return sum;
}

int hash_base_max(char * path)
{
  //Find the maximum hash value in the file
  FILE* file = fopen(path, "r");
  if(file == NULL)
  {
      printf("Failed to open: %s\n",path);
      return 1; //Not zero for division later
  }

  //We read each line of the file
  char word[128];
  int max = 1;
  while(fgets(word, sizeof(word), file) != NULL)
  {
      int value = hash_base(word);
      if(value > max)
      {
	max = value;
      }
  }
  fclose(file);
  return max;
}

//Hashing function that use
int hash_base(char * word)
{
  return ascii_sum(word) * strlen(word);
}

