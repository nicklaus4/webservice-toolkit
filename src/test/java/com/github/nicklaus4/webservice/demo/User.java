package com.github.nicklaus4.webservice.demo;

import java.io.Serializable;

/**
 * user dto
 *
 * @author weishibai
 * @date 2019/03/26 10:20 PM
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
