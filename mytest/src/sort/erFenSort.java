package sort;

public class erFenSort {
    public static void main(String[] args) {
        int[] a = {5,9,6,4,1,2,3,7,8,0};
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int start = 0;
            int end = i-1;
            int mid = 0;
            while (start<=end){
                mid = (start+end)/2;
                if (a[i]<a[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            for (int j = i-1; j >end ; j--) {
                a[j+1] = a[j];
            }
            a[end+1]=temp;

        }
        for (int i : a) {
            System.out.print(i+"\t");
        }
    }
}
