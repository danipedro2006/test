package GenericClases;

public class GenericMethod
	{
		static <T> void Display(T value)
		{
			System.out.println("Value= "+value);
		}
		
		public static void main(String[] args)
			{
				Display(10);
				Display(true);
				Display("Generic method");
			}

	}
