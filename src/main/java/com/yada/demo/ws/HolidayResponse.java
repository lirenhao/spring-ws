package com.yada.demo.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hr")
public class HolidayResponse {

    public HolidayResponse() {
    }

    public HolidayResponse(String result) {
        this.result = result;
    }

    private String result;

    @XmlElement(name = "RESULT")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
