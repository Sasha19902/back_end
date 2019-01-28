package com.aleksander.threads;

public class ThreadExecutor {

    public void showAccountFilling(long millis) {
        Account account = new Account(0);
        Thread thread1 = new Thread(()-> {
            final int balanceAdd = 10;
            System.out.println("Thread 1 started work");
            try {
                while (!Thread.interrupted()) {
                    account.addToBalance(balanceAdd);
                }
            } catch (Exception e) {
                System.out.println("i'm die");
            }
        });

        Thread thread2 = new Thread(()-> {
            final int balanceAdd = 20;
            System.out.println("Thread 2 started work");
            try {
                while (!Thread.interrupted()) {
                    account.addToBalance(balanceAdd);
                }
            } catch (Exception e) {
                System.out.println("i'm die");
            }
        });

        Thread thread3 = new Thread(()-> {
            final int balanceAdd = 30;
            System.out.println("Thread 3 started work");
            try {
                while (!Thread.interrupted()) {
                    account.addToBalance(balanceAdd);
                }
            } catch (Exception e) {
                System.out.println("i'm die");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account);


    }
}
