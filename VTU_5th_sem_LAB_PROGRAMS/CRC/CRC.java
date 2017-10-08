import java.util.Scanner;

public class CRC {

	public static void main(String[] args) {
		int g[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1},temp;
		Scanner in=new Scanner(System.in);
		System.out.println("------------------------------SENDER------------------------------");
		System.out.println("Entered g(x) values/polynomial values are");
		for(int i=0;i<g.length;i++){
			System.out.print(g[i]+"  ");
		}
		System.out.println("\nEnter the size of the message");
		int MSG_SIZE=in.nextInt();
		int t[]=new int[MSG_SIZE];
		int mt[]=new int[MSG_SIZE+16];
		System.out.println("enter the message");
		for(int i=0;i<MSG_SIZE;i++){
			t[i]=in.nextInt();
		}
		System.out.println("\nEntered message is");
		for(int i=0;i<t.length;i++){
			System.out.print(t[i]+" ");
		}
		System.out.println("\nmodified message is");
		for(int i=0;i<MSG_SIZE;i++){
			temp=t[i];
			mt[i]=temp;
		}
		for(int i=0;i<mt.length;i++){
			System.out.print(mt[i]+" ");
		}
		int count[]=new int[(mt.length-g.length)+1];  //6+1
		int temp1[]=new int[g.length];
		for(int i=0;i<g.length;i++){
			temp1[i]=mt[i];
		}
		int final_code[]=new int[16+MSG_SIZE];
		crc(g,count,temp1,final_code,t);
	}

	private static void crc(int[] g,int count[],int temp1[],int final_code[],int t[]) {
		int checksum[]=new int[g.length-1],l;
		int st = 0,status=0;
		Scanner in=new Scanner(System.in);
		int temp2[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		 System.out.println();
		for(int i=0;i<count.length;i++){
			if(temp1[0]==1){
				for(int j=0;j<g.length;j++){
					temp1[j]=temp1[j]^g[j];
				}
			}
			else if(temp1[0]==0){
				for(int j=0;j<g.length;j++){
					temp1[j]=temp1[j]^temp2[j];
				}
			}
			for(int x=0;x<temp1.length-1;x++){
				temp1[x]=temp1[x+1];
			}
			temp1[temp1.length-1]=0;
		}
		for(int k=0;k<temp1.length-1;k++){
			checksum[k]=temp1[k];
		}
		System.out.print("checksm value is:\n");
		for(int i=0;i<checksum.length;i++){
			System.out.print(checksum[i]+" ");
		}
		for(int i=0;i<t.length;i++){
			final_code[i]=t[i];
		}
		for(int i=t.length ,j=0;i<final_code.length;i++,j++){
			final_code[i]=checksum[j];
		}
		System.out.println("\ncode word is:-");
		for(int i=0;i<final_code.length;i++){
		System.out.print(final_code[i]+" ");
		}
		
		System.out.print("\n..\n....\n........\n..............\n..................sending");
		do{
		System.out.println("\n------------------------------RECIVER------------------------------\n");
		System.out.println("\t\t\tSELECT ANY ONE OF BELOW");
		System.out.println("\n\t\t \t1)see the output\n\t\t \t2)enter the error\n\t\t \t3)exit");
		int c=in.nextInt();
		switch(c){
			case 1 :status=reciver(final_code,g,temp2,count,st);
					if(status==1){
						System.out.println("\n>>>>>>>>>>the message recived is correct/no error..!!!<<<<<<<<<<<\n");
					}
					else
					{
						System.out.println("\n>>>>>>>>>>WARNING..!!!! \nthe message recived is incorrect/error..!!!<<<<<<<<<\n");
					}
					break;
			case 2 :System.out.println("\t\t\tenter the position\n");
					int ARR_POSITION=in.nextInt();
					System.out.println("\t\t\tenter the value");
					final_code[ARR_POSITION]=in.nextInt();
					break;
			case 3 :exit_fun();
					break;
			default:System.out.println("invalid selection\n");
					break;
			}
			System.out.println("do you want to continue..??? y=1 n=0");
			l=in.nextInt();
	}while(l==1);
		
	}
	private static void exit_fun() {
		System.out.println("closing..");
		System.exit(0);		
	}
	static int reciver(int final_code[],int g[],int temp2[],int count[],int st ){
	int[] final_code_1=new int[g.length];
	int[] answer=new int[g.length-1];
		for(int i=0;i<final_code_1.length;i++){
			final_code_1[i]=final_code[i];
		}
		//final_code_1[8]=1;
		System.out.println();
		int o=final_code.length-final_code_1.length;
		int d=17;
		for(int i=0;i<count.length;i++){
			if(final_code_1[0]==1){
				for(int j=0;j<g.length;j++){
					final_code_1[j]=final_code_1[j]^g[j];
				}
			}
			else if(final_code_1[0]==0){
				for(int j=0;j<g.length;j++){
					final_code_1[j]=final_code_1[j]^temp2[j];
				}
			}
			for(int x=0;x<final_code_1.length-1;x++){
				final_code_1[x]=final_code_1[x+1];
			}
			if(o!=0){
			final_code_1[final_code_1.length-1]=final_code[d];
			d++;
			o--;
			}
		}
		for(int j=0;j<answer.length;j++){
			answer[j]=final_code_1[j];
		}
		//error code can be shown here
		int ret=0;
		for(int j=0;j<answer.length;j++){
			ret=ret+answer[j];
			
		}
		if(ret==0){
			return 1;
		}
		else
		{
			return 0;
			
		}
		
		
	}
		
}
		

	


