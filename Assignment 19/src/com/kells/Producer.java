package com.kells;

public class Producer extends Thread {

    private CubbyHole m_cubbyhole;
    private int m_number;

    public Producer(CubbyHole _cubbyhole, int _number) {
        m_cubbyhole = _cubbyhole;
        m_number = _number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; ++i) {
            m_cubbyhole.put(i);
            System.out.println("Producer #" + m_number + " put: " + i);
            try{
                sleep((int)Math.random() * 100);
            }
            catch(InterruptedException e) {
                System.err.println("InterruptedException caught in class Producer" + e.getLocalizedMessage());
            }
        }
    }

}
