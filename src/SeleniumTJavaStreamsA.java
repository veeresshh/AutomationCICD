import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class SeleniumTJavaStreamsA {
	
	//Filter Using Normal Java
	
	public static void Normal(String[] args){

		ArrayList <String> Names = new ArrayList<String>();
		Names.add("Alan");
		Names.add("Daniel");
		Names.add("Alexa");
		Names.add("Anthony");
		Names.add("Ram");
		
		int Count =0;
		
		for(int i=0; i<Names.size(); i++)
		{
			String Actual =Names.get(i);
			
			if(Actual.startsWith("A"))
			{
				Count++;
			}
		}
		
		System.out.println(Count);
	}

	//Filter Using Java Streams

	public static void main(String[] args){
		
		ArrayList <String> Names = new ArrayList<String>();
		Names.add("Azana");
		Names.add("Daniela");
		Names.add("Alexa");
		Names.add("Abthonya");
		Names.add("Rama");
		
	//Simple Method of converting into ArrayList
		
		List<String> Names2 = Arrays.asList("Monkey","Donkey","Elephant","Tiger","Deer");
		
		Long FinalCount = Names.stream().filter(V->V.startsWith("A")).count();
		
		System.out.println(FinalCount);
		
	//Another way
		
		System.out.println(Stream.of("Alan","Daniel","Alexa","Anthony","Ram").filter(V->V.startsWith("A")).count());
		
	//To Print all the Names of Array Lists
		
		Names.stream().filter(S->S.length()>4).forEach(S->System.out.println(S));
	
	//To Get Only One Result
		
		Names.stream().filter(S->S.length()>4).limit(1).forEach(S->System.out.println(S));
		
     //To Print Names endind with a with Uppercase
		
		Names.stream().filter(S->S.endsWith("a")).map(S->S.toUpperCase()).forEach(S->System.out.println(S));
		
	 //To Print All Names with Uppercase
		
	    Names.stream().map(S->S.toUpperCase()).forEach(S->System.out.println(S));
	    
	 //To Print Names Starting with A and Sorted in Alphabetical Order
	    
	    Names.stream().filter(S->S.startsWith("A")).sorted().map(S->S.toUpperCase()).forEach(S->System.out.println(S));
	    
	    
	 //Merging Two Array Lists
	    
	   Stream<String> NewStream =Stream.concat(Names.stream(), Names2.stream());
	  // NewStream.sorted().forEach(S->System.out.println(S));
	    
	 // To Check wheather Alexa is present in Lists
	    
	   boolean Flag = NewStream.anyMatch(S->S.equalsIgnoreCase("ALEXA"));
	   System.out.println(Flag);
	   Assert.assertTrue(Flag);
	   
	 //To Convert Stream as List
	   
	   List<String> UpdatedList = Names.stream().filter(S->S.endsWith("a")).map(S->S.toUpperCase()).collect(Collectors.toList());
	   System.out.println(UpdatedList.get(1));
	   
	   
	 //Interview Questions
	   
	   List<Integer> Numbers = Arrays.asList(3,2,2,7,5,1,9,7);
	   
	 //To Print Unique Numbers and Sort the Numbers  
	   
	   Numbers.stream().distinct().forEach(S->System.out.println(S));
	   
	   Numbers.stream().distinct().sorted().forEach(S->System.out.println(S));	
	   
	 // To Get 3rd Index
	   
	   List<Integer> ListOfNumbers = Numbers.stream().distinct().sorted().collect(Collectors.toList());
	   System.out.println(ListOfNumbers.get(3));
	  
	}

}
