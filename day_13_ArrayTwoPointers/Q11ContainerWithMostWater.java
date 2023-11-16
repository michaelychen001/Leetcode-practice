public class Q11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;

        int i = 0;
        int j = len-1;

        int maxArea = 0;
        while(i < j) {
            int tmpArea = Math.min(height[i], height[j]) * (j - i);
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            } else {
                if (height[i] <= height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7} ;
        Q11ContainerWithMostWater sol = new Q11ContainerWithMostWater();
        System.out.println(sol.maxArea(height));
    }
}
