package licencekey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLicenceInfo {
	
	
	public static LicenceInfo read()
	{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.print("Enter ProductName :: ");
			String productName = br.readLine();
			System.out.print("Enter No of Tokens :: ");
			Integer tokens = Integer.parseInt(br.readLine());
			
			LicenceInfo licInfo = new LicenceInfo();
			licInfo.setProductName(productName);
			licInfo.setTokens(tokens);
			
			return licInfo;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
