#include <stdio.h>
#pragma warning(disable:4996)
#include <queue>
#include <algorithm>
using namespace std;
#include <vector>
int par[10101010];
struct Edge {
	int st;
	int to;
	int cost;
	Edge(int st, int to, int cost) : st(st), to(to), cost(cost) {
	}
	bool operator < (const Edge&other) const {
		return cost > other.cost;
	}
};
int find(int x)
{
	if (par[x] == x)
	{
		return x;
	}
	return par[x] = find(par[x]);
}
void uni(int x, int y)
{
	int a = find(x);
	int b = find(y);
	if (b > a)
	{
		swap(a, b);
	}
	par[b] = a;
}
int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	priority_queue <Edge> q;
	for (int i = 0; i < m; i++)
	{
		int x,  y,  co;
		scanf("%d %d %d", &x, &y, &co);
		q.push(Edge(x, y, co));
	}
	for (int i = 1; i <= n; i++)
	{
		par[i] = i;
	}
	int res = 0;
	while (!q.empty())
	{
		auto p = q.top();
		q.pop();
		int x1 = find(p.st);
		int y1 = find(p.to);
		if (x1 == y1)
		{
			continue;
		}
		uni(p.st, p.to);
		res += p.cost;
	}
	printf("%d", res);
}