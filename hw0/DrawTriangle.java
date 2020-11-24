public class ClassNameHere {
    public static void drawTriangle(int N) {
          int row,col;
          String colS;
          for  (row=1; row<N+1; row++){
               colS = "";
               for  (col=0; col<row; col++){
                    colS+="*";
                }
                System.out.println(colS);
           }
     }

     public static void main(String[] args) {
           drawTriangle(10);
     }
}