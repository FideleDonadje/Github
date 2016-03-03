//Fidele Donadje
//12722483
//CS283-002 Lab2
//
//Finally, write a program that, using malloc and realloc,
//creates an array of initial size n.
//Write add(), remove() and get() functions for your array.
//When adding beyond the end of the array,
//reallocate space such that the array contains one more element.
//Time your program for adding 100000 elements (or more).
//Then modify the program such that it increases in size by a factor of 2 times the previous size.
//Time it again.  What do you observe?

//I tried to time the program with the clock function but I got weird number
//My guess is if we add n element to the array, the execution time will be linear
#include<stdio.h>
#include<stdlib.h>
#include <time.h>

void add(int x);
void remove_element(int index);
int get(int index);

// Global variables were used to limit the number of
//arguments to pass to the add(),remove_element and get
//There is a conflict with the name remove so we are using
//remove_element
int * array;
int sizeArray;
int numElem;
int intsToAdd = 200000;
int factor = 2;
int growConst = 0;
double cpu_time_used;
clock_t start, end;

int main(int argc, char** argv)
{
  //Initialize
  sizeArray = 10;
  numElem = 0;
  array = malloc(sizeArray*sizeof(int));

  int i=0;
  start = clock();
  for(i=0; i<intsToAdd; i++)
  {
    add(rand()%100);
  }
  end = clock();
  cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
  printf("The time is %d \n",cpu_time_used);

  //2times the size of the previous array
  start = clock();
  for(i=0; i<(2*intsToAdd); i++)
  {
    add(rand()%100);
  }
  end = clock();
  cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
  printf("The time is %d \n",cpu_time_used);
  return 0;
}

void add(int x)
{

  if(numElem >= sizeArray)
  {
    //Resize the array

    int newSize = factor*sizeArray + growConst;
    array = realloc(array,newSize*sizeof(int));
    sizeArray = newSize;
  }

  //Add at the end
  array[numElem] = x;
  numElem++;

  return;
}

void remove_element(int index)
{
  //We just copy all the elements down and ignore the last one
  int i;
  for(i=index; i < numElem-1; i++)
  {

    array[i] = array[i+1];
  }
  numElem--;
  return;
}

int get(int index)
{
    // return the value at that index
  return array[index];
}
