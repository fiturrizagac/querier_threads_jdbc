/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 09:28 AM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.dao.impl.jdbc.mysql;

public interface QueryTimeCalculable {

    void calculateQueryTime();

    Long getTotalQueryTime();

}
