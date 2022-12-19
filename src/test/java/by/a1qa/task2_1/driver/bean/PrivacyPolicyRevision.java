package by.a1qa.task2_1.driver.bean;

import java.util.Objects;

public class PrivacyPolicyRevision {

    String policyRevision;

    public PrivacyPolicyRevision(){}

    public PrivacyPolicyRevision(String policyRevision) {
        this.policyRevision = policyRevision;
    }

    public String getPolicyRevision() {
        return policyRevision;
    }

    public void setPolicyRevision(String policyRevision) {
        this.policyRevision = policyRevision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivacyPolicyRevision)) return false;
        PrivacyPolicyRevision that = (PrivacyPolicyRevision) o;
        return Objects.equals(getPolicyRevision(), that.getPolicyRevision());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolicyRevision());
    }

    @Override
    public String toString() {
        return "PrivacyPolicyRevision{" +
                "policyRevision='" + policyRevision + '\'' +
                '}';
    }
}


