import java.util.ArrayList;

public class Vertex {
	private int unit;
	private boolean discovered;
	private int betweenness;
	private double closeness;
	private String name;
	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public int getBetweenness() {
		return betweenness;
	}

	public void setBetweenness(int betweenness) {
		this.betweenness = betweenness;
	}

	public double getCloseness() {
		return closeness;
	}

	public void setCloseness(double closeness) {
		this.closeness = closeness;
	}

	private ArrayList<Edge> edges;
	private Vertex parent;
	
	public Vertex(String name) {
		this.name = name;
		edges = new ArrayList<Edge>();
		parent = null;
		closeness=0;
		 discovered=false;
		betweenness=0;
		 unit=0;
	}

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

}
