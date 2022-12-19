package by.a1qa.task2_1.driver.bean;

import java.util.Objects;

public class GameInformation {
    String name;
    Platform platform;
    String releaseDate;
    String reviewSummaryResult;
    String price;

    public GameInformation() {
    }

    public GameInformation(String name, Platform platform, String releaseDate, String reviewSummaryResult, String price) {
        this.name = name;
        this.platform = platform;
        this.releaseDate = releaseDate;
        this.reviewSummaryResult = reviewSummaryResult;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReviewSummaryResult() {
        return reviewSummaryResult;
    }

    public void setReviewSummaryResult(String reviewSummaryResult) {
        this.reviewSummaryResult = reviewSummaryResult;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameInformation)) return false;
        GameInformation that = (GameInformation) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getPlatform(), that.getPlatform()) && Objects.equals(getReleaseDate(), that.getReleaseDate()) && Objects.equals(getReviewSummaryResult(), that.getReviewSummaryResult()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPlatform(), getReleaseDate(), getReviewSummaryResult(), getPrice());
    }

    @Override
    public String toString() {
        return "GameInformation{" +
                "name='" + name + '\'' +
                ", platform=" + platform +
                ", releaseDate='" + releaseDate + '\'' +
                ", reviewSummaryResult='" + reviewSummaryResult + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
