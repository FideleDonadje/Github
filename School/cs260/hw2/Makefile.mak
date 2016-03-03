PYTHON = python
VIEWER = less

.PHONY: clean run view

run : problem1.py
			#chmod u+x hello.py 
			$(PYTHON) hello.py

view : problem1
			 $(VIEWER) hello.py 

clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

