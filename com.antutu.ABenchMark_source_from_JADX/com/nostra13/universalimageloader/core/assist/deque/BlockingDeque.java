package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    boolean add(E e);

    void addFirst(E e);

    void addLast(E e);

    boolean contains(Object obj);

    E element();

    Iterator<E> iterator();

    boolean offer(E e);

    boolean offer(E e, long j, TimeUnit timeUnit);

    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit);

    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit);

    E peek();

    E poll();

    E poll(long j, TimeUnit timeUnit);

    E pollFirst(long j, TimeUnit timeUnit);

    E pollLast(long j, TimeUnit timeUnit);

    void push(E e);

    void put(E e);

    void putFirst(E e);

    void putLast(E e);

    E remove();

    boolean remove(Object obj);

    boolean removeFirstOccurrence(Object obj);

    boolean removeLastOccurrence(Object obj);

    int size();

    E take();

    E takeFirst();

    E takeLast();
}
