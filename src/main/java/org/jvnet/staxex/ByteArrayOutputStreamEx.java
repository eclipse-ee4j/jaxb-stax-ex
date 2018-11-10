/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.jvnet.staxex;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 * {@link ByteArrayOutputStream} with access to its raw buffer.
 *
 * @author Kohsuke Kawaguchi
 */
final class ByteArrayOutputStreamEx extends ByteArrayOutputStream {
    public ByteArrayOutputStreamEx() {
    }

    public ByteArrayOutputStreamEx(int size) {
        super(size);
    }

    public void set(Base64Data dt,String mimeType) {
        dt.set(buf,count,mimeType);
    }

    public byte[] getBuffer() {
        return buf;
    }

    /**
     * Reads the given {@link InputStream} completely into the buffer.
     */
    public void readFrom(InputStream is) throws IOException {
        while(true) {
            if(count==buf.length) {
                // realllocate
                byte[] data = new byte[buf.length*2];
                System.arraycopy(buf,0,data,0,buf.length);
                buf = data;
            }

            int sz = is.read(buf,count,buf.length-count);
            if(sz<0)     return;
            count += sz;
        }
    }
}
