import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UnionFind {
    public int[] _nodeCount;
    public int[] _parents;

    // Constructor
    public UnionFind(int N)
    {
        _nodeCount = new int[N];
        Arrays.fill(_nodeCount, 1);
        _parents = new int[N];
        for (int i = 0; i < N; i ++)
        {
            _parents[i] = i;
        }
    }

    // Find the root of the specified node.
    private int rootOf(int nodeId)
    {
        while (_parents[nodeId] != nodeId)
        {
            _parents[nodeId] = _parents[_parents[nodeId]]; // Path compression.
            nodeId = _parents[nodeId];
        }

        return nodeId;
    }

    // Union the tree of the specified two nodes.
    public void union(int nodeId1, int nodeId2)
    {
        int root1 = rootOf(nodeId1);
        int root2 = rootOf(nodeId2);

        if (root1 == root2) return;

        // Flatten the trees
        if (_nodeCount[nodeId1] < _nodeCount[nodeId2])
        {
            _parents[root1] = root2;
            _nodeCount[root2] += _nodeCount[root1];
        }
        else
        {
            _parents[root2] = root1;
            _nodeCount[root1] += _nodeCount[root2];
        }
    }

    // Return the union count.
    public int count()
    {
        Set<Integer> set = new HashSet<>();
        for (int parent: _parents)
        {
            set.add(rootOf(parent));
        }

        return set.size();
    }
}

class Solution {
    
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i ++)
        {
            for (int j = 0; j < M[i].length; j ++)
            {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.count();
    }
}