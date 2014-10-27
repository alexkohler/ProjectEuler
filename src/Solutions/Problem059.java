package Solutions;
/*
 * Author Alexander Kohler
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem059 {

	/*
Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange).
 For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key.
 The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes. 
The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message. 
The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower case characters. 
Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.



	 */
	static void findSample() throws IOException
	{
		BufferedReader bs = new BufferedReader(new FileReader("src/Resources/Problem059Resource.txt"));
		//PrintWriter writer = new PrintWriter("Problem059Log.txt", "UTF-8");
		String line; 
		line = bs.readLine();
		String[] asciiVals = line.split(",");
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int uno = 0;
		int dos = 0;
		int tres = 0;
		int currentAsciiValOneIndex = 0;
		int currentAsciiValTwoIndex = 1;
		int currentAsciiValThreeIndex = 2;
		for (char alph : alphabet)
		{
			uno = alph;
			for (char alphTwo: alphabet)
			{
				dos = alphTwo;
				for (char alphThree : alphabet)
				{
					tres = alphThree;
					int[] key = {uno, dos, tres};

					char decrOne = (char) (key[0] ^ Integer.valueOf(asciiVals[currentAsciiValOneIndex]));
					char decrTwo = (char) (key[1] ^ Integer.valueOf(asciiVals[currentAsciiValTwoIndex]));
					char decrThree = (char) (key[2] ^ Integer.valueOf(asciiVals[currentAsciiValThreeIndex]));
					char decrFour = (char) (key[0] ^ Integer.valueOf(asciiVals[3]));
					char decrFive  = (char) (key[1] ^ Integer.valueOf(asciiVals[4]));
					char decrSix = (char) (key[2] ^ Integer.valueOf(asciiVals[5]));
					char decrSeven = (char) (key[0] ^ Integer.valueOf(asciiVals[6]));
					char decrEight = (char) (key[1] ^ Integer.valueOf(asciiVals[7]));
					char decrNine = (char) (key[2] ^ Integer.valueOf(asciiVals[8]));
					char decrTen = (char) (key[0] ^ Integer.valueOf(asciiVals[9]));
					char decrEleven = (char) (key[1] ^ Integer.valueOf(asciiVals[10]));
					char decrTwelve = (char) (key[2] ^ Integer.valueOf(asciiVals[11]));
					char decrThirteen = (char) (key[0] ^ Integer.valueOf(asciiVals[12]));
					char decrFourteen = (char) (key[1] ^ Integer.valueOf(asciiVals[13]));
					char[] dicks = {decrOne, decrTwo, decrThree, decrFour, decrFive, decrSix, decrSeven, decrEight, decrNine, decrTen, decrEleven, decrTwelve, decrThirteen};
					String decr = new String(dicks);
					if (!decr.contains("$") && !decr.contains("|") && !decr.contains("~") && !decr.contains(">") && !decr.contains("<") && !decr.matches(".*[0-9].*") && !decr.contains("@") && !decr.contains("#") && !decr.contains("%") && !decr.contains("*")
							&& !decr.contains(".") && !decr.contains(":") && !decr.contains(";") && !decr.contains("?") && !decr.contains("=") & !decr.contains("!") & !decr.contains("&") & !decr.contains("[") & !decr.contains("]")
							&& !decr.contains("\\") & !decr.contains("+") & !decr.contains("}") & !decr.contains("{"))
					System.out.println("Decryped message is " + decr + " with code " + alph + alphTwo + alphThree);
				}
			}
		}
				
		//writer.close();
	}
	
	static void decryptMessage() throws IOException
	{
		char password[] = {'g', 'o', 'd'};
		BufferedReader bs = new BufferedReader(new FileReader("src/Resources/Problem059Resource.txt"));
		String line = bs.readLine();
		bs.close();
		String[] asciiVals = line.split(",");
		int currentAsciiValOneIndex = 0;
		int currentAsciiValTwoIndex = 1;
		int currentAsciiValThreeIndex = 2;
		String s = "";
		for (String a : asciiVals)
		{
			if (currentAsciiValThreeIndex < 1202)
			{
			char decodedChar = (char) (password[0] ^ Integer.valueOf(asciiVals[currentAsciiValOneIndex]));
			char decodedCharTwo =  (char) (password[1] ^ Integer.valueOf(asciiVals[currentAsciiValTwoIndex]));
			char decodedCharThree = (char) (password[2] ^ Integer.valueOf(asciiVals[currentAsciiValThreeIndex]));
			currentAsciiValOneIndex += 3;
			currentAsciiValTwoIndex += 3;
			currentAsciiValThreeIndex += 3;
			char [] chunk = {decodedChar, decodedCharTwo, decodedCharThree};
			s = s + new String(chunk);
			}
			

		}
		char[] boop  = s.toCharArray();
		long sum = 0;

		
		for (char c : boop)
		{
			sum += (int) c;
		}
		char extra = (char) (password[0] ^ Integer.valueOf(asciiVals[1200]));
		sum = sum + ((int) extra);
		
	//	System.out.println(s);
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		//findSample();
		decryptMessage();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
