package com.fpoly.helper;

import java.util.Base64;

public class JWTHelper {

    public static String decodePayload(String jwt){
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = jwt.substring(jwt.indexOf(".") + 1, jwt.lastIndexOf("."));
        return new String(decoder.decode(payload));
    }

    public static String getUsername(String jwt){
        String payload = decodePayload(jwt);
        return payload.substring(payload.indexOf(":") + 2, payload.indexOf(",") - 1);
    }
}
