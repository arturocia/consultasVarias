#!/opt/local/bin/perl
use DBI;
my $user = "sa";
my $passwd = "bimalatrop2014";
my $dbh = DBI->connect( "DBI:Sybase:server=servidorDesarrollo",
$user, $passwd, { RaiseError => 1 } )
or die $DBI::errstr;
my $sth = $dbh->prepare("select \@\@servername");
if ( $sth->execute ) {
while ( @dat = $sth->fetchrow ) {
print "servername is @dat\n";
}
}
exit(0);
