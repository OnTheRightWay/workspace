package sort;

public class SelectSort {
	public static void main(String[] args) {
		int [] array={6,5,1,8,9,7,10,5,2,3,6};
		array=selectSort(array);
		for(int i = 0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	public static int[] selectSort(int [] array){
		for(int i = 0;i<array.length;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
