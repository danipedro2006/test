package backtraking;

public class PermAp
	{

		public static void main(String[] args)
			{
				int[] p= {1,2,3};
				for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
							{
								for(int k=0;k<3;k++)
									{
									if((p[i]!=p[j]) && p[j]!=(p[k]) && p[k]!=p[i])
										{
											System.out.println(p[i]+""+p[j]+""+p[k]);
										}
									}
							}
					}
			}

	}
