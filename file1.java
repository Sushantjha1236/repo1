class Solution {
    public void depthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int start) {
        visited[start] = 1;
        for (int neighbor : adjacencyList.get(start)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
        }
    }

    public static void factorizeAndMap(int number, HashMap<Integer, ArrayList<Integer>> primeFactorsMap, int index) {
        while (number % 2 == 0) {
            primeFactorsMap.put(2, primeFactorsMap.getOrDefault(2, new ArrayList<>()));
            ArrayList<Integer> temp = primeFactorsMap.get(2);
            temp.add(index);
            primeFactorsMap.put(2, temp);
            number /= 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactorsMap.put(i, primeFactorsMap.getOrDefault(i, new ArrayList<>()));
                ArrayList<Integer> temp = primeFactorsMap.get(i);
                temp.add(index);
                primeFactorsMap.put(i, temp);
                number /= i;
            }
        }
        if (number > 2) {
            primeFactorsMap.put(number, primeFactorsMap.getOrDefault(number, new ArrayList<>()));
            ArrayList<Integer> temp = primeFactorsMap.get(number);
            temp.add(index);
            primeFactorsMap.put(number, temp);
        }
    }

    public boolean canTraverseAllPairs(int[] numbers) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> primeFactorsMap = new HashMap<>();

        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            factorizeAndMap(numbers[i], primeFactorsMap, i);
        }

        for (ArrayList<Integer> factors : primeFactorsMap.values()) {
            for (int i = 1; i < factors.size(); i++) {
                adjacencyList.get(factors.get(i - 1)).add(factors.get(i));
                adjacencyList.get(factors.get(i)).add(factors.get(i - 1));
            }
        }
        int[] visited = new int[n];
        depthFirstSearch(adjacencyList, visited, 0);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) return false;
        }
        return true;
    }
}
