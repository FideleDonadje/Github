//Fidele Donadje
//12722483
//CS283-002 Lab2
//
//Define an int* pointer variable, and create an array of 10 integers using malloc().
//Then, assign values to that array, print their values, and free() the integers.

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv)
{
    //sizeArray is the size of the array, i is the index of the array
    int sizeArray = 10, i;

    //We declare the array
    int *intArray =(int*)malloc(10*sizeof(int));

    //We assign values to the array
    for(i=0; i<sizeArray; i++)
    {
        intArray[i]=i;
    }

    // we print the values
    for(i=0; i<sizeArray; i++)
    {
        printf("The value of intArray[%d] is %d\n",i,intArray[i]);
    }

    //We free the array
    free(intArray);
    return 0;
}
