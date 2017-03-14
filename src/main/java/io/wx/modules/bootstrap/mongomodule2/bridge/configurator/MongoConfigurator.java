/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.wx.modules.bootstrap.mongomodule2.bridge.configurator;

import de.aptly.commons.configuration.schema.builder.NodeBuilder;
import de.aptly.commons.configuration.schema.builder.ObjectNodeDefinition;
import io.wx.bootstrap.configurator.Configurator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author joshi
 */
public final class MongoConfigurator extends io.wx.modules.mongo.MongoConfigurator implements Configurator {

    private Map<String, ? extends Object> config;
    
    @Override
    public void configure(ObjectNodeDefinition builder) {
        Objects.requireNonNull(builder);
        builder
                .children()
                        .textNode("poolName").required().end()
                        .objectNode("persistorConfig")
                                .required()
                                .children()
                                    .textNode("url").required().end()
                                .end()
                        .end()
                .end();
    }

    @Override
    public String getConfigurationKeyName() {
        return "mongo";
    }

    @Override
    public void setConfig(Map<String, ? extends Object> config) {
        Objects.requireNonNull(config);
        this.config = config;
    }

    @Override
    public Map<String, ? extends Object> getConfig() {
        return config;
    }
}
