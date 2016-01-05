package retrofit2;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by zhangxingxing-PC on 2015/12/16.
 */
public class FastjsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    private static final int BUFFER_SIZE = 0x400; // 1024

    FastjsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    public T convert(ResponseBody value) throws IOException {

        Reader reader = value.charStream();
        Object var3;
        try {

            StringBuilder sb = new StringBuilder();
            char[] buf = new char[BUFFER_SIZE];
            for (;;) {
                int res = reader.read(buf, 0, buf.length);
                if (res < 0) {
                    break;
                }
                sb.append(buf, 0, res);
            }
            var3 = JSON.parseObject(sb.toString(), this.type);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException var2) {
                }

            }
        }

        return (T)var3;
    }

}
