[//]: # " Copyright (c) 2018, 2019 Oracle and/or its affiliates. All rights reserved. "
[//]: # "  "
[//]: # " This program and the accompanying materials are made available under the "
[//]: # " terms of the Eclipse Distribution License v. 1.0, which is available at "
[//]: # " http://www.eclipse.org/org/documents/edl-v10.php. "
[//]: # "  "
[//]: # " SPDX-License-Identifier: BSD-3-Clause "

# Metro stax-ex

This project contains a few extensions to complement JSR-173 StAX API in the following areas:

* Enable parser instance reuse (which is important in the high-performance environment
like [Eclipse Implementation of JAXB](https://projects.eclipse.org/projects/ee4j.jaxb-impl)
and [Eclipse Metro](https://projects.eclipse.org/projects/ee4j.metro))
* Improve the support for reading from non-text XML infoset, such as [FastInfoset](https://github.com/eclipse-ee4j/jaxb-fi).
* Improve the namespace support.

### Licensing and Governance

stax-ex project is licensed under an [EDL 1.0](LICENSE.md) license.

### More Info

JSR-173 specification documents are available on [jcp.org](https://www.jcp.org/en/jsr/detail?id=173).
