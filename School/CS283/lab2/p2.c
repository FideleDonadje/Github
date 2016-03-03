//Fidele Donadje
//12722483
//CS283-002 Lab2
//
//Using malloc, create a char** pointer that contains 10 char*'s, then in a loop,
//initialize each of the 10 char*'s in a loop to a char array of size 15,
//and initialize each to a word of your choice
//(don't forget the null terminator \0) -- and print them to screen.

int main(int argc, char** argv)
{
    //sizeArray is the size of the array, i is the index of the array
    //sizeString is the size of each string
    int sizeArray = 10, sizeString = 15, i;

    //allocate memory for the array of pointers to a string
    char** stringArray = (char*)malloc(sizeArray*sizeof(char*));

    //allocate memory for each string
    for(i=0; i< sizeArray; i++)
    {
        stringArray[i]= malloc(sizeString*sizeof(char));
    }
    //we initialize each string using sprintf.
    //sprintf sends formatted output to a string pointed to by stringArray.
    for(i=0; i < sizeArray; i++)
    {
        sprintf(stringArray[i],"string %d\0",i);
    }

    //We print each string
    for(i=0; i< sizeArray; i++)
    {
        printf("String %d is : %s\n",i,stringArray[i]);
    }

    //We free each string
    for (i=0; i < sizeArray; i++)
    {
        free(stringArray[i]);
    }

    free(stringArray);
}
