package com.kells;

// Generic Node Data Structure to store the data
class Node<T>
{
    // Data Field
    T m_data;

    // Pointer Field
    Node<T> m_next;

    Node(T _data)
    {
        this.m_data = _data;
        this.m_next = null;
    }
}

// Generic Linked List Data Structure
public class List<T>
{
    // Data Field
    private Node<T> m_head;
    private int m_length = 0;

    // Explicit Constructor
    public List()
    {
        this.m_head = null;
    }

    // push an element to the end of the list
    public void push_back(T _data)
    {
        Node<T> node = new Node<T>(_data);

        if(this.m_head == null)
        {
            this.m_head = node;
        }

        else
        {
            // A temporary node to traverse the list
            Node<T> temp = this.m_head;

            while(temp.m_next != null)
            {
                temp = temp.m_next;
            }

            temp.m_next = node;
        }

        ++(this.m_length);
    }

    // push an element to a given index
    public void add_at(int _index, T _data)
    {
        if(_index > this.m_length + 1)
        {
            System.out.println("Index out of bound");
            return;
        }

        if(_index == 1)
        {
            var temp = this.m_head;
            this.m_head = new Node<T>(_data);

            this.m_head.m_next = temp;
            return;
        }

        // Temporary node to traverse the list
        var temp = this.m_head;

        // Temporary node to store the previous node
        var prev =  new Node<T>(null);

        // Iterate till the index
        while(_index > 1)
        {
            prev = temp;

            // move to the next node
            temp = temp.m_next;

            --_index;

        }

        // prev node needs to point to the new value
        prev.m_next = new Node<T>(_data);

        // new value needs to point to the former current node
        prev.m_next.m_next = temp;
    }

    // remove a node which stores the key value passed.
    // Note: this function is inefficient and can be modified to be more efficient
    // but for the sake of simplicity, it is kept as is also I don't want to
    // bother with efficiency for this assignment. SORRY :)
    public void remove(T key)
    {
        // dummy node with null data field
        var prev = new Node<T>(null);

        // dummy node to point to the head
        prev.m_next = this.m_head;

        // next node need to point ahead of the current node
        var next = this.m_head.m_next;

        // Flag to check is the key is found
        boolean exists = false;

        // If the key is at the head
        if(this.m_head.m_data == key)
        {
            this.m_head = this.m_head.m_next;

            exists = true;      // Nodes that needs to be removed exists
        }

        // iterate the list
        var temp = this.m_head;

        // Iterate the list
        while(temp.m_next != null)
        {
            /*
                Since this is a generic data structure, we check the data field
                of the node by type casting it to a String value and comparing
                it with the type cast key value
            */
            if(String.valueOf(temp.m_data).equals(String.valueOf(key)))
            {
                prev.m_next = next;
                exists = true;
                break;
            }

            prev = temp;
            temp = temp.m_next;
            next = temp.m_next;
        }

        // Check the last node with the given key
        if(!exists && String.valueOf(temp.m_data).equals(String.valueOf(key)))
        {
            // If the key is found, the last node needs to point to null
            prev.m_next = null;

            exists = true;    // Nodes that needs to be removed exists
        }

        if(exists)
        {
            // Length of the list needs to be decremented
           --this.m_length;
        }

        else   // If the key is not found
        {
            System.err.println("Key not found");
        }
    }

    // Clear the list
    public void clear()
    {
        this.m_head = null;
        this.m_length = 0;

        // and let the garbage collector take care of the rest
    }

    // check if the list is empty or not
    public boolean is_empty()
    {
        return this.m_head == null;
    }

    // get the size of the list
    public int size()
    {
        return this.m_length;
    }


    // print the list in an iterative way showing one node at a time
    public void print()
    {
        Node<T> node = this.m_head;
        while (node != null)
        {
            System.out.println(node.m_data);
            node = node.m_next;
        }
    }

    // prints the list in a recursive way showing the data value of every node
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = this.m_head;
        while (node != null)
        {
            sb.append(node.m_data);
            if (node.m_next != null)
            {
                sb.append(", ");
            }
            node = node.m_next;
        }
        sb.append("]");
        return sb.toString();
    }

    // get the data at the index passed, this just iterates the list till the index
    // is reached and returns the data value. So, this is quite inefficient.
    // But, I don't want to bother with efficiency for this assignment. SORRY :)
    public T at(int index)
    {
        // dummy node to point to the head
        var temp = this.m_head;

        // Iterate till the index
        while(index > 1)
        {
            temp = temp.m_next;

            --index;
        }

        return temp.m_data;
    }
}