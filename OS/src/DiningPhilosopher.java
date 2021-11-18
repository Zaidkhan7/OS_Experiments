class Chopsticks {
  private static int counter = 0;
  private int number = counter++;
  public String toString() {
    return "Chopstick " + number;
  }
}
public class DiningPhilosopher extends Thread {
	private Chopsticks left;
    
    private Chopsticks right;

    private int index;


    public DiningPhilosopher (Chopsticks left, Chopsticks right, int index) {
        this.left = left;
        this.index = index;
        this.right = right;
    }

    @Override
    public void run() {

        if (index==5) {
            synchronized (right) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Philosopher "+index + "  Waiting for chopsticks LEFT ");
                synchronized (right) {
                    System.out.println("Philosopher "+index + "  Get chopsticks LEFT ");
                }
            }
        } else {
            synchronized (left) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Philosopher "+index + "  Waiting for chopsticks RIGHT");
                synchronized (right) {
                    System.out.println("Philosopher "+index + "  Get chopsticks RIGHT ");
                }
            }
        }
    }
        

    

    public static void main(String[] args) {
        Chopsticks chopsticks1 = new Chopsticks();
        Chopsticks chopsticks2 = new Chopsticks();
        Chopsticks chopsticks3 = new Chopsticks();
        Chopsticks chopsticks4 = new Chopsticks();
        Chopsticks chopsticks5 = new Chopsticks();

        DiningPhilosopher philosopherThread1 = new DiningPhilosopher(chopsticks1, chopsticks2, 1);
        DiningPhilosopher philosopherThread2 = new DiningPhilosopher(chopsticks2, chopsticks3, 2);
        DiningPhilosopher philosopherThread3 = new DiningPhilosopher(chopsticks3, chopsticks4, 3);
        DiningPhilosopher philosopherThread4 = new DiningPhilosopher(chopsticks4, chopsticks5, 4);
        DiningPhilosopher philosopherThread5 = new DiningPhilosopher(chopsticks5, chopsticks1, 5);
        philosopherThread1.start();
        philosopherThread4.start();
        philosopherThread2.start();
        philosopherThread3.start();
        philosopherThread5.start();
    }
}
