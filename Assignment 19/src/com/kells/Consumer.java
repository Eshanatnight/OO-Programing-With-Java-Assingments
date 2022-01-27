package com.kells;

public class Consumer extends Thread {

    private CubbyHole m_cubbyhole;
    private int m_number;


    public Consumer(CubbyHole _cubbyhole, int _number) {
        m_cubbyhole = _cubbyhole;
        m_number = _number;
    }

    @Override
    public void run() {
        int value = 0;
        for(int i = 0; i < 10; ++i) {
            value = m_cubbyhole.get();
            System.out.println("Consumer #" + m_number + " got: " + value);
        }
    }

}
