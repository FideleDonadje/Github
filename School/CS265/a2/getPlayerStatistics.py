#!/usr/bin/python
#
# getPlayerStatistics.py - Reporting Baseball Player Statistics
#
# Fidele Donadje
# 11/02
#
# 
import sys
filename = sys.argv[1]
#filename = raw_input(' > ')

f = open( filename, "r" )  # open file for reading (default)
dic_player = {}
list_team = {}
l = f.readline()
while l :
   l = l.rstrip()
   list = l.split(',')
   key = list[2]
   player_name = list.pop(0)+ " " +list.pop(0)
   
   if not (list_team.has_key(key) ):
     list_team[key]=[]
   dic_player[player_name] = list
   l = f.readline();

list_team = sorted(list_team)
ans = True
while ans:

  print "          ----------MENU----------"
  print"1:List of all teams  "
  print"2:List of all the players "
  print"3:Quit "

  ans = raw_input("What would you like to do ")
  if ans == "1":
     i=1
     for team in  list_team:
        print i,":", team
        i=i+1
     ans = int(input("What team would you like to choose? "))
     if ans == "1":
      for player in dic_player:
       if list_team[ans-1]==dict_player[0] :
          print player, dic_player[player]
  
  if ans == "2":
     j=1
     for player in dic_player:
      print j,":", player
      j=j+1

  elif ans == "3":
      print"\n Thank you and goodbye !!"
      ans = None
  else:
     print("\n Not a valid operation Try again")
     
  
f.close()

