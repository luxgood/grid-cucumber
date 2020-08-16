package tools;

public enum DriverType {

    CHROME("chrome"),
    FIREFOX("firefox"),
    OPERA("opera"),
    EDGE("edge");

    private String type;

    DriverType(String type){
        this.type = type;
    }
}
