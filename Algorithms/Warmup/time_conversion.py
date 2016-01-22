#!/bin/python

import sys
time = raw_input().strip()
if time[8] == 'P':
    if (int(time[:2])!=12):    
        i = int(time[:2])
        time = str(i+12) + time[2:]
if time[8] == 'A' and (int(time[:2]) == 12):
    time = "00" + time[2:]
print time[:-2]