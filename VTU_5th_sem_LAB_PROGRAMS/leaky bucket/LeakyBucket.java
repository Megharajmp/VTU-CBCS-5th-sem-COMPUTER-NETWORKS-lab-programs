import java.util.Scanner;

//leaky bucket
public class LeakyBucket {

	public static void main(String[] args) {
		int cin[]=new int[10],temp=0,temp2,output=0;
		String status="st";
		Scanner in=new Scanner(System.in);
		System.out.println("enter the maximum iteration");
		int MAX_ITERATION=in.nextInt();
		System.out.println("enter the maximum size of the bucket");
		int MAX_SIZE=in.nextInt();
		System.out.println("enter the output strength");
					int OUT_STRENGTH=in.nextInt();
		System.out.println("enter the inputs");
		for(int i=0;i<MAX_ITERATION;i++){
			cin[i]=in.nextInt();
			}
		System.out.println("ITERATION"+"    "+"INPUT"+"     "+"OUTPUT"+"     "+"REMAINING"+"    "+"STATUS");
		for(int i=0;i<MAX_ITERATION;i++){
			temp=temp+cin[i];
			temp2=temp;
					if(temp<=MAX_SIZE ){
						if(temp>=OUT_STRENGTH){
						temp=temp-OUT_STRENGTH;
						}
						
						
						output=temp2-temp;
						if(output==0){
							status="underflow";
						}
						else
						{
							status="success";
						}
						
					}
					else 
					{	if(temp>cin[i]){
						temp=temp-cin[i];
						}
						else
						{
							temp=cin[i]-temp;
						}
						temp2=temp;
				
						
						
						
						//	temp=temp-OUT_STRENGTH;
						
						
						
						
						if(temp>=OUT_STRENGTH){
							temp=temp-OUT_STRENGTH;
							}
							
							
							output=temp2-temp;
							if(output==0){
								status="underflow flushing :"+cin[i];
							}
							else
							{
							
								status="overflow/ but last operation success/& also flushing:"+cin[i];
							}
					}
				
				
					
					
			System.out.println(i+"            "+cin[i]+"         "+output+"            "+temp+"        "+status);
			
		}
	}
}
