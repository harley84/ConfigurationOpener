package com.ultrahob.configuration.handlers;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;

/**
 * @author Victor Rosenberg, 10.05.2014 19:03
 */
public interface ConfigurationHandler {

    public boolean canHandle(RunConfiguration configuration, Project project);
}




