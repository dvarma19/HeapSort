
public class HeapSort {

	public static void main(String[] args) {
		
		int[] arr = {23,7,8,12,2,18}; //unsorted array
		int len = arr.length;
		System.out.println("Input Array:");
		print(arr);
		System.out.println("\nSorting in Ascending Order:");

		while(len > 0)
		{
			buildMinHeap(arr, len);
			System.out.print(removeTop(arr, len - 1) + "\t");
			len--;
		}//while ends
		
		len = arr.length;
		System.out.println("\nSorting in Descending Order:");
		while(len > 0)
		{
			buildMaxHeap(arr, len);
			System.out.print(removeTop(arr, len - 1) + "\t");
			len--;
		}//while ends
		
	} // main ends
	
	public static int removeTop(int[] arr, int len)
	{
		int del = arr[0];
		//swap with last element
		int temp = arr[0];
		arr[0] = arr[len];
		arr[len] = temp;
		
		return del;
	}//removeTop ends
	
	public static void buildMinHeap(int[] arr, int len)
	{
		boolean swapFlag = true;
		for(int i = len/2 - 1; i >= 0; i--)
		{
			swapFlag = true;
			minHeapify(arr, i, len-1, swapFlag);
		}		
	}// buildMinHeap

	public static void minHeapify(int[] arr, int i, int n, boolean swapFlag)
	{
		if(swapFlag == true)
		{
			swapFlag = false;
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int smallest = i;
			if(left <= n && arr[left] < arr[i])
				smallest = left;
			if(right <= n && arr[right] < arr[i])
			{
				if(arr[right] < arr[smallest])// case applicable when both the children are smaller than parent
					smallest = right;
			}
			if(smallest != i)
			{
				//swap
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;
				swapFlag = true;
			}
			minHeapify(arr, smallest, n, swapFlag);
		}
	}// minHeapify ends
	
	public static void buildMaxHeap(int[] arr, int len)
	{
		boolean swapFlag = true;
		for(int i = len/2 - 1; i >= 0; i--)
		{
			swapFlag = true;
			maxHeapify(arr, i, len-1, swapFlag);
		}		
	}// buildMaxHeap

	public static void maxHeapify(int[] arr, int i, int n, boolean swapFlag)
	{
		if(swapFlag == true)
		{
			swapFlag = false;
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int smallest = i;
			if(left <= n && arr[left] > arr[i])
				smallest = left;
			if(right <= n && arr[right] > arr[i])
			{
				if(arr[right] > arr[smallest])// case applicable when both the children are greater than parent
					smallest = right;
			}
			if(smallest != i)
			{
				//swap
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;
				swapFlag = true;
			}
			maxHeapify(arr, smallest, n, swapFlag);
		}
	}// maxHeapify ends

	public static void print(int[] arr)
	{
		for(int n: arr)
		{
			System.out.print(n + "\t");
		}
	}// print ends 

}// class HeapSort ends
