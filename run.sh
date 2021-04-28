#!/bin/bash

javac src/cse237/*.java

if (( $# == 0 ));
then
	java -cp src cse237.Snowii
elif (( $# == 2 ));
then
	java -cp src cse237.Snowii $1 $2
elif (( $# > 2 ));
then
	if [[ $1 == "New" ]] || [[ $1 == "North" ]] || [[ $1 == "South" ]] || [[ $1 == "British" ]] || [[ $2 == "Island" ]]
	then
		STATENAME="$1 $2"
		RESORTLOC=4
		RESORTNAME="$3"
	else
		STATENAME="$1"
		RESORTLOC=3
		RESORTNAME="$2"
	fi
	echo $RESPRTNAME
	for i in "${@:$RESORTLOC}";
	do
		RESORTNAME+=" $i"
	done
	java -cp src cse237.Snowii "$STATENAME" "$RESORTNAME"	
else
	echo "Either enter 0 command line arguments for default table or 2 arguments <State Name> <Resort Name> for a specified table"
fi
