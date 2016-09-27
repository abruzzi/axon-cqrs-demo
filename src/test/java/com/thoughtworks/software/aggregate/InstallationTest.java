package com.thoughtworks.software.aggregate;

import com.thoughtworks.software.command.InstallSoftwareCommand;
import com.thoughtworks.software.event.SoftwareInstalledEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class InstallationTest {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Installation.class);
    }

    @Test
    public void install_software_command_and_event() throws Exception {
        fixture.given()
                .when(new InstallSoftwareCommand(1))
                .expectEvents(new SoftwareInstalledEvent(1));
    }
}