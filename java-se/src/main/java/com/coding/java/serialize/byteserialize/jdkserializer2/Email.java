package com.coding.java.serialize.byteserialize.jdkserializer2;

import java.io.Serializable;

/**
 * @author scq
 */
public class Email implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "content='" + content + '\'' +
                '}';
    }
}
