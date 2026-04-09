/*
 * Copyright (c) 2026 Contributors to the Eclipse Foundation.
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package org.jvnet.staxex;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * A StAxSOAPBody is a SOAPBody that allows to be loaded from a StAX style
 * payload.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface StAxSOAPBody {

    /**
     * The StAxSOAPBody represents the StAX source of SOAPBody payload.
     */
    interface Payload {

        /**
         * Retrieve payload qname without materializing its contents
         *
         * @return qname
         */
        QName getPayloadQName();

        XMLStreamReader readPayload() throws XMLStreamException;

        void writePayloadTo(XMLStreamWriter writer) throws XMLStreamException;

        /**
         * Retrieve payload attribute value without materializing its contents
         *
         * @param localName attribute local name
         * @return payload attribute value
         * @throws XMLStreamException for errors
         */
        String getPayloadAttributeValue(String localName) throws XMLStreamException;

        /**
         * Retrieve payload attribute value without materializing its contents
         *
         * @param qName attribute QName
         * @return payload attribute value
         * @throws XMLStreamException for errors
         */
        String getPayloadAttributeValue(QName qName) throws XMLStreamException;

        void materialize() throws XMLStreamException;
    }

    void setPayload(Payload src) throws XMLStreamException;

    Payload getPayload() throws XMLStreamException;

    boolean hasStaxPayload();
}
