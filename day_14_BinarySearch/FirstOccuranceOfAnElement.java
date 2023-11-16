public class FirstOccuranceOfAnElement {
    public static int search(int[] arr, int num) {
        int rt = -1;

        int len = arr.length;
        int l = 0;
        int r = len-1;

        while(l < r) {
            int mid = l + (r - l)/2;
            if (num <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 2, 2, 2, 6, 7} ;
        int num = 2;
        int rt = FirstOccuranceOfAnElement.search(arr, num);
        System.out.println("the index is " + String.valueOf(rt));
    }
}
