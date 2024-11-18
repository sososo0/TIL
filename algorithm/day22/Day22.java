package algorithm.day22;

class Day22 {
    public int solution(int n, int[] tops) {
        int[] a = new int[n+1];
        int[] b = new int[n+1];

        a[1] = 1;
        b[1] = tops[0] == 1 ? 3 : 2;

        for (int i = 2; i <= n; i++) {
            a[i] = (a[i-1] + b[i-1])%10007;
            b[i] = tops[i-1] == 1 ? (a[i-1]*2 + b[i-1]*3)%10007 : (a[i-1] + b[i-1]*2)%10007;
        }

        return (a[n] + b[n])%10007;
    }
}
