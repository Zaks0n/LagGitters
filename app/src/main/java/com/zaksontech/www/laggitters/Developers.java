package com.zaksontech.www.laggitters;

/**
 * Created by Zaks0n on 8/22/2017.
 */

public class Developers {

    private String userName;
    private String avatar_url;
    private String url;


    public String getUserName() {
        return userName;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return url;
    }


    public Developers(String userName, String gitUrl, String avatar_url) {
        this.userName = userName;
        this.avatar_url = avatar_url;
        this.url = gitUrl;

    }

}
