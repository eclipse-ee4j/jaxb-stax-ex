[//]: # " Copyright (c) 2018, 2021 Oracle and/or its affiliates. All rights reserved. "
[//]: # "  "
[//]: # " This program and the accompanying materials are made available under the "
[//]: # " terms of the Eclipse Distribution License v. 1.0, which is available at "
[//]: # " http://www.eclipse.org/org/documents/edl-v10.php. "
[//]: # "  "
[//]: # " SPDX-License-Identifier: BSD-3-Clause "

# Extended StAX API

This project contains a few extensions to complement JSR-173 StAX API in the following areas:

* Enable parser instance reuse (which is important in the high-performance environment
like [Eclipse Implementation of JAXB](https://projects.eclipse.org/projects/ee4j.jaxb-impl)
and [Eclipse Metro](https://projects.eclipse.org/projects/ee4j.metro))
* Improve the support for reading from non-text XML infoset, such as [FastInfoset](https://github.com/eclipse-ee4j/jaxb-fi).
* Improve the namespace support.

This project is part of [Eclipse Implementation of JAXB](https://projects.eclipse.org/projects/ee4j.jaxb-impl).


## License

Extended StAX API is licensed under a license - [EDL 1.0](LICENSE.md).


## Contributing

We use [contribution policy](CONTRIBUTING.md), which means we can only accept contributions under
the terms of [Eclipse Contributor Agreement](http://www.eclipse.org/legal/ECA.php).


## Links

* [JSR-173 specification documents](https://www.jcp.org/en/jsr/detail?id=173)
* [Javadoc](https://javadoc.io/doc/org.jvnet.staxex/stax-ex/latest/org.jvnet.staxex/module-summary.html)
* [Mailing list](https://accounts.eclipse.org/mailing-list/jaxb-impl-dev)
