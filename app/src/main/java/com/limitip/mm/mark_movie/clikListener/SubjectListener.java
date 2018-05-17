package com.limitip.mm.mark_movie.clikListener;

public interface SubjectListener {
    void add(ObserverListener observerListener);
    void notifyObserver(Object object);
    void remove(ObserverListener observerListener);
}
