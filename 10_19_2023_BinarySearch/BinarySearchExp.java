public class BinarySearchExp {
    public static int search(int[] arr, int num) {
        int rt = -1;

        int len = arr.length;
        int l = 0;
        int r = len-1;

        while(l < r) {
            int mid = l + (r - l)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 2, 2, 2, 6, 7} ;
        int num = 2;
        int rt = BinarySearchExp.search(arr, num);
        System.out.println("the index is " + String.valueOf(rt));
    }
}
