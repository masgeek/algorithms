package com.munywele.oop;

import javax.xml.crypto.dsig.XMLObject;
import java.io.Reader;

public interface XMLReader {
    public XMLObject fromString(String str);

    public XMLObject fromReader(Reader in);
}
