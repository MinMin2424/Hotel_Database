package cz.cvut.fel.ts1;

public class Factorial {
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial nemuze byt zaporny");
        }
        if (n==0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
