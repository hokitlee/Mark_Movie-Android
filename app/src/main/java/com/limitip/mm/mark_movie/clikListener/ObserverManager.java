package com.limitip.mm.mark_movie.clikListener;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager implements SubjectListener {
    private static ObserverManager observerManager;
    //观察者接口集合
    private List<ObserverListener> list = new ArrayList<>();

    /**
     * 单例
     */
    public static ObserverManager getInstance() {
        if (null == observerManager) {
            synchronized (ObserverManager.class) {
                if (null == observerManager) {
                    observerManager = new ObserverManager();
                }
            }
        }
        return observerManager;
    }

    /**
     * 加入监听队列
     */
    @Override
    public void add(ObserverListener observerListener) {
        list.add(observerListener);
    }

    /**
     * 通知观察者刷新数据
     */
    @Override
    public void notifyObserver(Object object) {
//        int index = list.indexOf(observerListener);
//        list.get(index).observerUpData(object);
        for (ObserverListener  Iterative: list) {
//            if(Iterative == observerListener)
            Iterative.observerUpData(object);
        }
    }

    /**
     * 监听队列中移除
     */
    @Override
    public void remove(ObserverListener observerListener) {
        if (list.contains(observerListener)) {
            list.remove(observerListener);
        }
    }
}