package GenericClases;

public class genListTest
	{

		public static void main(String[] args)
			{
				genList<String> glist=new genList<String>(10);
				glist.add("milk");
				glist.add("apple");
				
				System.out.println("Grosery list: "+glist.toString());
				
				
				
			genList<Integer> numbers=new genList<Integer>(3);
				numbers.add(1);
				numbers.add(23);
				numbers.add(4);
				
				System.out.println("Integers list:"+numbers.toString());
			}
		
				
				

	}
