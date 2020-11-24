public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /**  replaces each element a[i] with the sum of a[i] through a[i + n], 
     *   but only if a[i] is positive valued. If there are not enough values (reach the end of the array), 
     *   we sum only as many values as we have. */
	  int temp, iTop;
	  for(int index = 0; index < a.length-1; index++){
		  if (a[index]>0){
		  	temp = a[index];
		  	if (index+n >= a.length)
				  iTop = a.length;
		  	else
				  iTop = index+n+1;
		  	for (int i = index + 1; i < iTop; i++){
				temp += a[i];
			}
			a[index] = temp;
		}
	}
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
