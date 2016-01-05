package retrofit2;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;


/**
 * Created by zhangxingxing-PC on 2015/12/16.
 */
public class FastjsonConverterFactory extends Converter.Factory {


    public static FastjsonConverterFactory create(){
        return new FastjsonConverterFactory();
    }


    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new FastjsonResponseBodyConverter<>(type);
    }

    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new FastjsonRequestBodyConverter<>(type);
    }
}
