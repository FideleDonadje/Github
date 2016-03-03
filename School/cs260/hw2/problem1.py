#!/usr/bin/python
#problem1.py - concatenate 2 list A and B
#
#
#
#

def list_concat(A,B)
	#we will link the tail of the first list to the head of the 	
	#second list
	temp = A
	#we go at the end of A
	while temp.next != None:
		temp = temp.next
	#we are at the tail of A.We point it to be the head of B
	temp.next = B
	return A
