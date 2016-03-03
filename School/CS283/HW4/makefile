CC=gcc
CFLAGS = -I
VIEWER = less
.PHONY: clean run view

filenames : 
	$(CC) -o filenames filenames.c 
	
run : filenames
			 
			 ./filenames $(pattern) $(replace)

view : README filenames.c
			 $(VIEWER) README
			 $(VIEWER) filenames.c

clean :
	- \rm *.o > /dev/null 2>&1
	- \rm *.exe > /dev/null 2>&1
