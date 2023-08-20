import java.io.IOException;

public class Manage {
	public void printdatas() 
	{
    
	System.out.println("2017510094 Ýbrahim Halil Þapuk");
	double temp = System.currentTimeMillis();
	Graph graph = new Graph();
	
    try {
		graph.read("karate_club_network");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	graph.all();
	Vertex vertex = highestBetweenness(graph);
	System.out.println("Zachary Karate Club Network - The Highest Node for Betweennes: " + vertex.getName() + " and the value: " + vertex.getBetweenness());
	vertex = highestCloseness(graph);
	System.out.println("Zachary Karate Club Network - The Highest Node for Closeness: " + vertex.getName() + " and the value is " + 1/vertex.getCloseness());
	
	Graph graph2 = new Graph();
	try {
		graph2.read("facebook_social_network");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	graph2.all();
	vertex = highestBetweenness(graph2);
	System.out.println("Facebook Social Network - The Highest Node for Betweennes: " + vertex.getName() + " and the value: " + vertex.getBetweenness());
	vertex = highestCloseness(graph2);
	System.out.println("Facebook Social Network - The Highest Node for Closeness: " + vertex.getName() + " and the value is " + 1/vertex.getCloseness());
	
	double time = System.currentTimeMillis() - temp;
	System.out.println(time/1000 + " seconds");

	}

 public static Vertex highestBetweenness(Graph graph) {
	int betweenness = 0;
	Vertex highBetween = null;
	for(Vertex vertex: graph.vertices()) {
		if(highBetween == null || betweenness < vertex.getBetweenness()) {
			highBetween = vertex;
			betweenness = vertex.getBetweenness();
		}	
	}
	return highBetween;
}
public static Vertex highestCloseness(Graph graph) {
	double sumDistance = 0;
	Vertex highClose = null;
	for(Vertex vertex: graph.vertices()) {
		if(highClose == null || sumDistance > vertex.getCloseness() &&  vertex.getCloseness() > 1) {
		highClose = vertex;
			sumDistance = vertex.getCloseness();
		}	
	}
	return highClose;
}

	
}
	
