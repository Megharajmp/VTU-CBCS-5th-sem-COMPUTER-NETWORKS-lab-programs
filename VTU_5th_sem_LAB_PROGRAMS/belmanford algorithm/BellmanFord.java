import java.util.Scanner;


public class BellmanFord {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ADJ_ARR[][]={{0,4,5,8,999} ,
						{999,0,-3,999,999} ,
						{999,999,0,999,4},
						{999 ,999,999,0,2},
						{999,999 ,999,1,0},
						};
		Scanner in=new Scanner(System.in);
		System.out.println("enter the no of nodes:");
		int n=in.nextInt();
		System.out.println("enter the source vertecis:");
		int s=in.nextInt();
		/*System.out.println("enter the adjecency matrics:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ADJ_ARR[i][j]=in.nextInt();
			}
		}*/
		System.out.println("entered adjecency matrix:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(ADJ_ARR[i][j]+" ");
			}
			System.out.println();
		}
		int VER[]=new int[n];
		int u[]=new int[n];
		int DIST[]=new int[n];
		for(int i=0;i<n;i++){
			DIST[i]=999;
			VER[i]=i;
			u[i]=i;
		}
		DIST[s]=0;
		int PARENT[]=new int[n];
		for(int i=0;i<n-1;i++){
			for(int j=s;j<n;j++){
				for(int k=0;k<n;k++){
					if(ADJ_ARR[j][k]!=0){
					if(ADJ_ARR[j][k]!=999){
						if(DIST[ k]>DIST[j]+ADJ_ARR[j][k]){
						DIST[ k]=DIST[j]+ADJ_ARR[j][k];
						PARENT[ k]=u[j];
						
						
					}
					}
					}
				}
			}
			
		}
		System.out.println("verticis"+"   "+"distence"+"   "+"parent");
		for(int i=0;i<n;i++){
			System.out.println(VER[i]+"              "+DIST[i]+"            "+PARENT[i]);
		}
		for(int i=0;i<n;i++){
		
		System.out.println("the distence from:"+s+"->"+ VER[i]+"is ->"+DIST[i]);
		
		}
		System.out.print(s);
		for(int i=0;i<n;i++){
			
			System.out.print("   ->   "+ VER[i]+"("+DIST[i]+")");
			
			}
	
	}

}
