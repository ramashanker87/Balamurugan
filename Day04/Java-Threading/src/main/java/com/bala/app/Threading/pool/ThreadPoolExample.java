package com.bala.app.Threading.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (int i = 0; i < 14; i++) {
      executor.execute(() -> {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
      });
    }
    executor.shutdown();
  }
}
