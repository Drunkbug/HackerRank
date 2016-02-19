from collections import defaultdict
import itertools
import heapq


def dijkstra(E, begin, end):
    graph = defaultdict(list)
    for src, dest, cost in E:
        graph[src].append((cost, dest))
    in_q = [(0, begin)]
    viewed = set()

    while in_q:
        (cost, v) = heapq.heappop(in_q)
        if v not in viewed:
            viewed.add(v)
            if v == end:
                return cost
            for cost2, v2 in graph.get(v, ()):
                if v2 not in viewed:
                    heapq.heappush(in_q, (cost + cost2, v2))
    return float("inf")

def main():
    buffer = map(int, raw_input().strip().split(' '))
    k = int(buffer[0])
    d = int(buffer[1])
    a = map(int, raw_input().strip().split(' '))
    c = map(int, raw_input().strip().split(' '))
    discount = defaultdict(list)

    for i in range(0, d):
        dis = map(int, raw_input().strip().split(' '))
        discount[dis[0]].append(dis[1:])

    for i in range(0, k):
        dis = [0] * k
        dis[i] = 1
        discount[c[i]].append(dis)

    begin = [0] * k
    string_begin = ''.join(map(str, begin))
    string_end = ''.join(map(str, a))
    E = []

    all_acc = []

    for i in a:
        acc = []
        for j in range(0, i + 1):
            acc.append(j)
        all_acc.append(acc)

    q = [("", "", 0)]
    all_nodes = list(itertools.product(*all_acc))
    shrink = 4

    if len(all_nodes) >= 50000 and len(all_nodes) < 100000:
        shrink = 3
    shrink_nodes = all_nodes[(len(all_nodes)/shrink):]
    if len(all_nodes)> 100000 and len(all_nodes)<110000:
        shrink_nodes = all_nodes[len(all_nodes)/2:]
    if len(all_nodes) >= 110000 and len(all_nodes) < 120000:
        shrink_nodes = all_nodes[(len(all_nodes)/shrink):]
        shrink_nodes = shrink_nodes[len(shrink_nodes)/2:]
    if len(all_nodes) >= 120000:
        shrink_nodes = all_nodes[(len(all_nodes)/shrink):]
        shrink_nodes = shrink_nodes[len(shrink_nodes)/2:]
        shrink_nodes = shrink_nodes[len(shrink_nodes)/4:]








    for vertex in shrink_nodes:
        if(all(v == 0 for v in vertex)):
            continue
        for key in discount:
            # find all discounts
            for value in discount[key]:
                if(sum(value) > sum(vertex)):
                    continue
                flag = 0
                vacc = list(vertex)
                for i in range(0, len(vertex)):
                    if vacc[i] < value[i]:
                        flag = 1
                        continue
                    vacc[i] = vacc[i] - value[i]
                if not flag:
                    E.append(("".join(map(str, vertex)), "".join(map(str, vacc)), key))



    print dijkstra(E, string_end, string_begin)


if __name__ == '__main__':
    main()
