import java.util.concurrent.Semaphore;
public class ReaderWriterProblem {
	 static Semaphore rl = new Semaphore(1,true);
	    static Semaphore wl = new Semaphore(1,true);
	    static int readCount = 0;

	    static class Read extends Thread {
	        @Override
	        public void run() {
	            try {
	               
	                rl.acquire();
	                readCount++;
	                if (readCount == 1) {
	                    wl.acquire();
	                }
	                rl.release();

	                
	                System.out.println(Thread.currentThread().getName() + " is READING");
	                Thread.sleep(1000);
	                System.out.println(Thread.currentThread().getName() + " has FINISHED READING");

	                
	                rl.acquire();
	                readCount--;
	                if(readCount == 0) {
	                    wl.release();
	                }
	                rl.release();
	            } catch (InterruptedException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }

	    static class Write extends Thread {
	        @Override
	        public void run() {
	            try {
	                wl.acquire();
	                System.out.println(Thread.currentThread().getName() + " is WRITING");
	                Thread.sleep(1000);
	                System.out.println(Thread.currentThread().getName() + " has finished WRITING");
	                wl.release();
	            } catch (InterruptedException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        Read read = new Read();
	        Write write = new Write();
	        Thread t1 = new Thread(read);
	        t1.setName("Reader 1");
	        Thread t2 = new Thread(read);
	        t2.setName("Reader 2");
	        Thread t3 = new Thread(write);
	        t3.setName("Writer 1");
	        Thread t4 = new Thread(read);
	        t4.setName("Reader 3");
	        Thread t5 = new Thread(write);
	        t5.setName("Writer 2");
	        		
	        t1.start();
	        t3.start();
	        t2.start();
	        t5.start();
	        t4.start();
	    }
}
