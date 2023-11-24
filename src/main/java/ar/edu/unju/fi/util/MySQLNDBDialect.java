package ar.edu.unju.fi.util;

import org.hibernate.dialect.MySQLDialect;

public class MySQLNDBDialect extends MySQLDialect
{
    private static final String ENGINE_NDB = " ENGINE=NDB"; //$NON-NLS-1$

    @Override
    public boolean supportsCascadeDelete()
    {
        return true;
    }

    @Override
    public boolean dropConstraints()
    {
        return true;
    }

    @Override
    public String getTableTypeString()
    {
        return ENGINE_NDB;
    }
}