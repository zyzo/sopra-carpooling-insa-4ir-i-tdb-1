package com.sopride.web.util;
import java.util.Random;
public class RandomUtil {
	
	public static String randomString(int size) {
		StringBuilder builder = new StringBuilder();
		char lettre;
		for(int x=0; x<=size; x++)
        {

        	Random random=new Random();
           int val=63 + random.nextInt(59);
           lettre = ((char)val);
           builder.append(lettre);
        }
		return builder.toString();
	}
}
