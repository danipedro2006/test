package GenericClases;

public enum Animal 
	{
	CAT("Lily"), DOG("Rex"), MOUSE("Jerry");
		private String name;
		
		Animal (String name) 
		{
			this.name=name;
		}
	
		public String toString()
		{
			return "This animal is called:"+name;
		}
	}
