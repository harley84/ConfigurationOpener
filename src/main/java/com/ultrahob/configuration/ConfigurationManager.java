package com.ultrahob.configuration;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.ultrahob.configuration.handlers.ConfigurationHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Victor Rosenberg, 10.05.2014 19:00
 */
public class ConfigurationManager  {

    private static final ConfigurationManager configurationManager = new ConfigurationManager();

    public static ConfigurationManager getInstance() {
        return configurationManager;
    }

    private Set<ConfigurationHandler> handlers = new HashSet<ConfigurationHandler>();


    public void registerHandler(ConfigurationHandler handler) {
       handlers.add(handler);
    }

    public void unregisterHandler(ConfigurationHandler handler) {
        handlers.remove(handler);
    }

    public boolean tryHandling(RunConfiguration configuration, Project project) {
        for (ConfigurationHandler handler : handlers) {
            if (handler.canHandle(configuration, project)) {
                return true;
            }
        }
        return false;
    }
}
