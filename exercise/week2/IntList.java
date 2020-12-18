public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null)
		    return 1;
		else 
		    return 1 + rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		int size = 1;
		IntList p = rest;
		while(p != null){
		    size ++;
		    p = p.rest;
		}
		return size;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if (i == 0)
		    return first;
		else
		    return rest.get(i-1);
	}

                /** Returns an IntList identical to L, but with
               * each element incremented by x. L is not allowed
               * to change. */
               public static IntList incrList(IntList L, int x) {
		IntList result, pL = L, pR;
		result = new IntList(pL.first + x, null);
		pR = result;
		while (pL.rest != null){
		    pR.rest = new IntList(pL.rest.first + x, null);
		    pL = pL.rest;
		    pR = pR.rest; 
		}
             		return result;        
               }

               /** Returns an IntList identical to L, but with
               * each element incremented by x. Not allowed to use
               * the 'new' keyword. */
               public static IntList dincrList(IntList L, int x) {
		IntList p = L;
		p.first += x;
		while(p.rest != null){
		    p = p.rest;
		    p.first += x;
		}
        		return L;
                }
	
	/** if 2 numbers in a row are the same, 
	* we add them together andmake one large node. 
	* For example: 1→1→2→3 becomes 2→2→3 which becomes 4→3 */
	public void addAdjacent( ){
		IntList pC=this, pR =rest;
		while(pR != null){
			if (pC.first != pR.first){
				pC = pR;
				pR = pR.rest;
			}
			else{
				pC.first *= 2;
				pR = pR.rest;
				pC.rest = pR;
			}
		}
	}

	/**  every time you add a value you “square”the IntList. 
	* For example, upon the insertion of 5, the below IntList would transform from:
	* 1 => 2 to 1 => 1 => 2 => 4 => 5
	* and if 7 was added to the latter IntList, it would become
	* 1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7 */
	public void addSquare(int x){
		IntList p = this, pP=this;
		while( p!= null ){
			p.rest = new IntList(p.first*p.first, p.rest);
			pP = p.rest;
			p = p.rest.rest;
		}
		pP.rest = new IntList(x, null);
	}

	public static void main(String[] args) {
       		IntList L = new IntList(5, null);
        		L.rest = new IntList(7, null);
        		L.rest.rest = new IntList(9, null);

        		System.out.println(L.size());
       		System.out.println(L.iterativeSize());

       		 // Test your answers by uncommenting. Or copy and paste the
        		// code for incrList and dincrList into IntList.java and
        		// run it in the visualizer.
        		System.out.println(L.get(1));
        		System.out.println(incrList(L, 3));
        		System.out.println(dincrList(L, 3));      
		
		IntList temp1 =   new IntList(1, null);
		temp1.rest =   new IntList(1, null);
		temp1.rest.rest =   new IntList(2, null);
		temp1.rest.rest.rest =   new IntList(3, null);
		temp1.addAdjacent( );
		System.out.println(temp1.size());

		IntList temp2 =   new IntList(1, null);
		temp2.rest =   new IntList(2, null);
		temp2.addSquare(5);
		System.out.println(temp2.size());
		temp2.addSquare(7);
		System.out.println(temp2.size());
	}
} 
