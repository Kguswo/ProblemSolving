# [Ruby V] 보물찾기 - 1868 

[문제 링크](https://www.acmicpc.net/problem/1868) 

### 성능 요약

메모리: 34856 KB, 시간: 300 ms

### 분류

다이나믹 프로그래밍, 트리에서의 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 그리디 알고리즘, 트리

### 제출 일자

2025년 1월 23일 01:37:28

### 문제 설명

<p>n개의 방으로 이루어진 미로가 있다. 이 미로 내의 임의의 두 방 사이에는 반드시 하나의 경로가 존재하고, 그 경로는 유일하다.</p>

<p>이 방들 중 한 방에는 김주성 조교가 보물을 숨겨 놓았는데, 김진영 조교는 이 보물을 찾길 원한다. 그러기 위해서, 김진영 조교는 김주성 조교에게 특정한 방에 보물이 있는지 물어 본다. 친절한 김주성 조교는 김진영 조교가 옳은 방을 골랐으면 그렇다고 말해 주고, 옳은 방을 고르지 않았다면 그 방에 연결된 복도 중 어느 복도를 따라 가야만 보물을 찾을 수 있는지 말해 준다.</p>

<p>여러분이 할 일은 미로의 구조가 주어졌을 때 김진영 조교가 최악의 경우에 몇 번의 질문을 던져야 하는지 계산해 내는 것이다. 물론, 영리한 김진영 조교는 항상 최선의 질문을 한다.</p>

### 입력 

 <p>첫째 줄에 n이 주어진다. (1 ≤ n ≤ 50,000) 이후 n-1개의 줄에는 각각 두 개의 숫자가 주어진다. a와 b가 주어졌다면, a번 방과 b번 방 사이에 복도가 있어 왕래할 수 있다는 의미이다. 방의 번호는 1번부터 n번까지 연속해서 붙어 있다.</p>

### 출력 

 <p>첫 줄에 김진영 조교가 최선을 다하더라도, 최악의 경우 몇 번의 질문을 던져야 하는지 출력한다.</p>

