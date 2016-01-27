package licencekey;

import java.io.Serializable;
import java.util.regex.Pattern;

public class LicenseKey implements Serializable {

	private static final long serialVersionUID = 3794372711107717521L;
	
	private static final String delim = Helper.getString("///Ericsson///".getBytes());
	
	public static final Pattern pattern = Pattern.compile("START(.*?)"+delim+"(.*?)"+delim+"(.*?)END");
	
	private String data;
	private String signature;
	private String publicKey;
	
	public LicenseKey(String data, String signature, String publicKey) {
		super();
		this.data = data;
		this.signature = signature;
		this.publicKey = publicKey;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}


	@Override
	public String toString() {
		return "START"+ data + delim + signature + delim + publicKey + "END";
	}
	
	
	
	
	
	
}
