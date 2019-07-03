package com.mypack;

public class Test06 {
    public static void main(String[] args) {
        Fatorial localFatorial = new Fatorial();
        System.out.println("3! = " + localFatorial.factorial(3));
    }
}

interface FactorialImp {
    // 计算阶乘n!的值
    long factorial(int n);
}

abstract class FactorialAbs implements FactorialImp {

    public long factorial(int n) {
        return multiplicationCount(n, n - 1);
    }

    abstract long multiplicationCount(long param1Int, long param2Int);

}

class Fatorial extends FactorialAbs {


    @Override
    long multiplicationCount(long param1Int, long param2Int) {
        if (param2Int == 1) {
            return param1Int;
        } else {
            return multiplicationCount(param1Int * param2Int, param2Int - 1);
        }

    }

}
