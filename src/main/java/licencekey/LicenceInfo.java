package licencekey;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

public class LicenceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5720361449838924765L;

	private String vendorName = "Ericsson";
	private String customerName = "Any";
	private String productName = "";
	private String hostName = "Any";
	private String macAddress = "00:00:00:00:00:00";
	public Integer tokens = -1;
	private Date expiryDate = new Date();

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getTokens() {
		return tokens;
	}

	public void setTokens(Integer tokens) {
		this.tokens = tokens;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public LicenceInfo fromString(String data) {
		Gson gson = new Gson();
		return gson.fromJson(data, LicenceInfo.class);
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
