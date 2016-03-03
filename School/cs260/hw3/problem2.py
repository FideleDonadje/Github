#!/usr/bin/python
#Recursive fibonacci serie using an array
#Fidele Donadje 
#CS260 002
# 2/06
#

import sys

def fib(n):
   if n==0:
      return 0;
   elif n==1:
      return 1;
   return (fib(n-1)+fib(n-2))
array_fib={}
def fib_memo(n):
  if not n in array_fib:
    array_fib[n] = fib(n-1) + fib(n-2)
  return array_fib[n]

#check if the argument is an integer
#if ((isinstance(int(sys.argv[1]), int))) :
n=int(sys.argv[1])
print "The fibonacci number of " + str(sys.argv[1])+" is "+str(fib_memo(n))
