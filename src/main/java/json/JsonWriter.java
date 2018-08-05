package json;

import com.google.gson.Gson;
import entities.Entry;

import java.util.List;

public class JsonWriter {

    public static String returnEntryJson(Entry entry){
    Gson gson = new Gson();
    return gson.toJson(entry, Entry.class);
    }

    public static String returnEntryListJson(List<Entry> entryList){
        Gson gson = new Gson();
        return  gson.toJson(entryList);
    }
}
