#include <string>
#include <vector>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    priority_queue<int> pq;
    for(int w : works) pq.push(w);
    
    while(n-->0 && !pq.empty()){
        int tmp = pq.top();
        pq.pop();
        if(tmp>0) pq.push(--tmp);
    }
    
    long long res = 0;
    while(!pq.empty()){
        long long num = pq.top();
        res += num * num;
        pq.pop();
    }
    return res;
}