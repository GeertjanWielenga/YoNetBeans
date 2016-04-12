package org.netbeans.modules.yo.template2;

public class YeomanGeneratorObject {

    String name;
    String description;
    String owner;
    String ownerWebsite;
    String website;
    int stars;
    String created;
    String updated;
    int forks;
    boolean installed;
    private String generatorsPath;

    public YeomanGeneratorObject(String name, String generatorsPath) {
        this.name = name;
        this.installed = true;
        this.generatorsPath = generatorsPath;
    }

    public String getGeneratorsPath() {
        return generatorsPath;
    }

    public YeomanGeneratorObject(int stars,boolean installed,String name, String description, String owner, String website, String ownerWebsite) {
        this.installed = installed;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.website = website;
        this.stars = stars;
        this.ownerWebsite = ownerWebsite;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getOwnerWebsite() {
        return ownerWebsite;
    }

    public String getWebsite() {
        return website;
    }

    public int getStars() {
        return stars;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

}
