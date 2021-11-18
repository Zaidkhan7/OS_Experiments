import java.util.Scanner;

public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner obj = new Scanner(System.in);
		System.out.println("Enter number of processes");
		int n = obj.nextInt();
		int at[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		int bt[] = new int[n];
		int i,j,sum=0;
		float sumbt=0,sumwt=0;
	
		for(i=0;i<n;i++)
		{
			System.out.println("Enter arrival time of"+i);
			at[i] = obj.nextInt();
			System.out.println("Enter Burst time of "+i);
			bt[i] = obj.nextInt();
		}
		wt[0]=0;
		for(i=1;i<n;i++)
		{
		    for(j=i-1;j>=0;j--)
		    {
		    	sum=sum+bt[j];
		    }
		    wt[i]=sum-at[i];
		    sum=0;
		}
		
		
		for(i=0;i<n;i++)
		{
			tat[i] = bt[i]+wt[i];
			sumwt = sumwt+wt[i];
			sumbt = sumbt+bt[i];
		}
		
		float avwt = sumwt/n;
		float avbt = sumbt/n;
		System.out.println("Burst Time "+"  Waiting time  "+"  Turn Around Time"+"Arrival time");
		for(i=0;i<n;i++)
		{
			System.out.println(bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]+"\t\t"+at[i]);
		}
		
		System.out.println("Average Waiting time : "+avwt);
		System.out.println("Average Burst time : "+avbt);
		
		

		
		
		
	}

}
