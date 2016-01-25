# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
import math
n = int(raw_input().strip())
n2 = int(raw_input().strip())
output = ""
for num in range(n,n2+1):
        square = str(int(math.pow(num, 2)))
        length = math.floor(len(square)/2)
        if len(square) >= 2 and len(square) % 2 != 0:
            if int(square[:-int(length)-1]) + int(square[-int(length)-1:]) == num:
                output += str(num) + " "
        if len(square) >= 2 and len(square) % 2 == 0:
            if int(square[:-int(length)]) + int(square[-int(length):]) == num:
                output += str(num) + " "
        else:
            if int(square) == num:
                output += str(num) + " "
if output == "":
    print "INVALID RANGE"
else:
    print output