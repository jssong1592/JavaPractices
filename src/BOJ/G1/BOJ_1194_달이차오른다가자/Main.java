package BOJ.G1.BOJ_1194_�����������ٰ���;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Point start;

    static class Point {
        int x,y,step,key;

        public Point(int x, int y, int step, int key) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", step=" + step +
                    ", key=" + key +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[64][N][M];


        for (int i=0;i<N;i++){
            String line = br.readLine();
            for (int j=0;j<M;j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j]=='0') {
                    start = new Point(i,j,0,0);
                }
            }
        }

        System.out.println(bfs());


    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();

        q.offer(start);
        visited[0][start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            int key = cur.key;

            //���� ����Ʈ�� ���������� ��
            if (map[x][y]=='1') {
                return step;
            }

            for (int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInRange(nx,ny)&&map[nx][ny]!='#'&&!visited[key][nx][ny]) {
                    if (map[nx][ny]=='.'||map[nx][ny]=='0'||map[nx][ny]=='1') {
                        visited[key][nx][ny] = true;
                        q.offer(new Point(nx, ny, step + 1,key));
                    }
                    //���� ��ġ�� ������
                    //**�ǵ��ư��� ����� ���� ���踦 �Ծ��� ���ۿ� ����.
                    //�׷��Ƿ� ���踦 ������(���������� �ٲ��) newKey �������� �̵��Ͽ� �ǵ��ư� �� �ִ� visited ���
                    else if (map[nx][ny]>='a'&&map[nx][ny]<='f') {
                        int newKey = 1<<(map[nx][ny]-'a');
                        newKey = key | newKey;

                        if (!visited[newKey][nx][ny]) {
                            visited[key][nx][ny] = true;
                            visited[newKey][nx][ny] = true;
                            q.offer(new Point(nx,ny,step+1,newKey));
                        }
                    }
                    //���� ��ġ�� ���̶��
                    else if (map[nx][ny]>='A'&&map[nx][ny]<='F') {
                        int door = 1 << (map[nx][ny]-'A');
                        if ((key&door)>0) {
                            visited[key][nx][ny] = true;
                            q.offer(new Point(nx,ny,step+1, key));
                        }
                    }

                }
            }

        }


        return -1;
    }

    static boolean isInRange(int x,int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
