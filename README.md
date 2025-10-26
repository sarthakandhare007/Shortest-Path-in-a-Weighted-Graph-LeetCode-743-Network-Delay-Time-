# Shortest-Path-in-a-Weighted-Graph-LeetCode-743-Network-Delay-Time-
🧩 Problem Statement:

You are given:

times[i] = (u, v, w) meaning u → v takes w time.

n nodes labeled 1…n

A starting node k


Return the time it takes for all nodes to receive the signal.
If any node cannot be reached, return -1.


---

🔹 Example:

Input:
times = [[2,1,1],[2,3,1],[3,4,1]]
n = 4, k = 2

Output: 2

Explanation:
2 -> 1 takes 1
2 -> 3 -> 4 takes 1 + 1 = 2


---

💡 Approach:

Use Dijkstra’s algorithm:

Graph represented as adjacency list

Min-heap to get the nearest node first

Track minimum time to reach each node


✅ Output:

Output: 2


---

⚙️ Complexity:

Type	Complexity

Time	O(E log V)
Space	O(V + E)



---

✨ Key Concepts Learned:

✅ Graph Representation
✅ Min-Heap (PriorityQueue)
✅ Single-source shortest path
✅ Signal reachability

