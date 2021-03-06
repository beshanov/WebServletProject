package entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Entry {
    String data;
    int id;
    String created;

    @Override
    public String toString(){
        return data + " || " + created + "\n";
    }
}
