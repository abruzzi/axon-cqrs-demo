package com.thoughtworks.software.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class InstallSoftwareCommand {
    @TargetAggregateIdentifier
    private long installationId;

    public InstallSoftwareCommand(long installationId) {
        this.installationId = installationId;
    }

    public long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(long installationId) {
        this.installationId = installationId;
    }
}
