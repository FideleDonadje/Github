#!/usr/bin/python
#Recursive fibonacci serie
#Fidele Donadje 
#CS260 002
# 2/06
#
import timeit
import sys 
import random 
import sys

f = open("mydata.txt", "w")

def fib_normal(n):
   if n==0:
      return 0;
   elif n==1:
      return 1;
   return (fib_normal(n-1)+fib_normal(n-2))

array_fib={}
def fib_memo(n):
  if not n in array_fib:
    array_fib[n] = fib_normal(n-1) + fib_normal(n-2)
  return array_fib[n]
def test2():
  fib_memo(int(sys.argv[1]))

  
def test1():
  fib_normal(int(sys.argv[1]))

file1 = open("mydata.txt","w")
file1.write("Data for fib_memo.\n")
print(" n  fib_memo           fib_normal")
for n in range(1,11,1):
  l = str(n)+" "+str((timeit.timeit(test2,number=1)*1000))+"\n";
  print str(n) + " "+str((timeit.timeit(test2,number=1)*1000)) + " " + str((timeit.timeit(test1,number=1)*1000))
  file1.write(l)
file1.close()
  
  
  




