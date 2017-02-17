# Problem:

Make a program/function that takes 3 inputs:

- `paths`
- `start`
- `end`

And returns the shortest path of nodes in an array, which follows Dijkstra's algorithm.

## Definitions of inputs & outputs:

### `path`:

`path` is an array of length-3 arrays, which are individual paths. Each path is formatted like so:

    start_node end_node distance
    
For example, if a path is `[2, 3, 5]`, it means that from node `2` to node `3`, the distance between those two nodes is `5`.

So your full `path` might look something like this:

    [[2, 3, 5], [1, 4, 6], [2, 4, 1]...]

### `start` and `end`:

`start` and `end` are both integers, indicating the starting node and the ending node.

### Output:

Your output must be a valid path of nodes, indicated by an array of integers, like so:

    [1, 4, 3, 5]
    
The above output indicates that starting from node `1`, the shortest path goes from `1` to node `4`, then `3`, and finally ends on `5` (it also indicates the the starting node is `1` and the ending node is `5`).
