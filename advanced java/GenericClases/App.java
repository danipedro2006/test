package GenericClases;

public class App 
{
public static void main(String[] args) 
	{
		System.out.println(Animal.DOG);
		System.out.println(Animal.DOG.getClass());
		System.out.println(Animal.CAT instanceof Enum);
		System.out.println(Animal.CAT instanceof Animal);
		System.out.println(Animal.CAT.name());
		System.out.println(Animal.CAT.toString());
		System.out.println(Animal.DOG.toString());
		
	}


}

