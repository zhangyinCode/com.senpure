package com.senpure.base.util;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017/1/11.
 */
@Plugin(name = "AnsiConsole", category = "Core", elementType = "appender", printObject = true)
public class AnsiConsoleAppender extends AbstractAppender {

    protected AnsiConsoleAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout, final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {


        out.println(event.getMessage());

    }

    @PluginFactory
    public static AnsiConsoleAppender createAppender(@PluginAttribute("name") String name,
                                                     @PluginElement("Filter") final Filter filter,
                                                     @PluginElement("Layout") Layout<? extends Serializable> layout,
                                                     @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {

        if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImpl");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new AnsiConsoleAppender(name, filter, layout, ignoreExceptions);
    }
}
