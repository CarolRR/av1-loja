
public class Products {

	private String productName;
	private String code;
	private float unitValue;
	private int saleQnt = 0;
	
	public String getProductName() {
		return productName;
		
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public float getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(float unitValue) {
		this.unitValue = unitValue;
		}
	public int getSaleQnt() {
		return saleQnt;
	}
	public void setSaleQnt(int saleQnt) {
		this.saleQnt = saleQnt;
	}
}
