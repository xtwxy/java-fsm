package org.jgrapht;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Test;
import static java.lang.System.out;

public class JGraphTest {
	
	@Test
	public void testRemoveVertex() {
		DirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");

		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("A", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "D");

		out.println("before remove of 'D':");
		for (DefaultEdge e : g.edgeSet()) {
			out.println(e);
		}

		out.println("incoming-edges of 'A':");
		for (DefaultEdge e : g.incomingEdgesOf("A")) {
			out.println(e);
		}
		out.println("incoming-edges of 'D':");
		for (DefaultEdge e : g.incomingEdgesOf("D")) {
			out.println(e);
		}
		
		g.removeVertex("D");

		out.println("after remove of 'D':");
		for (DefaultEdge e : g.edgeSet()) {
			out.println(e);
		}

		out.println("adding edges to non-existing vertex 'D':");
		try {
			g.addEdge("B", "D");
			g.addEdge("C", "D");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
