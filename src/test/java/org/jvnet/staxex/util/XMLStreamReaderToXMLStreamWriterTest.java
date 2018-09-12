/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.jvnet.staxex.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.junit.Test;

public class XMLStreamReaderToXMLStreamWriterTest {
	
	@Test
	/** Tests that XMLStreamReaderToXMLStreamWriter.bridge does
	 * not send null namespace prefixes to the XMLStreamWriter because
	 * some writers used by us cannot handle the null prefix
	 * @throws XMLStreamException
	 */
	public void testNullNamespacePrefix() throws XMLStreamException {
		XMLInputFactory infact = XMLInputFactory.newInstance();
		String xmlString = "<sendMessage xmlns=\"http://www.foo.bar/schema/\" xmlns:ns2=\"http://www.foo.bar/types/\">" +
	            "<message xsi:type=\"ns2:someType\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>" +
	            "</sendMessage>";
		XMLStreamReader in = new XMLStreamReaderNullPrefix(infact.createXMLStreamReader(new StringReader(xmlString)));
		StringWriter sw = new StringWriter();
		XMLStreamWriter out = new XMLStreamWriterNoNullPrefixes(XMLOutputFactory.newInstance().createXMLStreamWriter(sw));
		XMLStreamReaderToXMLStreamWriter readerToWriter = new XMLStreamReaderToXMLStreamWriter(); 
		readerToWriter.bridge(in, out);
	}
	
	//Define a delegating XMLStreamReader that always returns null for empty prefix
	//and a delegating XMLStreamWriter that chokes on null prefix
	private static class XMLStreamWriterNoNullPrefixes implements XMLStreamWriter {
		private XMLStreamWriter delegate;

		public XMLStreamWriterNoNullPrefixes(XMLStreamWriter delegate) {
			this.delegate = delegate;
		}

		public void close() throws XMLStreamException {
			delegate.close();
		}

		public void flush() throws XMLStreamException {
			delegate.flush();
		}

		public NamespaceContext getNamespaceContext() {
			return delegate.getNamespaceContext();
		}

		public String getPrefix(String arg0) throws XMLStreamException {
			return delegate.getPrefix(arg0);
		}

		public Object getProperty(String arg0) throws IllegalArgumentException {
			return delegate.getProperty(arg0);
		}

		public void setDefaultNamespace(String arg0) throws XMLStreamException {
			delegate.setDefaultNamespace(arg0);
		}

		public void setNamespaceContext(NamespaceContext arg0)
				throws XMLStreamException {
			delegate.setNamespaceContext(arg0);
		}

		public void setPrefix(String arg0, String arg1)
				throws XMLStreamException {
			delegate.setPrefix(arg0, arg1);
		}

		public void writeAttribute(String arg0, String arg1, String arg2,
				String arg3) throws XMLStreamException {
			delegate.writeAttribute(arg0, arg1, arg2, arg3);
		}

		public void writeAttribute(String arg0, String arg1, String arg2)
				throws XMLStreamException {
			delegate.writeAttribute(arg0, arg1, arg2);
		}

		public void writeAttribute(String arg0, String arg1)
				throws XMLStreamException {
			delegate.writeAttribute(arg0, arg1);
		}

		public void writeCData(String arg0) throws XMLStreamException {
			delegate.writeCData(arg0);
		}

		public void writeCharacters(char[] arg0, int arg1, int arg2)
				throws XMLStreamException {
			delegate.writeCharacters(arg0, arg1, arg2);
		}

		public void writeCharacters(String arg0) throws XMLStreamException {
			delegate.writeCharacters(arg0);
		}

		public void writeComment(String arg0) throws XMLStreamException {
			delegate.writeComment(arg0);
		}

		public void writeDTD(String arg0) throws XMLStreamException {
			delegate.writeDTD(arg0);
		}

		public void writeDefaultNamespace(String arg0)
				throws XMLStreamException {
			delegate.writeDefaultNamespace(arg0);
		}

		public void writeEmptyElement(String arg0, String arg1, String arg2)
				throws XMLStreamException {
			delegate.writeEmptyElement(arg0, arg1, arg2);
		}

		public void writeEmptyElement(String arg0, String arg1)
				throws XMLStreamException {
			delegate.writeEmptyElement(arg0, arg1);
		}

		public void writeEmptyElement(String arg0) throws XMLStreamException {
			delegate.writeEmptyElement(arg0);
		}

		public void writeEndDocument() throws XMLStreamException {
			delegate.writeEndDocument();
		}

		public void writeEndElement() throws XMLStreamException {
			delegate.writeEndElement();
		}

		public void writeEntityRef(String arg0) throws XMLStreamException {
			delegate.writeEntityRef(arg0);
		}

		public void writeNamespace(String prefix, String ns)
				throws XMLStreamException {
			if (prefix == null) throw new XMLStreamException("NS Prefix from XMLStreamReaderToXMLStreamWriter cannot be null!");
			delegate.writeNamespace(prefix, ns);
		}

		public void writeProcessingInstruction(String arg0, String arg1)
				throws XMLStreamException {
			delegate.writeProcessingInstruction(arg0, arg1);
		}

		public void writeProcessingInstruction(String arg0)
				throws XMLStreamException {
			delegate.writeProcessingInstruction(arg0);
		}

		public void writeStartDocument() throws XMLStreamException {
			delegate.writeStartDocument();
		}

		public void writeStartDocument(String arg0, String arg1)
				throws XMLStreamException {
			delegate.writeStartDocument(arg0, arg1);
		}

		public void writeStartDocument(String arg0) throws XMLStreamException {
			delegate.writeStartDocument(arg0);
		}

		public void writeStartElement(String arg0, String arg1, String arg2)
				throws XMLStreamException {
			delegate.writeStartElement(arg0, arg1, arg2);
		}

		public void writeStartElement(String arg0, String arg1)
				throws XMLStreamException {
			delegate.writeStartElement(arg0, arg1);
		}

		public void writeStartElement(String arg0) throws XMLStreamException {
			delegate.writeStartElement(arg0);
		}
	}
	private static class XMLStreamReaderNullPrefix implements XMLStreamReader {
		private XMLStreamReader delegate;

		public XMLStreamReaderNullPrefix(XMLStreamReader reader) {
			delegate = reader;
		}

		public void close() throws XMLStreamException {
			delegate.close();
		}

		public int getAttributeCount() {
			return delegate.getAttributeCount();
		}

		public String getAttributeLocalName(int arg0) {
			return delegate.getAttributeLocalName(arg0);
		}

		public QName getAttributeName(int arg0) {
			return delegate.getAttributeName(arg0);
		}

		public String getAttributeNamespace(int arg0) {
			return delegate.getAttributeNamespace(arg0);
		}

		public String getAttributePrefix(int arg0) {
			return delegate.getAttributePrefix(arg0);
		}

		public String getAttributeType(int arg0) {
			return delegate.getAttributeType(arg0);
		}

		public String getAttributeValue(int arg0) {
			return delegate.getAttributeValue(arg0);
		}

		public String getAttributeValue(String arg0, String arg1) {
			return delegate.getAttributeValue(arg0, arg1);
		}

		public String getCharacterEncodingScheme() {
			return delegate.getCharacterEncodingScheme();
		}

		public String getElementText() throws XMLStreamException {
			return delegate.getElementText();
		}

		public String getEncoding() {
			return delegate.getEncoding();
		}

		public int getEventType() {
			return delegate.getEventType();
		}

		public String getLocalName() {
			return delegate.getLocalName();
		}

		public Location getLocation() {
			return delegate.getLocation();
		}

		public QName getName() {
			return delegate.getName();
		}

		public NamespaceContext getNamespaceContext() {
			return delegate.getNamespaceContext();
		}

		public int getNamespaceCount() {
			return delegate.getNamespaceCount();
		}

		public String getNamespacePrefix(int arg0) {
			String prefix = delegate.getNamespacePrefix(arg0);
			if ("".equals(prefix)) return null;
			return prefix;
		}

		public String getNamespaceURI() {
			return delegate.getNamespaceURI();
		}

		public String getNamespaceURI(int arg0) {
			return delegate.getNamespaceURI(arg0);
		}

		public String getNamespaceURI(String arg0) {
			return delegate.getNamespaceURI(arg0);
		}

		public String getPIData() {
			return delegate.getPIData();
		}

		public String getPITarget() {
			return delegate.getPITarget();
		}

		public String getPrefix() {
			return delegate.getPrefix();
		}

		public Object getProperty(String arg0) throws IllegalArgumentException {
			return delegate.getProperty(arg0);
		}

		public String getText() {
			return delegate.getText();
		}

		public char[] getTextCharacters() {
			return delegate.getTextCharacters();
		}

		public int getTextCharacters(int arg0, char[] arg1, int arg2, int arg3)
				throws XMLStreamException {
			return delegate.getTextCharacters(arg0, arg1, arg2, arg3);
		}

		public int getTextLength() {
			return delegate.getTextLength();
		}

		public int getTextStart() {
			return delegate.getTextStart();
		}

		public String getVersion() {
			return delegate.getVersion();
		}

		public boolean hasName() {
			return delegate.hasName();
		}

		public boolean hasNext() throws XMLStreamException {
			return delegate.hasNext();
		}

		public boolean hasText() {
			return delegate.hasText();
		}

		public boolean isAttributeSpecified(int arg0) {
			return delegate.isAttributeSpecified(arg0);
		}

		public boolean isCharacters() {
			return delegate.isCharacters();
		}

		public boolean isEndElement() {
			return delegate.isEndElement();
		}

		public boolean isStandalone() {
			return delegate.isStandalone();
		}

		public boolean isStartElement() {
			return delegate.isStartElement();
		}

		public boolean isWhiteSpace() {
			return delegate.isWhiteSpace();
		}

		public int next() throws XMLStreamException {
			return delegate.next();
		}

		public int nextTag() throws XMLStreamException {
			return delegate.nextTag();
		}

		public void require(int arg0, String arg1, String arg2)
				throws XMLStreamException {
			delegate.require(arg0, arg1, arg2);
		}

		public boolean standaloneSet() {
			return delegate.standaloneSet();
		}
	}
	
}
