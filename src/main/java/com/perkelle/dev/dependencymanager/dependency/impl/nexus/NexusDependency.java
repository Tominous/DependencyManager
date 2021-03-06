package com.perkelle.dev.dependencymanager.dependency.impl.nexus;

import com.perkelle.dev.dependencymanager.dependency.Dependency;
import org.bukkit.plugin.Plugin;

import java.net.MalformedURLException;
import java.net.URL;

public class NexusDependency extends Dependency {

    private final String rootUrl;
    private final String group, artifact, version;

    public NexusDependency(Plugin owner, String rootUrl, String group, String artifact, String version) {
        super(owner);

        if(rootUrl.endsWith("/"))
            this.rootUrl = rootUrl;
        else
            this.rootUrl = rootUrl + "/";

        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    protected URL buildUrl() throws MalformedURLException {
        String groupSlashed = String.join("/", group.split("\\."));
        String jarName = String.format("%s-%s.jar", artifact, version);
        return new URL(String.format("%s/%s/%s/%s/%s", rootUrl, groupSlashed, artifact, version, jarName));
    }

    @Override
    protected String getLocalName() {
        return String.format("%s:%s:%s.jar", group, artifact, version);
    }
}
