#!/bin/python

import sys

t = int(raw_input().strip())
for a0 in xrange(t):
    height = 1
    n = int(raw_input().strip())
    for i in range(1,n+1):
        if i % 2 != 0:
            height = height * 2
        else:
            height = height + 1
    print str(height)
