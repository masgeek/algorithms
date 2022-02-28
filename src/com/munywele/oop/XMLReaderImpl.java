package com.munywele.oop;

import javax.xml.crypto.dsig.XMLObject;
import java.io.Reader;
import java.io.StringReader;

public abstract class XMLReaderImpl implements XMLReader {

    public XMLObject fromString(String str) {
        return fromReader(new StringReader(str));
    }

    public abstract XMLObject fromReader(Reader in);
}
