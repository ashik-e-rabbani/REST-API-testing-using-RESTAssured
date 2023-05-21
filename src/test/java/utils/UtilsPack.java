package utils;

import com.google.gson.Gson;

import java.util.Map;

public class UtilsPack {

    public static String mapToJsonString(Map<String, Object> keyValueMap) {

        // Convert the model object to JSON string using Gson library
        Gson gson = new Gson();
        String jsonString = gson.toJson(keyValueMap);

        return jsonString;
    }

    public static String jsonTextToString(Map<String, Object> keyValueMap) {

        // Convert the model object to JSON string using Gson library
        Gson gson = new Gson();
        String jsonString = gson.toJson(keyValueMap);

        return jsonString;
    }

}
