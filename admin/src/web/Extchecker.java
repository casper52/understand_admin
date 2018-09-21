package web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extchecker {

	static final String allowPattern = ".+\\.(gif|jpg|png|)$";

	public static boolean check(String fileName) {
		boolean result = false;

		Pattern p = Pattern.compile(allowPattern);
		Matcher m = p.matcher(fileName);
		result = m.matches();

		return result;
	}

	public static void main(String[] args) {

		String name = "ekjfkelfjielws.zip";
		System.out.println(check(name));
	}

}
