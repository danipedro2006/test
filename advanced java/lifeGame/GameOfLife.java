package lifeGame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GameOfLife extends JFrame
	{
		int x, y;
		int[][] A=new int[130][130];
		int[][] XV=new int[130][130];
		int[][] YV=new int[130][130];
		
		public GameOfLife()
		{
			setTitle("game of life");
			setSize(1000,1000);
			setVisible(true);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			x=30;
			y=30;
			
		}
		
		public void paint(Graphics g)
		{
			//int px=0,py=0;
			g.drawString("Game of Life!", 750, 120);
			g.setColor(Color.RED);
			for(int i=0;i<130;i++)
				{
				x=30;
				for(int j=0;j<130;j++) 
					{
						try
							{
								run();
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						g.drawRect(x, y, 5, 5);
						A[i][j]=0;
						XV[i][j]=x;
						YV[i][j]=y;
						if((x^y)%7==0)
							{
								g.fillRect(x, y, 5, 5);
								A[i][j]=1;
								XV[i][j]=x;
								YV[i][j]=y;
							}
						x+=5;
					}
						y+=5;
				}
			try
				{
					run();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			try
				{
					run();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			try
				{
					run();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			int lifeCell;
			int T=0;
			while(T<20)
				{
					for(int i=0;i<130;i++)
						{
							try
								{
									run();
								} catch (InterruptedException e)
								{
									e.printStackTrace();
								}
							try
								{
									run();
								} catch (InterruptedException e)
								{
									e.printStackTrace();
								}
							for(int j=0;j<130;j++)
								{
									lifeCell=0;
									int life=A[i][j];
									if(j-1>=0)
										{
											if(A[i][j-1]==1) lifeCell++;
											
										}
									if(j+1<130)
										{
											if(A[i][j+1]==1) lifeCell++;
										}
									if(i-1>=0)
										{
											if(A[i-1][j]==1) lifeCell++;
										}
									if(i+1<130)
										{
											if(A[i+1][j]==1)lifeCell++;
										}
									if(lifeCell==3)
										{
											if(life==0)
												{
													g.setColor(Color.GREEN);
													g.fillRect(XV[i][j], YV[i][j],5,5);
													A[i][j]=1;
												}
										}
									if(lifeCell==0||lifeCell==1)
										{
											if(lifeCell==1)
												{
													g.clearRect(XV[i][j], YV[i][j],5,5);
													g.setColor(Color.RED);
													g.drawRect(XV[i][j], YV[i][j],5,5);
													A[i][j]=0;
												}
										}
									if(lifeCell==4)
										{
											if(lifeCell==1)
											{
												g.clearRect(XV[i][j], YV[i][j],5,5);
											g.setColor(Color.RED);
											A[i][j]=0;
											}
											
											
										}
								}
						}
					T++;
				}
			int survivor=0;
			for(int i=0;i<130;i++)
				{
					for(int j=0;j<130;j++)
						{
							if(A[i][j]==1) survivor++;
						}
				}
			g.drawString("Living cells= " +survivor,750,100);
		}
		public void run() throws InterruptedException
		{
			Thread.sleep(5);
			
		}
		
		public void lifeGame(Graphics g)
			{
				
			}
	
	

		public static void main(String[] args)
			{
				GameOfLife g=new GameOfLife();
				Thread t1=new Thread();
				t1.start();
			}

	}
