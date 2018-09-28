package com.examprel.examprep;

public class Data {
    private String name,standard,stream;
    public  Data(String name, String standard, String stream){
   this.name = name;
   this.standard = standard;
   this.stream = stream;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }


}
