package by.a1qa.task2_1.driver.bean;

import java.util.Objects;

public class Platform {
    String windows;
    String macOS;
    String steamOS;
    String remixeMusic;

    public Platform(){};

    public Platform(String remixeMusic) {
        this.remixeMusic = remixeMusic;
    }

    public Platform(String windows, String macOS) {
        this.windows = windows;
        this.macOS = macOS;
    }

    public Platform(String windows, String macOS, String steamOS) {
        this.windows = windows;
        this.macOS = macOS;
        this.steamOS = steamOS;
    }

    public Platform(String windows, String macOS, String steamOS, String remixeMusic) {
        this.windows = windows;
        this.macOS = macOS;
        this.steamOS = steamOS;
        this.remixeMusic = remixeMusic;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public String getMacOS() {
        return macOS;
    }

    public void setMacOS(String macOS) {
        this.macOS = macOS;
    }

    public String getSteamOS() {
        return steamOS;
    }

    public void setSteamOS(String steamOS) {
        this.steamOS = steamOS;
    }

    public String getRemixeMusic() {
        return remixeMusic;
    }

    public void setRemixeMusic(String remixeMusic) {
        this.remixeMusic = remixeMusic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Platform)) return false;
        Platform platform = (Platform) o;
        return Objects.equals(getWindows(), platform.getWindows()) && Objects.equals(getMacOS(), platform.getMacOS()) && Objects.equals(getSteamOS(), platform.getSteamOS()) && Objects.equals(getRemixeMusic(), platform.getRemixeMusic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWindows(), getMacOS(), getSteamOS(), getRemixeMusic());
    }

    @Override
    public String toString() {
        return "Platform{" +
                "windows=" + windows +
                ", macOS=" + macOS +
                ", steamOS=" + steamOS +
                ", remixeMusic=" + remixeMusic +
                '}';
    }
}
