package licencekey;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptionTest {

	private static final Logger logger = LoggerFactory.getLogger(EncryptionTest.class);

	@Test
	public void TestCase1() {
		try {
			LicenceInfo licInfo = ReadLicenceInfo.read();
			String licenseKey = GenerateLicence.generateLicence(licInfo).toString();
			logger.info("LICENCE KEY is below :: \n"+licenseKey);
			logger.info("Verify Licence Key:: "+VerifyLicence.verifyLicense(licenseKey));
			logger.info("Licence Key Info:: "+VerifyLicence.getLicenceInfo(licenseKey));
			Assert.assertTrue(VerifyLicence.verifyLicense(licenseKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
