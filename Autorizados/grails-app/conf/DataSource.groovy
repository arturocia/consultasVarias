dataSource {
    username = "sa"
	password = "bimalatrop2014"
	url = "jdbc:sqlserver://bimalatrop.no-ip.biz:1433;databaseName=dbamibsumautorizados"

	driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
	dialect = "org.hibernate.dialect.SQLServerDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
		
		// Change the values of these properties to the username, password and hostname
		// for your SQL Server database
		username = "sa"
		password = "bimalatrop2014"
		url = "jdbc:sqlserver://bima-devqa-serv:1433;databaseName=dbamibsumautorizados"
	
		driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
		dialect = "org.hibernate.dialect.SQLServerDialect"
	
		
		
        
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
		username = "sa"
		password = "bimalatrop2014"
		url = "jdbc:sqlserver://bima-devqa-serv:1433;databaseName=dbamibsumautorizados"
	
		driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
		dialect = "org.hibernate.dialect.SQLServerDialect"
    }
}
