class Solution {
    public void depthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int start) {
        visited[start] = 1;
<<<<<<< HEAD
        for (int neighbor : adjacencyList.get(start)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
            System.out.println("hiee sj ");
        }  
=======
        for (int neighbor : adjLIST.get(start)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(adjList, visited, neighbor);
            }
System.out.println("hiee");
        }
>>>>>>> re2/main
