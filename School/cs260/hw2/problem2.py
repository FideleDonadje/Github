#!/usr/bin/python
#problem2.py - concatenate 2 list A and B and sace the data
#
#
#
#
import sys 
import cell

A= [1,2,3,4]
B= [4,5,6,7]

for i in A :
	head = None 
	tail = None 
	
	node= cell.Cell(i)
	
	if head == None : 
		head = node
		tail = node
	else :
		tail.next = node
		tail = node

while head.next!= None : 
	print head.__str__()
