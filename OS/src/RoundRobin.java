import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner obj = new Scanner(System.in);
		System.out.println("Enter number of processes : ");
		int n = obj.nextInt();
		System.out.println("Enter time quantum");
		int tq = obj.nextInt();
		
		int at[] = new int[n+1];
		int bt[] = new int[n+1];
		int tat[] = new int[n+1];
		int wt[] = new int[n+1];
		int temp[] = new int[n+1];
		boolean s=true;
				
		int i,time,count = 0,sp,pwt = 0,ptat = 0,endl,j,temp1,end=0 , l=1000;
		double awt,atat;
		Queue<Integer> hs = new LinkedList<>();
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter arrival time of "+(i+1));
			at[i] = obj.nextInt();
			System.out.println("Enter burst time of "+(i+1));
			bt[i] = obj.nextInt();
			temp[i] = bt[i];			
		}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<n-i-1;j++)
			{
				if(at[j]>at[j+1])
				{
					temp1=at[j+1];
					at[j+1]=at[j];
					at[j]=temp1;
					
					temp1=bt[j+1];
					bt[j+1]=bt[j];
					bt[j]=temp1;
					
					temp1 = temp[j+1];
					temp[j+1]=temp[j];
					temp[j]=temp1;
				}
				
			}
		}
		
		
		int lastprocess=111;
		for(time=0;count!=n;)
		{
			
				
			for(i=0;i<n;i++) {
				
				if(at[i]<=time && bt[i]>0 && hs.contains(i)==false)
				{
					hs.offer(i);
					
				}
			}
			
			while(s==true)
			{
				if(!hs.isEmpty())
				{
				 l = hs.element();
				 if(lastprocess==l)
				 {
					 hs.poll();
					 hs.offer(l);
					 l=hs.element();
				 }
				 lastprocess=l;
			  
				 if(bt[l]>tq)
					{
						bt[l] = bt[l]-tq;
						time=time+tq;
						hs.poll();
						hs.offer(l);
						s=false;
						break;
						
					}
				 
					
				 if(bt[l]<=tq)
					{
						
						time=time+bt[l];
						bt[l] = 0;
						hs.poll();
						count++;
				          end=time;
				          wt[l]=end-at[l]-temp[l];
				          pwt+=end-at[l]-temp[l];
				          tat[l]=end-at[l];
				          ptat+=end-at[l];
				          s=false;
				          break;
				         
					}
				 
					
				}
				else {
					time++;
					s=false;
					break;
					
				}
				
			}	
			s=true;
				
		}
		
		
		
		
		awt = (double)pwt/n;
		atat= (double)ptat/n;
		
		
		System.out.println("Arrival Time\t\tBurst Time\t\tWaiting time\t\tTurn Around Time");
		for(i=0;i<n;i++)
		{
			System.out.println("   "+at[i]+"\t\t\t   "+temp[i]+"\t\t\t   "+wt[i]+"\t\t\t   "+tat[i]);
		}
		
		
		System.out.println("Average Waiting Time :"+awt+" ms");
		System.out.println("Average Turn around time : "+atat+" ms");
	}

}
	
	
	
