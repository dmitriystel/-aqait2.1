package by.a1qa.task2_1.bean;

import java.util.Objects;

public class PrivacyPolicyRevison {

    String policyRevisionText;

    public PrivacyPolicyRevison(String policyRevisionText) {
        this.policyRevisionText = policyRevisionText;
    }

    public String getPolicyRevisionText() {
        return policyRevisionText;
    }

    public void setPolicyRevisionText(String policyRevisionText) {
        this.policyRevisionText = policyRevisionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivacyPolicyRevison)) return false;
        PrivacyPolicyRevison that = (PrivacyPolicyRevison) o;
        return Objects.equals(getPolicyRevisionText(), that.getPolicyRevisionText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolicyRevisionText());
    }

    @Override
    public String toString() {
        return "PrivacyPolicyRevison{" +
                "policyRevisionText='" + policyRevisionText + '\'' +
                '}';
    }
}


