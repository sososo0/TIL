package algorithm.day32;

class Day32 {
    
    int n;
    String[] trees;
    
    public int[] solution(long[] numbers) {
        
        n = numbers.length;
        trees = new String[n]; 
        int[] answer = new int[n];
        
        makeTree(numbers);
        
        for (int i = 0; i < n; i++) {
            answer[i] = isBinaryTree(trees[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private void makeTree(long[] numbers) {
        
        for (int i = 0; i < n; i++) {
            String binaryNum = Long.toBinaryString(numbers[i]);
            int depth = getDepth(binaryNum);
            String fullBinaryTree = makeFullTree(binaryNum, depth);
            
            trees[i] = fullBinaryTree;
        }
    }
    
    private int getDepth(String binaryNum) {
        int bLen = binaryNum.length();
        return (int) Math.ceil(Math.log(bLen+1)/Math.log(2));
    }
    
    private String makeFullTree(String binaryNum, int depth) {
        int paddingLen = ((1 << depth) - 1) - binaryNum.length();
        if (paddingLen > 0) {
            return "0".repeat(paddingLen) + binaryNum;
        }
        return binaryNum;
    }
    
    private boolean isBinaryTree(String tree) {
        int n = tree.length();
        
        return isValidSubTree(tree, 0, n-1);
    }
    
    private boolean isValidSubTree(String tree, int start, int end) {
        if (start > end) {
            return true;
        }
        
        int mid = (start + end) / 2;
        char root = tree.charAt(mid);
        if (root == '0') {
            for (int i = start; i <= end; i++) {
                if (tree.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        }
        
        return isValidSubTree(tree, start, mid-1) && isValidSubTree(tree, mid + 1, end);
    }
}
