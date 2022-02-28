package com.munywele;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int verticeCount;

    // Adjacency List representation
    private LinkedList<Integer> adj[];

    // Constructor
    public Graph(int vertice) {
        this.verticeCount = vertice;
        adj = new LinkedList[vertice];
        for (int i = 0; i < vertice; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge
    // into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public boolean isCyclic() {
        Boolean[] visited = new Boolean[verticeCount];
        //populate with false flag
        for (int x = 0; x < visited.length; x++) {
            visited[x] = false;
        }

        //loop through the nodes and check which ones are cyclic
        for (int y = 0; y < verticeCount; y++) {
            if (visited[y] == false) {
                //if not visited proceed
                if (checkCyclic(y, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCyclic(int vertex, Boolean[] visited, int parent) {
        visited[vertex] = true;
        int nextVertex = 0;
        //iterate through the list
        Iterator<Integer> it = adj[vertex].iterator();

        //use iterator because for and while are O(n^2) - get[i] processes thee same variable so n*n
        //do a recursive step through the nodes if an adjacent node is not visited
        while (it.hasNext()) {
            nextVertex = it.next();
            if (visited[nextVertex] == false) {
                //do a recursive step through the nodes if an adjacent node is not visited
                if (checkCyclic(nextVertex, visited, parent)) {
                    return true;
                } else if (nextVertex != parent) {
                    //if adjacent is already visited and it  not the parent node then it is a cyclic graph
                    return true;
                }
            }
        }
        return false;
    }
}
