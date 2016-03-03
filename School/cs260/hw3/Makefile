PYTHON = python
VIEWER = less

.PHONY: clean run view

problem1 : problem1.py
	python problem1.py $(arg)

problem2 : problem2.py
	python problem2.py $(arg)

problem3 : problem3.py
   python problem3.py $(arg)

view : problem1.py problem2.py problem3.py 
		$(VIEWER) problem1.py 
		$(VIEWER) problem2.py
		$(VIEWER) problem3.py
clean :
	- \rm $(outFile) > /dev/null 2>&1
	- \rm *.pyc > /dev/null 2>&1

