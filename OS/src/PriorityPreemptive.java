import java.util.Scanner;

public class PriorityPreemptive {
	
	public static void main(String args[])
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n = obj.nextInt();
		
		int at[] = new int[n+1];
		int bt[] = new int[n+1];
		int tat[] = new int[n+1];
		int wt[] = new int[n+1];
		int temp[] = new int[n+1];
		int p[] = new int[n+1];
		
		int i,time,count = 0,sp,pwt = 0,ptat = 0,end;
		double awt,atat;
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter arrival time of "+(i+1));
			at[i] = obj.nextInt();
			System.out.println("Enter burst time of "+(i+1));
			bt[i] = obj.nextInt();
			temp[i] = bt[i];
			System.out.println("Enter priority of "+(i+1));
			p[i] = obj.nextInt();
			
		}
		p[n]=1000;
		
		for(time=0;count!=n;time++)
		{
			sp=n;
			for(i=0;i<n;i++)
			{
				if(at[i]<=time && p[i]<p[sp] && bt[i]>0)
				{
					sp=i;
				}
			}
			bt[sp]--;
			if(bt[sp]==0){
		          count++;
		          end=time+1;
		          wt[sp]=end-at[sp]-temp[sp];
		          pwt+=end-at[sp]-temp[sp];
		          tat[sp]=end-at[sp];
		          ptat+=end-at[sp];
		        }
		}
		
		awt = (double)pwt/n;
		atat= (double)ptat/n;
		
		
		System.out.println("Arrival Time\t\tBurst Time\t\tPriority\t\t Waiting time\t\tTurn Around Time");
		for(i=0;i<n;i++)
		{
			System.out.println("   "+at[i]+"\t\t\t   "+temp[i]+"\t\t\t   "+p[i]+"\t\t\t   "+wt[i]+"\t\t\t   "+tat[i]);
		}
		
		
		System.out.println("Average Waiting Time :"+awt+" ms");
		System.out.println("Average Turn around time : "+atat+" ms");
		
		
		
	}
}
