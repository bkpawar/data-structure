/*
File: day34_advDSA_modularArithmatic.java

    Q1.--> Given an integer N, count #of tailing 0's in N!
N = 1, 2 ,3, 4, 5, 6, 7, 8, 9
Fact = 1 ,2, 6, 24, 120, 720, 5040, 40320, 362880
Tailing 0's = 0, 0 , 0, 0 , 1, 1, 1, 1, 1

soln: ans = multiples of 5 +
            multiples of 25 +
            multiples of 125 +

            multiples of 5^k from 1 to N (5^(K+1) > N) => k = long5N
code:
     ans = 0
     for (x = 5; x <= N; x = x*5)
        ans += N/x;
     return ans;
Tc = longN, base of x
Sc: O(1)
------------------------------------------------------------------------------
Q2.-->
    A%B = reminder when A/B
        = repeated subtraction of B from A
        = number at jump of B are equal under %B  1%4 == 5%4
    X%1 = 0
    X%X = 0
    if x<y then x%y=x  4 %10 = 4
    Properties of modulo:
    1. (a+b)%m = (a % m + b % m) %m
    2. (a*b)%m = (a%m * b%m)%m   ,, this can help to avoid overflow
    3. (a-b)%m = (a%m - b%m +m)%m (a = 17, b = 8, m = 5), +m to avoid -ve sign
    4. (a^b)%m = (a % m)^b %m
    5. (a/b)%m = (a%m * (b^-1)%m)%m (inverse mod of b wrt m

Optimal code;
fast power
    int fastPower(a, b, m) // a^b % m
        if (b == 0)
            return 1;
        if (b%2 == 0)
            return fastPower(a*a%m, b/2, m)
        else
            return ((a * fastPower(a*a%m, b/2, m))%m)
    Tc: O(log(b))

--> write above algorithm in iterative code
------------------------------------------------------------------------------
Fermat's Theoram -> a ^ (p-1) ~ 1 mod(p) [p shall be prime no]

Fermat's theorem has many important applications in number theory, such as in the field of cryptography,
where it is used in the creation of public-key encryption systems. It also has applications in primality testing,
which is the process of determining whether a number is a prime number or not.

Q3. --> 3^1002 % 11 = 3^(1002%10)%11

Q4. Given an integer array A[] & an integer M. find the count of pairs (i, j) sothat (A[i]+A[j] )%m = 0
A= [1, 4, 3, 8]
M = 3
1+8 % 3 = 0
4+8 % 3 = 0
ans = 2

BruteForce: for every i and j, check if A[i]+A[j] %m == 0, Tc= O(N^2) Sc = O(1)
*/

public class day34_advDSA_modularArithmatic {
 /*
problem1: Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
        -1 mod B is also known as modular multiplicative inverse of A under modulo B.
         A = 3, B = 5
          Let's say A-1 mod B = X, then (A * X) % B = 1.
          3 * 2 = 6, 6 % 5 = 1.
 */
    public static int getModInverseMethodN(int A, int B){
        // Tc: O(N) Sc: 1
        int ans = 0;
        for (int i = 1; i<B; i++){
            if (( A%B *i%B)%B == 1){
                ans = i;
                System.out.println(+ans);
                break;
            }
        }
        return ans;
    }
    /*
    problem2: based on Q1
    Given an integer A, return the number of trailing zeroes in A! i.e., factorial of A.
    Note: Your solution should run in logarithmic time complexity.
     */
    public static int trailingZeroes(int A) {
        int ans = 0;
        for (int i = 5; i<=A; i = i*5) {
            ans += A/i;
        }
        return ans;
    }
public static void main(String[] args) {
        //System.out.println("day34_advDSA_modularArithmetic:"+getModInverseMethodN(3, 5));
        System.out.println("day34_advDSA_modularArithmetic:"+trailingZeroes(5));
    }
}
