public class Credit {
    float sum;
    float monthPayment;
    float rate;
    СlientType clientType;
    float output;
    float yearPayment;
    float yearOutput;

    public Credit(float sum, float monthPayment, float rate, String clientType) {
        this.sum = sum;
        this.monthPayment = monthPayment;
        this.rate = rate;
        this.clientType = СlientType.valueOf(clientType);
    }

    /* depending on the clientType, calls a calculateHuman method or a calculateBusiness method */
    public float calculate(СlientType clientType) throws Exception {
        yearPayment = 12 * monthPayment;
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

    /* Returns calculated overpayment for Human clientType */
    public float calculateHuman() throws Exception {
        if (sum > 0 && (yearPayment > sum / 6)) {
            output = sum * rate / 100;
            for (int i = 0; sum > yearPayment; i++) {
                sum -= yearPayment;
                yearOutput = sum * rate / 100;
                sum += yearOutput;
                output += yearOutput;
            }
            return output;
        }
        throw new Exception("it is impossible to pay");
    }

    /* Returns calculated overpayment for Business clientType */
    @SuppressWarnings("unused")
    public float calculateBusiness() throws Exception {
        if (sum > 0 && (yearPayment > sum / 6)) {
            output = 0;
            for (int i = 0; sum > yearPayment; i++) {
                sum -= yearPayment;
                yearOutput = sum * rate / 100;
                sum += yearOutput;
                output += yearOutput;
            }
            return output;
        }
        throw new Exception("it is impossible to pay");
    }

    @Override
    public String toString() {
        return "Credit [sum=" + sum + ", monthlyPayment=" + monthPayment + ", rate=" + rate + ", clientType="
                + clientType.getСlientType() + "]";
    }

}