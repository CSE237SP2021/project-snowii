#!/bin/bash

javac src/cse237/*.java

if (( $# == 0 ));
then
	java -cp src cse237.Snowii
elif (( $# == 2 ));
then
	java -cp src cse237.Snowii $1 $2
else
	echo "Either enter 0 command line arguments for default table or 2 arguments <State Name> <Resort Name> for a specified table"
fi
