package com.bala.app.Threading.synchron;

public class CounterThread extends Thread{
  private Counter counter;
  public CounterThread(Counter counter) {
    this.counter = counter;
  }
  public void run() {
    for (int i = 0; i < 10; i++) {
      counter.increment();
    }
  }
}
