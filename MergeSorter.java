package mergesort;

import java.util.Arrays;
import java.util.Random;

public class MergeSorter {
public int[]a;
//constructor that takes one argument which is an array
public MergeSorter(int[]a)
{
	this.a = a;


}
// returns a merge sorted array
public int[] mergeSort()
{
	sortRecurse(this.a);
	return this.a;
}
//splits an array into two and then sorts them using recursion and then merges them back together into one array
private int[] sortRecurse(int[]a)
{
	if(a.length<=1)
		return a;
		
	//split into two arrays
	int[] left = new int[a.length/2];
	int[] right = new int[a.length - left.length];
	for(int i=0; i < left.length; i++ )
	{
		left[i] =a[i];
	}
	for(int i=0; i < right.length; i++ )
	{
		right[i] =a[left.length + i];
	}
	
	sortRecurse(left);
	sortRecurse(right);
	
	merge(left,right, a);
	return a;
	
}
// merges the two split arrays and sorts them
public void merge(int[] left, int[] right, int[] a)
{
	
	int indexL = 0; int indexR = 0; 
	
	for(int aIndex= 0; aIndex < a.length; aIndex++)
	{
		boolean nextIsL = (indexL < left.length) 
			&& ((indexR < right.length && left[indexL] < right[indexR])
				|| (indexR == right.length));

		if(nextIsL)
		{ // adds R index to array and increases indexR
		a[aIndex] = left[indexL];
		indexL++;
		}	
	else
	{   // adds L index to array and increases indexL
		a[aIndex] = right[indexR];
		indexR++;}
	}

	
	
	
	
	
}
// tester
public static void main(String[]args)
{
	Random gen = new Random(1066777);
	int[]Array ={ gen.nextInt(100), gen.nextInt(100), gen.nextInt(100), 
			gen.nextInt(100), gen.nextInt(100), gen.nextInt(100) };
	
	MergeSorter tester = new MergeSorter(Array);
	tester.mergeSort();
	System.out.println(Arrays.toString(tester.mergeSort()));
}
}