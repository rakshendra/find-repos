package com.assignmnet.findrepos.model;

public class MinimalRepo {

    private String id;
    private String full_name;
    private String html_url;
    private Owner owner;

    public MinimalRepo(String id, String full_name, String html_url, Owner owner) {
        this.id = id;
        this.full_name = full_name;
        this.html_url = html_url;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    private static class Owner{
        private String login;

        public Owner(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }
}
