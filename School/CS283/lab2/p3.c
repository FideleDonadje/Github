//Fidele Donadje
//12722483
//CS283-002 Lab2
//
//Write a function sort() that takes in an int* a and int size,
//and sorts the array using pointer arithmetic.
//
//
void sort(int* a, int size);
int main(int argc, char** argv)
{

    int sizeArray = 10, i;

    //We declare the array
    int *intArray =(int*)malloc(10*sizeof(int));

    //We assign values to the array

        intArray[0]=9;
        intArray[1]=0;
        intArray[2]=2;
        intArray[3]=1;
        intArray[4]=3;
        intArray[5]=4;
        intArray[6]=5;
        intArray[7]=7;
        intArray[8]=8;
        intArray[9]=6;
    printf("Before sorting, the array is : ");
    for(i=0; i<sizeArray; i++)
    {
        printf("%d",intArray[i]);
    }
    printf("\nAfter sorting the array is : ");
    sort(intArray,sizeArray);
    for(i=0; i<sizeArray; i++)
    {
        printf("%d",intArray[i]);
    }
}
void sort(int* a, int size)
{
  int lastElement= size-1;
  if(lastElement <0)
  {
    //The last element is the first element: the array is sorted
    return;
  }

  int index0 = 0;
  int index1 = 1;
  //We compare 2 adjacent elements
  while((index1 <= lastElement) && (index1 < size))
  {
    //If the higher index value is less, we swap
    if(a[index1] < a[index0])
    {
      int old0 = a[index0];
      int old1 = a[index1];
      a[index1] = old0;
      a[index0] = old1;
    }
//    We move to the next elements
    index0++;
    index1++;
  }
  //The last element is now sorted, we ignore it next time
  lastElement--;
  //recursive call
  sort(a,lastElement);
}
