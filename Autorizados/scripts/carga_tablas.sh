#!/bin/sh
# http://stackoverflow.com/questions/13096018/freetds-bash-executing-sql-queries-in-microsoft-sql-server
# http://stackoverflow.com/questions/15242757/import-csv-file-into-sql-server
tsql -S servidorDesarrollo -U sa -P bimalatrop2014 <<EOF
BULK INSERT t009_d_certpuntos
    FROM '/Users/ernesto/workspace/Autorizados/scripts/test.pl'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ',',  --CSV field delimiter
    ROWTERMINATOR = '\n',   --Use to shift the control to next row
    ERRORFILE = 'C:\CSVDATA\SchoolsErrorRows.csv',
    TABLOCK
    )
EOF
