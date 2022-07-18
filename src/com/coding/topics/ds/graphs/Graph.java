package com.coding.topics.ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Adjacency List Graph Implementation
public class Graph {
  private final int no_of_vertices;
  private final List<LinkedList<Node>> adjacencyList;

  public Graph(int no_of_vertices) {
    this.no_of_vertices = no_of_vertices;
    adjacencyList = new ArrayList<>();
    for(int i = 0; i < no_of_vertices; i++) {
      adjacencyList.add(new LinkedList<>());
    }
  }

  public static class Node {
    private final int weight;
    private final int id;

    public Node(int id) {
      this.id = id;
      this.weight = 0;
    }

    public int getId() {
      return this.id;
    }

    @Override
    public String toString() {
      return "Node{" +
          "weight=" + weight +
          ", id=" + id +
          '}';
    }
  }

  public void addEdge(Node source, Node destination) {
    if (source.getId() < no_of_vertices && destination.getId() < no_of_vertices) {
      adjacencyList.get(source.getId()).add(destination);
    }
  }

  public void printGraph() {
    for (int i = 0; i < no_of_vertices; i++) {
      System.out.println(adjacencyList.get(i));
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(new Node(0), new Node(1));
    graph.addEdge(new Node(0), new Node(2));
    graph.addEdge(new Node(1), new Node(3));
    graph.addEdge(new Node(2), new Node(3));
    graph.printGraph();
  }
}
