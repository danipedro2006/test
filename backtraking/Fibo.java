package backtraking;

public class Fibo
	{
		static int[] f=new int[1000];
		public static void main(String[] args)
			{
				
				System.out.println(fib(40));
				
				for(int i=0;i<f.length;i++)
					{
						System.out.println(f[i]);
					}
				
			}
		public static  int fib(int n)
		{
			if(n==0) f[0]=1;
			if(n==1) f[1]=1;
			
			if (f[n]!=0)return f[n];
			
			f[n]=fib(n-2)+fib(n-1);
			return f[n];
		}
}