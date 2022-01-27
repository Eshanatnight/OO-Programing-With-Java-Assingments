package com.kells;

public class CubbyHole {

    private int m_contents;
    private boolean m_available = false;

    /*
        * The get() method waits until there's something available in the cubbyhole.
        * It then returns the contents of the cubbyhole.
    */
    public synchronized int get() {
        while(m_available == false) {
            try {
                wait();
            }

            catch (InterruptedException e) {
                System.err.println("InterruptedException caught in class CubbyHole" + e.getLocalizedMessage());
            }
        }

        m_available = false;
        notifyAll();

        return m_contents;
    }

    /*
        * The put() method puts an integer into the cubbyhole.
        * It waits until there's nothing in the cubbyhole.
    */
    public synchronized void put(int value) {
        while(m_available == true) {
            try {
                wait();
            }

            catch (InterruptedException e) {
                System.err.println("InterruptedException caught in class CubbyHole" + e.getLocalizedMessage());
            }
        }

        m_contents = value;
        m_available = true;
        notifyAll();
    }
}
