package algorithm.day14;

class Day14 {
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] directions = {'d', 'l', 'r', 'u'};
    int N, M;
    String answer = "impossible";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        N = n;
        M = m;
        
        if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
            return "impossible";
        }
        
        dfs(x - 1, y - 1, r - 1, c - 1, k, new StringBuilder());
        return answer;
    }
    
    private boolean dfs(int x, int y, int r, int c, int k, StringBuilder path) {
        if (x == r && y == c && path.length() == k) {
            answer = path.toString();
            return true;
        }
        
        if (path.length() + Math.abs(x - r) + Math.abs(y - c) > k) {
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            
            path.append(directions[i]);
            if (dfs(nx, ny, r, c, k, path)) {
                return true;  
            }
            path.deleteCharAt(path.length() - 1);  
        }
        
        return false;
    }
}

