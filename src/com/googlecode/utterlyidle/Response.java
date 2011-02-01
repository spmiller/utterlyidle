package com.googlecode.utterlyidle;

import com.googlecode.totallylazy.Pair;
import com.googlecode.utterlyidle.cookies.Cookie;

import java.io.Closeable;
import java.io.OutputStream;

public interface Response {
    Status status();

    Response status(Status value);

    String header(String name);

    Iterable<String> headers(String name);

    Iterable<Pair<String, String>> headers();

    Response header(String name, String value);

    Response cookie(String name, Cookie value);

    OutputStream output();

    byte[] bytes();

    Response bytes(byte[] value);

    Object entity();

    Response entity(Object value);

}
