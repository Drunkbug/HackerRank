#!/bin/python
import sys
from copy import copy,deepcopy


def main():
    n, m = raw_input().strip().split(' ')
    n, m = [int(n), int(m)]
    grid = []
    for i in range(0, n):
        row = list(raw_input().strip())
        grid.append(row)

    max1 = []
    for i in range(0, n - 1):
        for j in range(0, m - 1):
            copygrid = deepcopy(grid)
            acc = 0
            count = 0
            while i - acc >= 0 and j - acc >= 0 and i + acc < n and j + acc < m and copygrid[i - acc][j] == 'G' and \
                            copygrid[i + acc][j] == 'G' and copygrid[i][j + acc] == 'G' and copygrid[i][j - acc] == 'G':
                copygrid[i - acc][j] = 'F'
                copygrid[i + acc][j] = 'F'
                copygrid[i][j + acc] = 'F'
                copygrid[i][j - acc] = 'F'
                if (acc == 0):
                    count += 1
                else:
                    count += 4
                acc += 1

            count1 = count

            for k in range(0, n - 1):
                for l in range(0, m - 1):
                    acc = 0
                    count = 0
                    while k - acc >= 0 and l - acc >= 0 and k + acc < n and l + acc < m and copygrid[k - acc][
                        l] == 'G' and copygrid[k + acc][l] == 'G' and copygrid[k][l + acc] == 'G' and copygrid[k][
                                l - acc] == 'G':
                        if (acc == 0):
                            count += 1
                        else:
                            count += 4
                        acc += 1

                    count2 = count
                    # print k - acc
                    # print l - acc
                    # print k + acc
                    # print l + acc
                    # print copygrid[k - acc][
                    #     l]
                    # print copygrid[k + acc][l]
                    # print copygrid[k][l + acc]
                    # print copygrid[k][l - acc]
                    if count1 != 0 and count2 != 0:
                        max1.append(count1 * count2)


    print(max(max1))

if __name__ == '__main__':
    main()
