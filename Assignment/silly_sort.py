import array
import sys
count1 = 0
count2 = 0
count3 = 0


def count_silly_sort(n, a):
    global count1
    if n < 2:
        return a
    else:
        for i in range(0,n):
            k = a[0]
            a[0] = a[i]
            a[i] = k
            maybe_sorted = [0] * n
            maybe_sorted[0] = a[0]
            new_array = count_silly_sort(n-1, a[1:])

            for j in range(1,n):
                maybe_sorted[j] = new_array[j-1]
            flag = 0

            for j in range(0, n - 1):
                count1 += 1
                if maybe_sorted[j] > maybe_sorted[j+1]:
                    flag = 1
                    break

            if flag == 0:
                return maybe_sorted
            else:
                k = a[0]
                a[0] = a[i]
                a[i] = k


def main():
    n = int(raw_input().strip())
    arr = map(int, raw_input().strip().split(' '))
    arr = count_silly_sort(n, arr)
    print(arr)

    print(str(count1) + "\n")
    # print(count2 + "\n")
    # print(count3 + "\n")

if __name__ == '__main__':
    main()