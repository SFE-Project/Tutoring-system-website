package localpackage;

public class BasicServe {
    public String[] StringIntoArray(String Str){
        String StrArray[]=Str.split(", ");
        return StrArray;
    }
    public int MatchON(String[] A,String[] B){
        int lengthA=A.length;
        int lengthB=B.length;
        for(int i=0;i<lengthA;i++){
            for(int j=0;j<lengthB;j++){
                if(A[i].equals(B[j])){
                    return 1;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        BasicServe basicServe=new BasicServe();

    }

}
