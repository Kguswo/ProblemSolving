class LRUCache {
    class Node{
        int key;
        int value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Node[] node;
    int[] prev; int[] next;
    int head; int tail;
    Map<Integer, Integer> nodeIdx;
    boolean isFull;

    public LRUCache(int c) {
        this.capacity = c;
        this.node = new Node[c];
        this.prev = new int[c];
        this.next = new int[c];
        this.head = -1;
        this.tail = -1;
        this.nodeIdx = new HashMap<>();
        this.isFull = false;
    }
    
    /*
    * key 존재여부 따지기
    * key 있으면 찾은 key를 head로 옮기기 (최신화) - 메서드화
    * key에 해당하는 value를 node배열에서 찾아 리턴
    */
    public int get(int k) {
        if(!nodeIdx.containsKey(k)) return -1;

        int idx = nodeIdx.get(k);
        setHead(idx);

        return node[idx].value;
    }
    
    /*
    * key 존재여부 따지기
    * key **있으면** 찾은 key로 idx찾고 그 idx의 값을 node에서 찾기 - (a)
    * 찾은 value를 변경후 head로 만들기 (최신화)
    * key **없으면** 먼저 사용중인 개수가 capacity만큼 꽉 찼는지 확인, - (b)
    * capacity가 꽉 차지 않았으면 새로운 node추가 후 isFull 갱신
    * capacity가 꽉 찼으면 LRU키(tail) 찾아서 제거, 관계도 제거
    * 이후 맨 앞에 추가, 관계 추가 - 메서드화
    * key에 해당하는 value를 node배열에서 찾아 리턴
    */
    public void put(int k, int v) {
        // (a)
        if(nodeIdx.containsKey(k)){
            int idx = nodeIdx.get(k);
            node[idx].value = v;
            setHead(idx);
            return;
        }

        // (b)
        if(!isFull){
            putNewNode(k, v, nodeIdx.size()); // 이 부분 새로운 인덱스 써야함
            if(nodeIdx.size() == capacity) isFull = true;
        }
        else{
            int LRUkey = node[tail].key;
            nodeIdx.remove(LRUkey);

            int idxToPut = tail;
            if(prev[tail]!=-1) {
                tail = prev[tail];
                next[tail] = -1; 
            }
            else{ // 용량 1이면 head/tail 없으므로 초기화;
                head = -1;
                tail = head;
            }

            putNewNode(k, v, idxToPut);
        }
    }

    /*
    * 맨 앞으로 옮기는 메서드
    * 원래 위치에서의 관계 끊고 맨 앞으로 옮기기
    * 맨 앞의 관계는 prev가 없고 맨 앞(head)가 next.
    */
    private void setHead(int idx){
        if(idx == head) return;
        
        if(idx != tail){
            prev[next[idx]] = prev[idx];
            next[prev[idx]] = next[idx];
        }
        else{
            tail = prev[idx];
            next[tail] = -1;
        }

        prev[head] = idx;
        prev[idx] = -1;
        next[idx] = head;
        
        head = idx;
    }

    /*
    * 새로 추가할 노드를 배열에 추가 후
    * 맨 앞에 관계도 추가, head설정
    */
    private void putNewNode(int k, int v, int idxToPut){
        node[idxToPut] = new Node(k, v);
        nodeIdx.put(k, idxToPut);

        prev[idxToPut] = -1;
        next[idxToPut] = head;
        if(head!=-1) prev[head] = idxToPut; // 용량 1 고려한 조건문
        head = idxToPut;

        if(tail==-1) tail = idxToPut; // 첫원소넣는경우 고려 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */