public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int index = 1, maxM = m[0];
	while(index < m.length){
		if(m[index] > maxM){
			maxM = m[index];
		}
		index++;
	}
	return maxM;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
    }
}
