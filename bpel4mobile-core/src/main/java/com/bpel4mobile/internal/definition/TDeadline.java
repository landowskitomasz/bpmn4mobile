//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.11 at 10:15:06 PM CEST 
//


package com.bpel4mobile.internal.definition;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;




@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDeadline", propOrder = {
    "_for",
    "escalation"
})
public class TDeadline {

    @XmlElement(name = "for")
    protected String _for;
    
    protected List<TEscalation> escalation;
    
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    public String getFor() {
        return _for;
    }

    public void setFor(String value) {
        this._for = value;
    }

    public List<TEscalation> getEscalation() {
        if (escalation == null) {
            escalation = new ArrayList<TEscalation>();
        }
        return this.escalation;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String value) {
        this.name = value;
    }

}
