/*
Problem Description
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
When the devotees come to the temple, they donate some amount of coins to these beggars.
Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars
sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index,
where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

 */
public class AdvDSA_ContinuousSumQueryBegger {
    public static int[] solve(int A, int[][] B) {
        int[] res = new int[A];
        for(int i=0; i<B.length; i++){
            System.out.println(" "+B[i][0]+" "+B[i][1]+" "+B[i][2]);
            for (int j=B[i][0]-1; j<B[i][1]; j++) {
                res[j] += B[i][2];
                System.out.println(" "+res[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]B= {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(solve(5 , B));
    }
}
