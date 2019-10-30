package com.company;

public class Pra1 {
    public static void main(String[] args) {
        UseComputer use = new UseComputer();
        // 参数除了可以填写Compute这个接口，还能填写Compute这个接口的实现类
        use.useComputer(new jia(),1,2);
        use.useComputer(new jian(),2,1);
        use.useComputer(new cheng(),1,4);
        use.useComputer(new chu(),3,2);
    }
}

interface Compute{
    int computer(int n,int m);
}

class jia implements Compute{

    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}

class jian implements Compute{

    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class cheng implements Compute{

    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}

class chu implements Compute{

    @Override
    public int computer(int n, int m) {
        if(m == 0)
            return n;
        else
            return n/m;
    }
}

class UseComputer{
    void useComputer(Compute compute, int n, int m){
        int result = compute.computer(n,m);
        System.out.println(result);
    }
}