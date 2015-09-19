package com.ykh.services.conference.adapter;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MapElements {
    public String key;
    public String value;

    private MapElements() {
    } //Required by JAXB

    public MapElements(String key, String value) {
        this.key = key;
        this.value = value;
    }


}
