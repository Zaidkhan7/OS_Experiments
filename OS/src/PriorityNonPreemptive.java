import java.util.Scanner;

public class PriorityNonPreemptive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int i, smallest, count=0, time, n,j,temp1=0,min=99,sum=0;;
	      double wait_time=0, turnaround_time=0, end, average_waiting_time, average_turnaround_time;
		
		 Scanner in = new Scanner(System.in);
		  System.out.println("Enter the Total number of processes.");
	      n=in.nextInt();
	      int at[] = new int[n];
	      int bt[] = new int[n];
	      int temp[] = new int[n];
	      int p[] = new int[n];
	      int wt[] = new int[n];
	      int tat[] = new int[n];
	      int t=999;
	    

	     
	      System.out.println("Enter the details of "+n+" processes");

	      for(i=0;i<n;i++){
	        System.out.println("Enter Arrival Time");
	        at[i] = in.nextInt();
	        System.out.println("Enter Burst Time");
	        bt[i] = in.nextInt();
	        temp[i] = bt[i];
	        System.out.println("Enter priority");
	        p[i]=in.nextInt();
	        System.out.println();
	      }
	    
			for(i=0;i<n-1;i++)
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
						
						temp1=p[j+1];
						p[j+1]=p[j];
						p[j]=temp1;
					}
					if(at[j]==at[j+1])
					{
						if(p[j]>p[j+1])
						{
							temp1=bt[j+1];
							bt[j+1]=bt[j];
							bt[j]=temp1;
						}
						
					}
				}
			}
			

	      
	      System.out.println("Arrival Time\t\tBurst Time\t\tPriority\t\t Waiting time\t\tTurn Around Time");
	      
	      System.out.println(at[0]+"\t\t\t"+bt[0]+"\t\t\t"+p[0]+"\t\t\t"+"0\t\t\t"+bt[0]);
	      
	      sum=sum+bt[0]+at[0];
	      
	      at= RemoveElement(at,0);
	      bt = RemoveElement(bt,0);
	      p = RemoveElement(p,0);

	      
	      
	      
	      while(at.length!=0)
	      {
	    	  for(j=0;j<at.length;j++)
		      {
		    	  for(i=0;i<at.length;i++)
			      {
			    	  if(at[i]<=sum && p[i]<min)
			    	  {
			    		 
			    			  min=i;
			    		  
			    	  }
			    	 
			      }
		    	  sum=sum+bt[min];
		    	  wt[min]=sum-bt[min]-at[min];
		    	  tat[min] = bt[min]+wt[min];
		    	  System.out.println(at[min]+"\t\t\t"+bt[min]+"\t\t\t"+p[min]+"\t\t\t"+wt[min]+"\t\t\t"+tat[min]);
		    	  at = RemoveElement(at , min);
		    	  bt = RemoveElement(bt , min);
		    	  p = RemoveElement(p,min);
		    	  
		    	  min=99;
		    	  
		      }
	      }
	      
	}
	      
	     
	      

	
	
	public static int[] RemoveElement(int arr[],int pos)
	{
		 if (arr == null
		            || pos < 0
		            || pos >= arr.length) {
		  
		            return arr;
		        }
		
		int anotherarray[] = new int[arr.length-1];
		
		for(int i=0, k=0;i<arr.length;i++)
		{
			if(i==pos)
			{
				continue;
			}
			anotherarray[k++]=arr[i];
		}
		return anotherarray;

}
	}