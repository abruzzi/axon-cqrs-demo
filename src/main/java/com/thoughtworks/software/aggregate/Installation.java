package com.thoughtworks.software.aggregate;

import com.thoughtworks.software.command.InstallSoftwareCommand;
import com.thoughtworks.software.event.SoftwareInstalledEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Installation extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private long id;

    public Installation() {
    }

    @CommandHandler
    public Installation(InstallSoftwareCommand command) {
        //install it
        apply(new SoftwareInstalledEvent(command.getInstallationId()));
    }

}
