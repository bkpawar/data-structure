public class SubSeq_SumOfSubArrayWithOr {
    public static int SubSeq_SumOfSubArrayWithOr(int[] A) {
        int n=A.length;
        int[] idx=new int[32];
        for(int i=0;i<32;i++){
            idx[i]=-1;
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long temp=A[i];
            for(int j=0;j<=31;j++){
                long power=1<<j;   //1*(2^j)
                if((temp & power)!=0){ // if jth bit is set
                    ans+=power*(i+1);
                    idx[j]=i; // store the index for next elements
                }
                else if(idx[j]!=-1){
                    ans+=power* (idx[j]+1);
                }
            }
        }
        long mod=1000*1000*1000+7;
        ans=ans%mod;
        return (int)ans;
    }

    public static void main(String[] args) {
        int[]A=new int[5];
        A[0] = 1; A[1] =2; A[2] = 3; A[3]=4; A[4]=5;
        System.out.println(SubSeq_SumOfSubArrayWithOr(A));
    }
}
