package com.ultrahob.configuration.handlers;

import com.intellij.openapi.components.ApplicationComponent;
import com.ultrahob.configuration.ConfigurationManager;

/**
 * @author Victor Rosenberg, 10.05.2014 19:17
 */
public abstract class BaseConfigurationHelper implements ConfigurationHandler, ApplicationComponent {

    public void initComponent() {
        ConfigurationManager.getInstance().registerHandler(this);
    }

    public void disposeComponent() {
        ConfigurationManager.getInstance().unregisterHandler(this);
    }
}
