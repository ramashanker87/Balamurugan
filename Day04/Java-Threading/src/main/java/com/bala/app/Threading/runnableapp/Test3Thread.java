package com.bala.app.Threading.runnableapp;

public class Test3Thread  implements Runnable {
  public void run() {
    System.out.println("Thread3 is running...");
    System.out.println(Thread.currentThread().getName());
  }
}
