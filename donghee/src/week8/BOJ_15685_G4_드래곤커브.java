package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_G4_드래곤커브 {
	
	static int N,map[][],result;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(st.nextToken());
			int g= Integer.parseInt(st.nextToken());
			
			goDragon(x,y,d,g);
		}
		
		check();
		
		System.out.println(result);
	}
	
	//정사각형 개수 세기
	private static void check() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) {
					if(map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1)result++;
				}
			}
		}
	}


	//드래곤 만들기
	private static void goDragon(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(d);
		
		for (int i = 0; i < g; i++) {
			for (int j = list.size()-1; j >=0; j--) {
				list.add((list.get(j)+1)%4);
			}
		}
		
		map[y][x]=1;
		for(int n : list) {
			y += dr[n];
			x += dc[n];
			map[y][x]=1;
		}
	}

}
