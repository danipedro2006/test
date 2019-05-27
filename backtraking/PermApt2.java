package backtraking;

public class PermApt2
	{

		public static void main(String[] args)
			{
				String[] str={"1","2","3"};
				genPerm(str, 0);
			}
		
			public static void genPerm(String[] str, int i)
			{
				if(i==str.length)
					{
						display(str);
						return;
					}
				
				for(int j=i;i<str.length;i++)
					{
						String temp;
						
						temp=str[i];
						str[i]=str[j];
						str[j]=temp;
						
						//display(str);
						genPerm(str,j+1);
						
						temp=str[i];
						str[i]=str[j];
						str[j]=temp;
					}
				
			}

			
			
			
			private static void display(String[] str)
				{
					for(String i:str)
						{
							System.out.print(i);
						}
					System.out.println("\nQ");
				}

	}
