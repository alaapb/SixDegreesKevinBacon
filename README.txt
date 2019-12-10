Running Times & Notes:

Graph:
    Add Edge:
        - When adding the edge I check both the key/value pairs for both the actors to make sure there is already a linked list there if not I will create one and put it into the map
        - If the two the actors are the same then it does not do anything because this would result in cycles in the graph when created
        - O(1) because you are just checking the map to see if it already exists if not then it just makes a new one and the continues
    Find:
        - This is depth first search recursively
        - It looks to see if it exists in the temp linked list which is the neighbours of the node we are on
        - If not found their, it tries to find it in the value of the neighbours and so on
        - Find will be called recursively until it has found the destination
        - O(|V| + |E|) because we are using an adjacency list this is the run time

JSONR:
- Parses through the file line by line and looks to see if there is an actor on it or not, if there is it will add it to the actor arraylist which is later used to add all the edges between those actors

Test:
- This class is used to run everything in a uniform way
- It contains the UI of the program

