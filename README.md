# Graph


In the scope of this project, you are expected to implement the Betweenness and Closeness centrality metrics and rank the nodes of the given two graph datasets which are Zachary Karate Club Network and Facebook Social Network.

Explanation of Centrality Metrics
Centrality metrics are used to identify the most important nodes within a graph. There are various centrality metrics including Degree, Closeness, Betweenness, Eigenvector, Katz, PageRank, etc. In the scope of this project, you are expected to implement the following two centrality metrics and test on the given two graph datasets.

	Betweenness Centrality
Betweenness centrality shows the strategic location of a node in a graph. Betweenness centrality of a node n is defined as the number of shortest paths going through the node n. For each pair of nodes, shortest paths between them are computed and the fraction of shortest paths passing through n is calculated. The betweenness of node n is obtained by summing this fraction for all pairs of nodes as defined in the following equation.
C_B (n)=∑_(s≠n≠t∈V)▒(σ_st (n))/σ_st 
where, σ_st   is the total number of shortest paths from node s to node t; σ_st (n) is the number of those paths that pass-through node n. 

	Closeness Centrality
Closeness centrality depends on measure of how close a node is to the other nodes in the graph. A node in a more central location is considered closer to all other nodes. Closeness is calculated by taking the average length of the shortest paths between the node n and all other nodes as given in the following equation.
C_C (n)=1/(∑_(i≠n∈V)▒〖dist(i,n)〗)
where dist(i, n) is the minimum distance between nodes i and n. 
