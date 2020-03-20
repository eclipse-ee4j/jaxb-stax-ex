/*
 * Copyright (c) 2013, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.jvnet.staxex;

import jakarta.activation.DataHandler;

/**
 * BinaryText represents a MTOM attachment.
 * 
 * @author shih-chang.chen@oracle.com
 */
public interface BinaryText {
    public String getHref();
    public DataHandler getDataHandler();
}
