CC=gcc
CFLAGS = -I
VIEWER = less
.PHONY: clean run view

anagram : anagram.c
	$(CC) -o anagram anagram.c 
	
run : anagram
			 
			 ./anagram $(file) $(word)

view : README anagram.c
			 $(VIEWER) README
			 $(VIEWER) anagram.c

clean :
	- \rm *.o > /dev/null 2>&1
	- \rm *.exe > /dev/null 2>&1
