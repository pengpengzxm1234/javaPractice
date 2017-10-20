package com.main;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by px on 2017/4/12.
 */
public class Message implements Delayed {

    private int id;
    private String body;//消息内容
    private long exceteTime;//执行时间

    public Message(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.exceteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {

        return timeUnit.convert(this.exceteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        Message msg = (Message)delayed;
        return Integer.valueOf(this.id)>Integer.valueOf(msg.id)?1:( Integer.valueOf(this.id)<Integer.valueOf(msg.id)?-1:0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getExceteTime() {
        return exceteTime;
    }

    public void setExceteTime(long exceteTime) {
        this.exceteTime = exceteTime;
    }
}
