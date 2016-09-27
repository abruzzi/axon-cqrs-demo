package com.thoughtworks.software.event;

public class SoftwareInstalledEvent {
    private long installationId;

    public SoftwareInstalledEvent(long installationId) {
        this.installationId = installationId;
    }

    public long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(long installationId) {
        this.installationId = installationId;
    }
}
