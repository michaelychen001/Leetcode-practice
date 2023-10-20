public class Q344ReverseString {

    public void reverseString(char[] s) {

        int len = s.length;
        int i = 0;
        int j = len-1;

        while(i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Q344ReverseString sol = new Q344ReverseString();
        sol.reverseString(s);
        for (int i=0; i<s.length; i++) {
            System.out.print(s[i]);
        }
        System.out.println();
    }

}
