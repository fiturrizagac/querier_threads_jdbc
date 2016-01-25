/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 03:21 PM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties extends Properties {

    private static Properties _properties;

    public static void load() throws IOException {
        InputStream is = AppProperties.class.getResourceAsStream("/properties/app.properties");
        _properties = new Properties();
        _properties.load(is);
    }

    public static String getProperty(KeyProperty key){
        return _properties.getProperty(key.getKey());
    }

    public static int getPropertyAsInteger(KeyProperty key){
        return Integer.parseInt(_properties.getProperty(key.getKey()));
    }

    public enum KeyProperty {
        USER("app.user"),
        PASSWORD("app.password"),
        URL("app.url"),
        THREADS_NUMBER("app.threads_number");

        private String _key;

        KeyProperty(String key){
            _key=key;
        }

        public String getKey(){
            return _key;
        }
    }


}
