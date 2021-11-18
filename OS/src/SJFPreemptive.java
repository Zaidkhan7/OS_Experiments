import java.util.Scanner;

public class SJFPreemptive {
	
	public static void main(String args[])
	{
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter the Total number of processes.");
	      int n=in.nextInt();
	      int at[] = new int[n+1];
	      int bt[] = new int[n+1];
	      int temp[] = new int[n+1];
	      int wt[] = new int[n+1];
	      int tat[] = new int[n+1];

	      int i, smallest, count=0, time ,wait_time=0, turnaround_time=0,end;
	      double   average_waiting_time, average_turnaround_time;

	

	      for(i=0;i<n;i++){
	        System.out.println("Enter Arrival Time of "+(i+1));
	        at[i] = in.nextInt();
	        System.out.println("Enter Burst Time of "+(i+1));
	        bt[i] = in.nextInt();
	        temp[i] = bt[i];
	        System.out.println();
	      }
	      bt[n]=9999;
	      for(time=0; count!=n; time++){
	        smallest=n;
	        for(i=0;i<n;i++){
	          if(at[i]<=time && bt[i]<bt[smallest] && bt[i]>0){
	            smallest=i;
	          }
	        }
	        bt[smallest]--;
	        if(bt[smallest]==0){
	          count++;
	          end=time+1;
	          wt[smallest]=end-at[smallest]-temp[smallest];
	          wait_time+=end-at[smallest]-temp[smallest];
	          tat[smallest]=end-at[smallest];
	          turnaround_time+=end-at[smallest];
	        }
	      }

	      average_waiting_time=(double)wait_time/n;
	      average_turnaround_time=(double)turnaround_time/n;
	      System.out.println("Arrival time\t\tBurst time\t\tWaiting time\t\tTurn Around Time");
	      for(i=0;i<n;i++)
	      {
	    	System.out.println(at[i]+"\t\t\t"+temp[i]+"\t\t\t"+wt[i]+"\t\t\t"+tat[i]);  
	      }
	      System.out.println("Average Waiting Time: "+ average_waiting_time);
	      System.out.println("Average Turnaround Time: "+ average_turnaround_time);
	  }
	}

