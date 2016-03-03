#!/usr/bin/python
#Recursive fibonacci serie
#Fidele Donadje 
#CS260 002
# 2/06
#

import sys

def fib_normal(n):
   if n==0:
      return 0;
   elif n==1:
      return 1;
   return (fib_normal(n-1)+fib_normal(n-2))

#check if the argument is an integer

if ((isinstance(int(sys.argv[1]), int))) :
   print "The fibonacci number of " +str(sys.argv[1])+" is " +str(fib_normal(int(sys.argv[1])))