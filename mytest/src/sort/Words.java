package sort;

import java.util.Arrays;

public class Words {

	public static void main(String[] args) {
		int[] array = new int[]{2,4,3,5,1};
		for(int i = 0;i<array.length;i++){
			for(int j = 0;j<array.length-1;j++){
				if(array[j]>array[j+1]){
					int c = array[j];
					array[j] = array[j+1];
					array[j+1] = c;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
