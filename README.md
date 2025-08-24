# LinkedIn Simulation - Social Network 

## Description

This project simulates a social network using graph data structures, where each node represents a person, and edges between nodes indicate the connections (friendships, professional relationships, etc.) between them. The network employs a depth-first search (DFS) algorithm to score and suggest similar people to a user based on their connections and network.

The suggested people are ranked using a heap data structure, ensuring that the most similar individuals appear first in the recommendation list.

## Features 

- **Graph Data Structure**: Representing the network as a graph where each person is a node and the relationships (connections) between people are edges.
- **DFS Algorithm**: Used to traverse the network and score the similarity between people based on their mutual connections.
- **Heap Data Structure**: Used to sort and retrieve the most similar people (those with the highest score) efficiently.
- **User Recommendations**: The system suggests similar people to the user based on their connections in the network.

## Usage 

1. **Creating the Network**:
   - Create nodes representing people and add edges to indicate connections.

2. **Suggesting Similar People**:
   - Use the DFS algorithm to traverse the graph and score other nodes based on their similarity to the target person.
   - The system ranks and suggests people with the highest similarity score using a heap data structure.

## Algorithms 

### DFS Algorithm 
The DFS algorithm is used to explore the network from a starting node (person) and calculate a similarity score for each connected person. The score is based on the number of mutual connections and the depth of the connection.

### Heap Data Structure 
The heap is used to efficiently store and retrieve the most similar people to the user. By maintaining the heap in sorted order, we can easily access the person with the highest similarity score.

## Structure 

- **Graph Representation**: The network is represented as a graph, with nodes as people and edges as connections.
- **Node**: A person in the network.
- **Edge**: A connection between two people.
- **Heap**: Used for sorting and retrieving similar people based on their DFS scores.
