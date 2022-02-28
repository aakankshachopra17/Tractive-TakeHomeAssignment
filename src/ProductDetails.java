package pkg;

public class ProductDetails {
	
	Integer pVersion;
	String pEdition;
	long  pQty;
	
	
	public ProductDetails(Integer pVersion, String pEdition) {
		super();
		this.pVersion = pVersion;
		this.pEdition = pEdition;
	}

	public Integer getpVersion() {
		return pVersion;
	}
	public void setpVersion(Integer pVersion) {
		this.pVersion = pVersion;
	}
	public String getpEdition() {
		return pEdition;
	}
	public void setpEdition(String pEdition) {
		this.pEdition = pEdition;
	}
	public long getpQty() {
		return pQty;
	}
	public void setpQty(long pQty) {
		this.pQty = pQty;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		if(pVersion != null) {
			sb.append("version=").append(pVersion).append(",");
		}
		if(pEdition != null) {
			sb.append("edition=").append(pEdition).append(",");
		}
			sb.append("quantity=").append(pQty);
			sb.append("}");
			return 	sb.toString();
		}
		
		
}
