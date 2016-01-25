/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 12:42 PM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.jdbc;

import java.sql.Connection;

public interface Connectable {

    Connection getConnection();

    void close(Connection connection);

}
