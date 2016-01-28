#!/bin/python

import sys
count = 0
  
t = int(raw_input().strip())
for a0 in xrange(t):
    n = int(raw_input().strip())
    num_str = str(n)
    count = 0
    for s in num_str:
        if int(s) !=0:
            if n % int(s) == 0:
                count+=1
    print count