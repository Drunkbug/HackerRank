#!/bin/python

import sys


S = raw_input().strip()
num = len(S)/3
count = 0
for i in range (0,num):
    if S[i*3 + 0] != 'S':
        count+=1
    if S[i*3 + 1] != 'O':
        count+=1
    if S[i*3 + 2] != 'S':
        count+=1

print count