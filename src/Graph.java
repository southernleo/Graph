import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
private HashMap<String, Vertex> vertices;
private HashMap<String, Edge> edges;
private ArrayList<String> shortpaths;
public Graph() {
	this.vertices = new HashMap<>();
	this.edges = new HashMap<>();
	this.shortpaths = new ArrayList<String>();
}
	public String shortPath(Vertex firstVertex, Vertex lastVertex) {
		String strp = "";
		setvertex();
		
		boolean flag = false;
		Queue<Vertex> vertexQueue = new LinkedList<>();
		firstVertex.setDiscovered(true);
		vertexQueue.add(firstVertex);
		while(!flag && !vertexQueue.isEmpty()) {
			Vertex frontVertex = vertexQueue.poll();
			if(frontVertex.getEdges() != null) {
				for(Edge edge: frontVertex.getEdges()) {Vertex nextadj;
					if(edge.getSource().equals(frontVertex))
						nextadj= edge.getDestination();
					else
						nextadj= edge.getSource();
					if(!nextadj.isDiscovered()) {
						nextadj.setDiscovered(true);
						nextadj.setUnit(frontVertex.getUnit() + 1);
						nextadj.setParent(frontVertex);
						vertexQueue.add(nextadj);
					}
					if(nextadj.equals(lastVertex)) {
						flag = true;
						break;
					}
				}
			}
		}
		int pathLength = lastVertex.getUnit();
		firstVertex.setCloseness(firstVertex.getCloseness() + pathLength);
		lastVertex.setCloseness(lastVertex.getCloseness() + pathLength);
		strp += lastVertex.getName();
		Vertex vertex = lastVertex;
		while(vertex.getParent() != null)
		{
			vertex.setBetweenness(vertex.getBetweenness() + 1);
			vertex = vertex.getParent();
			strp +=  "," + vertex.getName();
		}
		return strp;
	}
	public void all() {
		int j = -1, i = -1;
		for (Vertex vertex1 : vertices.values())
		{
			j++;
			i = -1;
			for(Vertex vertex2 : vertices.values()) {
				i++;
				if(j >= i)
					continue;
				String path = shortPath(vertex1, vertex2);
				shortpaths.add(path);
			}
		}
	}

	public void addEdge(String source, String destination) {

		if (edges.get(source + "-" + destination) == null && edges.get(destination + "-" + source) == null) {
			Vertex source_vertex, destination_vertex;

			if (vertices.get(source) == null) {
				source_vertex = new Vertex(source);
				vertices.put(source, source_vertex);
			} else
				source_vertex = vertices.get(source);

			if (vertices.get(destination) == null) {
				destination_vertex = new Vertex(destination);
				vertices.put(destination, destination_vertex);
			} else
				destination_vertex = vertices.get(destination);

			Edge edge = new Edge(source_vertex, destination_vertex);
			source_vertex.addEdge(edge);
			destination_vertex.addEdge(edge);
			edges.put(source + "-" + destination, edge);
		} 
		else {
			System.out.println("This edge has already added!");
		}
	}

	public void print() {

		System.out.println("Source\tDestination");
		for (Edge e : edges.values()) {
			System.out.println("" + e.getSource().getName() + "\t" + e.getDestination().getName() );
		}
	}

	public Iterable<Vertex> vertices() {
		return vertices.values();
	}

	public Iterable<Edge> edges() {
		return edges.values();
	}

	public int size() {
		return vertices.size();
		
	}
	public void setvertex() {for (Vertex vertex : vertices.values()) {
		vertex.setDiscovered(false);
		vertex.setParent(null);
		vertex.setUnit(0);
	}
		
	}
	
	
	public void read(String fileName) throws IOException {
		 File file = new File(
				 fileName + ".txt");
		 BufferedReader br
        = new BufferedReader(new FileReader(file));
		 String st;
		 while ((st = br.readLine()) != null) {
			 String[] vertices = st.split(" ");
			addEdge(vertices[0], vertices[1]);
			 
	    }
	}
}
