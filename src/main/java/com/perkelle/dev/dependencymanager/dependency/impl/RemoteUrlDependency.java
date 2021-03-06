package com.perkelle.dev.dependencymanager.dependency.impl;

import com.perkelle.dev.dependencymanager.dependency.Dependency;
import org.bukkit.plugin.Plugin;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteUrlDependency extends Dependency {

    private final String url;

    public RemoteUrlDependency(Plugin owner, String url) {
        super(owner);

        this.url = url;
    }

    @Override
    protected URL buildUrl() throws MalformedURLException {
        return new URL(url);
    }

    @Override
    protected String getLocalName() {
        String fileName = String.format("url:%s", url);
        fileName = fileName.replace("https://", "");
        fileName = fileName.replace("http://", "");
        fileName = fileName.replace("/", ".");

        return fileName;
    }
}
