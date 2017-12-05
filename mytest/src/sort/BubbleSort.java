package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int [] array={6,5,1,8,9,7,10,5,2,3,6};
		array=bubbleSort(array);
		for(int i = 0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	public static int[] bubbleSort(int [] array){
		for(int j = 0; j<array.length;j++)
		for(int i = 0;i<array.length-1-j;i++){
			if(array[i]>array[i+1]){
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		return array;
	}
}
