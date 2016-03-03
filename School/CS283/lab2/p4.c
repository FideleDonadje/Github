



//Modify this program to take in a linked list of structs
//that you create (with a int data element,
//and a struct ListNode* next pointer), and sort the linked list instead.

//We define a structure for a node

#include <stdio.h>
#include <stdlib.h>
struct ListNode
{
  int data;
  struct ListNode* next;
  struct ListNode* prev;
};

void sort(struct ListNode * listHead, int size);
void bubble_sort(struct ListNode * listHead, int size, int lastelement);

int main(int argc, char** argv)
{
  int listSize = 10;
  //Create the head
  struct ListNode * listHead = malloc(sizeof(struct ListNode));
  listHead->prev = NULL;

  //go through the node
  struct ListNode * current;
  int count = 1; //Head already created
  current = listHead;
  do
  {
    current->data = (rand()%1000+4); //rand will generate random numbers

    //If more nodes needed
    if(count < listSize)
    {
      //Allocate a new node and link next
      current->next = malloc(sizeof(struct ListNode));

      current->next->prev = current;
      count++;
    }
    else
    {
      //This is the end
      current->next = NULL;
    }
    //Only assign the next value to current if next is not null
  }while((current->next != NULL) && (current = current->next));

  current = listHead;
  printf("Unsorted Linked List:\n");
  while(current != NULL)
  {
    printf("%d\n",current->data);
    current = current->next;
  }

  sort(listHead,listSize);

  current = listHead;
  printf("\nSorted Linked List:\n");
  while(current != NULL)
  {
    printf("%d\n",current->data);
    current = current->next;
  }

  return 0;
}

void sort(struct ListNode * listHead, int size)
{
  bubble_sort(listHead,size,size-1);
  return;
}
//defined a separate bubble_sort. I couldn't rewrite the one I used in p3.c
//I got confused at some point with the linked list
void bubble_sort(struct ListNode * listHead, int size, int lastelement)
{
  if(lastelement <0)
  {
    //Last element is first element - all elements sorted
    return;
  }

  struct ListNode * current = listHead;
  struct ListNode * next = listHead->next;
  int index0 = 0;
  int index1 = 1;


  while((index1 <= lastelement) && (index1 < size) )
  {
    //If the higher index value is less, we swap
    if( (next->data) < (current->data))
    {
      int old0 = current->data;
      int old1 = next->data;
      next->data = old0;
      current->data = old1;
    }
    index0++;
    index1++;
    current = next;
    next = current->next;
  }

  lastelement--;
  bubble_sort(listHead,size,lastelement);
}
