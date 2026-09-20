public void union(int p, int q) {
    for (int i = 0; i < leader.length; i++) {
        if (leader[i] == leader[p]) {
            leader[i] = leader[q];
        }
    }
}
/*
cho leader = [0,1,2]
khi thực hiện union(0,1) thì leader = [1,1,2]
khi thực hiện union(0,2) thì leader = [2,1,2]
tuy nhiên find (0) sẽ trả về 2, find(1) sẽ trả về 1, find(2) sẽ trả về 2
mà union(0,1) và union(0,2) thì 0 và 1, 0 và 2 đều là cùng một tập hợp
vậy nên test case union(0,1) và union(0,2) sẽ trả về false
 */