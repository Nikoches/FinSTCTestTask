import java.util.HashMap;

public class ArgsParser {
    private HashMap<String, String> mapParametrs = new HashMap<>();

    public ArgsParser(String... args) {
            mapParametrs.put("SourceXml", args[0]);
            mapParametrs.put("SourceXsd", args[1]);
            mapParametrs.put("SourceXslt", args[2]);
            mapParametrs.put("resultXml", args[3]);
    }

    public String getRes(String key) {
        return mapParametrs.getOrDefault(key, "null");
    }
}
