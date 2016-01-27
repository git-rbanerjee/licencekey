package licencekey;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class GenerateLicence {

	public static LicenseKey generateLicence(LicenceInfo licenceInfo) throws Exception {
		byte[] data = Base64.getEncoder().encodeToString(licenceInfo.toString().getBytes("utf-8")).getBytes();
		
		

		/////////////////////////////////////////////////////////////
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(Constants.ALGORITHM);
		kpg.initialize(1024);
		KeyPair keyPair = kpg.genKeyPair();
		Signature sig = Signature.getInstance(Constants.SIGNATURE_TYPE);
		sig.initSign(keyPair.getPrivate());
		sig.update(data);
		byte[] signatureBytes = sig.sign();
		

		return new LicenseKey(Helper.getString(data), Helper.getString(signatureBytes), Helper.getString(keyPair.getPublic().getEncoded()));
	}
	
	

}
