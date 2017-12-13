package sort;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int [] array ={8,9,6,0,7,5,3,1,4,2};
		
		for(int i=1;i<array.length;i++){
			if(array[i]<array[i-1]){
				int temp = array[i];
				int m = i;
				for(int j = m-1; j>=0 && array[j]>temp;j--){
					array[j+1] = array[j];
					m--;
				}
				array[m] = temp;
			}
		}
		System.out.println(Arrays.toString(array));
	}

}

