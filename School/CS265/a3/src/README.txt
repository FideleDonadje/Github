The Grid will be as follows 
  0 1 2 3 4 5 6
0 # # B # B # # 0 
1 # @ @ @ @ @ # 1
2 B @ @ @ @ @ B 2
3 # @ @ @ @ @ # 3
4 B @ @ @ @ @ B 4
5 # @ @ @ @ @ # 5
6 # # B # B # # 6
  0 1 2 3 4 5 6

B = Brides
# = Water
@ = Move positions

We will generate a random number between 0-3 that will determine in which direction 
in which the move will be made.
  N=0
W=3   E=2
  S=1

The Cat cannot cross the bridges or get in the water.
If his move in on a bridge or water, we move him the opposite direction.

The mouse drowns if she get in the water or escapes if she get to the bridges
The bridges are the set of of even coordinates such that x%2==0 and y%2==0
The mouse crosses a bridge when x%2==0 and y%2==0. 


