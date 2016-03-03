#!/usr/bin/env python
#
# Create a file, one expression per line
#	 redirect from standard input:
#		test.py < input
#
# Notes:  We are not making our input bullet-proof.  If it looks like a #,
# then it is
#
#		Operands must be integers
#
#		The parser doesn't handle negative operands
#

from lexer import *
import tree
A = tree.tree()

while get_expression():
	t = get_next_token()
	while t:
		N=tree.node()
		if str.isdigit( t[0] ) : # we have a (non-negative) number
			op = 'operand'
			if N.left != None:
				N.right = t
			else :
				N.left =t
		else:
			op = 'operator'
			N.value = t
		print 'Got token: ' + t + ' (an ' + op + ')'
		print N.echo()
		t = get_next_token()
	
	print ''
A.nodes.append(N)
for i in A.nodes:
	print i.__str__()
