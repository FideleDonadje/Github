#ifndef _ANAGRAM_
#define _ANAGRAM_

#define numHashBuckets 1000
//it will be the number of linked list

void constructHashTable(FILE * file); //Construct the hash table

int hash(char * word);

int ascii_sum(char * word);//Return the ascii sum for a word

int hash_base_max(char * path);

void printAnagrams(char * word);//Print anagrams for a word

bool isAnagram(char * input, char * toCheck);//Check if a word is an anagram of the other


struct HashTable table;

void printHashTable(struct HashTable * table);


#define numHashBuckets 1000

//void append(struct LinkNode** head,char * word);


// linked list structure for each word
struct LinkNode
{
  char * word;
  struct LinkNode * next;
};

//definition of the hashtable
struct HashTable
{
  //The scaling done as part of the hash function actually produces numHashBuckets +1
  //possible values so allocate (statically) an array of linked lists that is
  //numHashBuckets +1 in size
  struct LinkNode nodeHeads[numHashBuckets +1];
};
struct HashTable table;
#endif
