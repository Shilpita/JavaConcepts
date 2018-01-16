package ContainmentDemo;

class Funds {
	private String fundId;
	private double amount;
	
	
	public Funds (String fundId, double amount)
	{
		this.fundId = fundId;
		this.amount = amount;
	}
	public String getFundId() {
		return fundId;
	}
	@Override
	public String toString() {
		return "Funds ["
				+ (fundId != null ? "fundId=" + fundId + ", " : "")
				+ "amount="
				+ amount +"]";
	}
}
