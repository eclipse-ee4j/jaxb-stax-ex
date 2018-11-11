/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

module org.jvnet.staxex {
    requires java.logging;
    requires java.xml.bind;

    requires transitive jakarta.activation;
    requires transitive java.xml;
    exports org.jvnet.staxex;
    exports org.jvnet.staxex.util;
}
