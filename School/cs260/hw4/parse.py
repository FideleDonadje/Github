#!/usr/bin/env python
#HW 4
#
#Definition of the node for the tree 
#Definition of the tree
#Definition of the evaluation function
#

class node(object):
    def __init__(self, value = None, left = None, right = None):
        self.value = value
        self.left = left
        self.right = right
		
class tree(object):
	def __init__(self):
		self.nodes=[]
	
def evaluate(self):
        if self.value == '+':
            return self.left.evaluate() + self.right.evaluate()
        elif self.value == '-':
            return self.left.evaluate() - self.right.evaluate()
        elif self.value == '*':
            return self.left.evaluate() * self.right.evaluate()
        elif self.value == '/':
            return self.left.evaluate() / self.right.evaluate()
        else:
            return self.value