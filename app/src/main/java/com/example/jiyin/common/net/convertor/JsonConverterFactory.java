package com.example.jiyin.common.net.convertor;


import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class JsonConverterFactory extends Converter.Factory {


    public static JsonConverterFactory create() {
        return new JsonConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {

        return new JsonResponseBodyConverter<>(type);
    }

    @Override
    public Converter<File, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FileRequestBodyConverter();
    }
}

class FileRequestBodyConverter implements Converter<File, RequestBody> {
    @Override
    public RequestBody convert(File file) throws IOException {
        return RequestBody.create(MediaType.parse("application/otcet-stream"), file);
    }
}

