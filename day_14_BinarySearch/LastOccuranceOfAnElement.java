public class LastOccuranceOfAnElement {
    public static int search(int[] arr, int num) {
        int rt = -1;

        int len = arr.length;
        int l = 0;
        int r = len-1;

        while(l < r) {
            // int mid = (l + r)/2;

            int mid = l + (r-l+1)/2;

            if (num >= arr[mid]) {
                l = mid;
            } else {
                r = mid-1;
            }

            System.out.println(String.valueOf(l) + ", " + String.valueOf(mid) + ", " + String.valueOf(r));

        }

        return r;
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 2, 2, 2, 2, 7} ;
        int num = 2;
        int rt = LastOccuranceOfAnElement.search(arr, num);
        System.out.println("the index is " + String.valueOf(rt));
    }
}
