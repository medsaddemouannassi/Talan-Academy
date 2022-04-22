package com.bibliotehque;

public interface BUR {
    public void display();
    public default boolean similarity(Object object) {
        if (object.equals(this)) return true;
        return false;
    }
}
