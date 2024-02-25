class Solution {
    public void depthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int start) {
        visited[start] = 1;
        for (int neighbor : adjacencyList.get(start)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
            System.out.println("hiee sj ");
        }  
