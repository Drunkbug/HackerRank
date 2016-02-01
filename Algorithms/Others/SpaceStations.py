#!/bin/python

import sys
n,m = raw_input().strip().split(' ')
n,m = [int(n),int(m)]
c = sorted(map(int,raw_input().strip().split(' ')))
maxdis = [-1] * n
for i in range(0,m-1):
    maxdis[i] = abs(c[i+1]-c[i])/2
    
print max(max(maxdis),max(c[0], n-c[m-1]-1))
