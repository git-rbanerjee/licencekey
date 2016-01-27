package licencekey;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.regex.Matcher;

import com.google.gson.Gson;

public class VerifyLicence {

	public static boolean verifyLicense(LicenseKey licKey) {
		byte[] dat = Helper.getBytes(licKey.getData());

		byte[] signatureBytes = Helper.getBytes(licKey.getSignature());
		byte[] pub = Helper.getBytes(licKey.getPublicKey());

		Signature sig;
		try {
			sig = Signature.getInstance(Constants.SIGNATURE_TYPE);
			KeyFactory kf = KeyFactory.getInstance(Constants.ALGORITHM); 
			PublicKey publ = kf.generatePublic(new X509EncodedKeySpec(pub));

			sig.initVerify(publ);
			sig.update(dat);
			return sig.verify(signatureBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean verifyLicense(String licKey) {
		Matcher match = LicenseKey.pattern.matcher(licKey);
		if (!match.find()) {
			return false;
		}
		byte[] dat = Helper.getBytes(match.group(1));

		byte[] signatureBytes = Helper.getBytes(match.group(2));
		byte[] pub = Helper.getBytes(match.group(3));

		Signature sig;
		try {
			sig = Signature.getInstance(Constants.SIGNATURE_TYPE);
			KeyFactory kf = KeyFactory.getInstance(Constants.ALGORITHM); 
			PublicKey publ = kf.generatePublic(new X509EncodedKeySpec(pub));

			sig.initVerify(publ);
			sig.update(dat);

			return sig.verify(signatureBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static LicenceInfo getLicenceInfo(LicenseKey licKey) {
		if (verifyLicense(licKey)) {
			byte[] dat = Helper.getBytes(licKey.getData());
			Gson gson = new Gson();
			return gson.fromJson(new String(Base64.getDecoder().decode(dat)), LicenceInfo.class);

		} else {
			return null;
		}

	}

	public static LicenceInfo getLicenceInfo(String lic) {
		if (verifyLicense(lic)) {
			Matcher match = LicenseKey.pattern.matcher(lic);
			if (!match.find()) {
				return null;
			}
			byte[] dat = Helper.getBytes(match.group(1));
			Gson gson = new Gson();
			return gson.fromJson(new String(Base64.getDecoder().decode(dat)), LicenceInfo.class);

		} else {
			return null;
		}

	}

}
