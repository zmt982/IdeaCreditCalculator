package com.Anatolii.CreditCalculator;

public class Credit {
	float sum;
	float monthPayment;
	float rate;
	СlientType clientType;
	float output;
	float credit;	
	
	public Credit(float sum, float monthPayment, float rate, String clientType) {
		this.sum = sum;
		this.monthPayment = monthPayment;
		this.rate = rate;
		this.clientType = СlientType.valueOf(clientType);
		
	}
	public float calculate (СlientType clientType) throws Exception {
		if (clientType == СlientType.human) {
				calculateHuman();
				return output;
			}
		if (clientType == СlientType.business) {
				calculateBusiness();
				return output;
			}
		throw new Exception("it is impossible to pay");
	}
	
	public float calculateHuman() throws Exception {
		output = sum * rate / 100;
		float yearPayment = 12 * monthPayment;
		if(sum > 0 && (yearPayment > sum + output)) {
			return output;
		} 
		throw new Exception("it is impossible to pay");
	}

	@SuppressWarnings("unused")
	public float calculateBusiness() throws Exception {
		float yearPayment = 12 * monthPayment;
				if(sum > 0 && (yearPayment > sum / 6)) {
					sum = sum - yearPayment;
										
				for(int i = 0; sum > yearPayment; i++) {
					float output2 = sum * rate / 100;
					sum = sum + output2 - yearPayment;
					output = output2 + (sum * rate / 100);
				return output;
			}
		}
			throw new Exception("it is impossible to pay");
	}
	
	@Override
	public String toString() {
		return "Credit [sum=" + sum + ", monthlyPayment=" + monthPayment + ", rate=" + rate
				+ ", clientType=" + clientType.getСlientType() + "]";
	}
	
}
