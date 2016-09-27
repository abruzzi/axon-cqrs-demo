package com.thoughtworks.software;

import com.thoughtworks.software.aggregate.Installation;
import com.thoughtworks.software.command.InstallSoftwareCommand;
import com.thoughtworks.software.handler.SoftwareInstalledEventHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CommandBus commandBus = new SimpleCommandBus();
        CommandGateway commandGateway = new DefaultCommandGateway(commandBus);
        EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./events")));
        EventBus eventBus = new SimpleEventBus();

        EventSourcingRepository<Installation> repository = new EventSourcingRepository<>(Installation.class, eventStore);
        repository.setEventBus(eventBus);

        AggregateAnnotationCommandHandler.subscribe(Installation.class, repository, commandBus);
        AnnotationEventListenerAdapter.subscribe(new SoftwareInstalledEventHandler(), eventBus);

        commandGateway.send(new InstallSoftwareCommand(1));
        commandGateway.send(new InstallSoftwareCommand(2));
    }
}
