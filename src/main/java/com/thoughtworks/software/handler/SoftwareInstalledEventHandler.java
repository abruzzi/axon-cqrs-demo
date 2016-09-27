package com.thoughtworks.software.handler;

import com.thoughtworks.software.event.SoftwareInstalledEvent;
import org.axonframework.eventhandling.annotation.EventHandler;

public class SoftwareInstalledEventHandler {

    @EventHandler
    public void handle(SoftwareInstalledEvent event) {
        System.err.println("..." + event.getInstallationId() + "...");
    }
}
