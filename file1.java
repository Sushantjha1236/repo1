class Solution {
    public void depthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int start) {
        visited[start] = 1;
        for (int neighbor : adjLIST.get(start)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(adjList, visited, neighbor);
            }
System.out.println("hiee");
        }
