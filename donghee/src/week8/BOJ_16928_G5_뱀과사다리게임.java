package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_G5_뱀과사다리게임 {
	
	static int map[],N,M, stair[], snake[],result;
	static Queue<int[]> que;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		stair = new int[100];
		snake = new int[100];
		map = new int[107];
		visited= new boolean[107];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			stair[from]=to;
			map[from] = 1;
		}
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			snake[from]=to;
			map[from] = 2;
		}// end of reading
		
		start();
		
		System.out.println(result);
		
	}
	private static void start() {
		que= new LinkedList<int[]>();
		
		//위치, 주사위 굴린 횟수, 
		que.offer(new int[] {1,0});
		visited[1]=true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int dist= cur[0];
			int cnt = cur[1];
			if(dist>=100) {
				result= cnt;
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				int ndist = dist + i;
				if(visited[ndist])continue;
				
				if(map[ndist]==0) {
					que.offer(new int [] {ndist,cnt+1});
					visited[ndist]=true;
				}else {
					if(map[ndist]==1) {
						que.offer(new int [] {stair[ndist],cnt +1});
						visited[stair[ndist]] = true;
					}else {
						que.offer(new int [] {snake[ndist],cnt +1});
						visited[snake[ndist]]=true;
					}
				}
			}
			
		}
	}

}
