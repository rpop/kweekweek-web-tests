package utils;

public class StringModifiers {

	
	public static String removeWhiteSpaces (String string){
		String removed = string.replaceAll("\\s+","");
		return removed;
	}
}
