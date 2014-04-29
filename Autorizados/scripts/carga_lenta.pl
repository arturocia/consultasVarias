use strict;
use Text::Iconv;
use Spreadsheet::XLSX;
use DBI;
my $converter = Text::Iconv->new( "utf-8", "windows-1251" );

# Text::Iconv is not really required.
# This can be any object with the convert method. Or nothing.

my $user   = "sa";
my $passwd = "bimalatrop2014";

# http://stackoverflow.com/questions/896985/connect-to-sql-server-2005-from-perl-and-do-a-select
my $dbh =
  DBI->connect(
	"DBI:Sybase:server=servidorDesarrollo;database=dbamibsumautorizados",
	$user, $passwd, { RaiseError => 1 } )
  or die $DBI::errstr;

my $excel = Spreadsheet::XLSX->new( 'test.xlsx', $converter );

my @valores = ();
my $primera = 1;

# tx_fhfinvigant=folio
# tx_fniniciovigant=revalido
my $sth = $dbh->prepare(
qq{insert into t010_d_certexperiencia (tx_matricula,tx_fhfinvigant,tx_apaterno,tx_amaterno,tx_nombre,tx_figura,tx_fhiniciovigant,tx_institucion,
		tx_tipoinstitucion,tx_idfiguracert,tx_fhemisioncarta,tx_fhiniciovignva,tx_fhfinvignva,tx_estatus) 
		values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}
);

foreach my $sheet ( @{ $excel->{Worksheet} } ) {

	printf( "Sheet: %s\n", $sheet->{Name} );

	$sheet->{MaxRow} ||= $sheet->{MinRow};

	foreach my $row ( $sheet->{MinRow} .. $sheet->{MaxRow} ) {

		$sheet->{MaxCol} ||= $sheet->{MinCol};

		undef(@valores);

		foreach my $col ( $sheet->{MinCol} .. $sheet->{MaxCol} - 1 ) {
			my $cell = $sheet->{Cells}[$row][$col];
			if ($cell) {

				#				printf( "( %s , %s ) => %s;", $row, $col, $cell->{Val} );
				#				printf( " %s |", $cell->{Val} );
				push( @valores, $cell->{Val} );
				$sth->bind_param( $col + 1, $cell->{Val} );
			}
		}
		print("los valores son @valores\n");
		$sth->execute();

	}

	last;
}
print("ddesconectando \n");
$dbh->disconnect;

#if ( $sth->execute ) {
#	while ( @dat = $sth->fetchrow ) {
#		print "servername is @dat\n";
#	}
#}
