package licencekey;
import java.math.BigInteger;

public class Helper {
	
	public static String getString(byte[] data)
	{
		return new BigInteger(1, data).toString(16);
	}
	
	public static byte[] getBytes(String data)
	{
		return new BigInteger(data, 16).toByteArray();
	}

}
