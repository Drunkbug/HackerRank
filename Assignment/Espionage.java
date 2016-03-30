import java.util.*;
import java.math.*;
/**
 * Created by leyiqiang on 2/15/16.
 */
public class Solution {
    public static class Graph {
        int edgeNum;
        PriorityQueue<Edge> edges;
        Vertex[] vlist;

        public Graph(int edgeNum, int vNum) {
            this.edgeNum = edgeNum;
            this.edges = new PriorityQueue<>(edgeNum, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.weight - o2.weight;
                }
            });
            this.vlist = new Vertex[vNum];
        }



    }


    public static class Edge {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

    }

    public static class Vertex {
        int id;
        int parent;
        int rank;

        public Vertex(int id, int parent, int rank) {
            this.id = id;
            this.parent = parent;
            this.rank = rank;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n, m, f;
        n = input.nextInt();
        m = input.nextInt();
        f = input.nextInt();


        Graph graph = new Graph(m, n);
        Vertex[] vertices = graph.vlist;
        for (int i = 0; i < m; i++) {
            int left = input.nextInt();
            int right = input.nextInt();
            int threat = input.nextInt();
                Vertex v = new Vertex(left, left, 0);
                vertices[left] = v;
                Vertex v2 = new Vertex(right, right, 0);
                vertices[right] = v2;
            Edge edge = new Edge(left, right, threat);
            graph.edges.add(edge);
        }

        int[][] foundEdge = new int[f][2];
        for (int i = 0; i < f; i++) {
            int left = input.nextInt();
            int right = input.nextInt();
            foundEdge[i][0] = left;
            foundEdge[i][1] = right;
        }

        ArrayList<Edge> explodedEdges = new ArrayList<>();
        while (graph.edges.size() != 0) {
            Edge edge = graph.edges.remove();
            Vertex v1 = findParent(edge.v1, vertices);
            Vertex v2 = findParent(edge.v2, vertices);
            if (v1 != v2) {
                explodedEdges.add(edge);
                combine(v1, v2, vertices);
            }
        }
        for (int i = 0; i < f; i++) {
            boolean flag = false;
            for (Edge e : explodedEdges) {
                if ((e.v1 == foundEdge[i][0] && e.v2 == foundEdge[i][1]) ||
                        (e.v2 == foundEdge[i][0] && e.v1 == foundEdge[i][1])) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static void combine(Vertex v1, Vertex v2, Vertex[] vlist) {
        int v1Rank = v1.rank;
        int v2Rank = v2.rank;
        if (v1Rank > v2Rank) {
            vlist[v2.id].parent = v1.id;
        } else if (v1Rank == v2Rank) {
            v2.rank++;
            vlist[v1.id].parent = v2.id;
        } else {
            vlist[v1.id].parent = v2.id;
        }
    }

    public static Vertex findParent(int v, Vertex[] vlist) {
        if (vlist[v].parent == v) {
            return vlist[v];
        } else {
            return findParent(vlist[v].parent, vlist);
        }
    }

}
