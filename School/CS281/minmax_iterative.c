/* #include  <stdio.h>  */

void MinMaxIt (A, n, _min, _max) 
register int * A;
register unsigned int n;
register int * _min;
register int * _max;
 {
  register int min asm ("s5") ;
  register int max asm ("s6") ;
  register int * p asm ("s7") ;
  min = A[0];
  max = A[0];
  for (p = &A[1]; p < &A[n]; p ++ ) 
   {
    if ( * p < min) min = * p;
    if ( * p > max) max = * p;
   }
  * _max = max;
  * _min = min;
 }

void main () 
 {
  int A[10] = 
   {
    1, 2, 3, 4, 5, 6, 7, 8, 9, 10
   };
  int min, max;

  MinMaxIt (A, 10, &min, &max) ;
  printf ("MinMaxIt = %d %d \n", min, max) ;
 }
