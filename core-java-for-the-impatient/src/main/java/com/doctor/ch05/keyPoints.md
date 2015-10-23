The	key	points	of	this	chapter	are:


- 	When	you	throw	an	exception,	control	is	transferred	to	  the	nearest	handler	of		the  exception.

- 	In	Java,	checked	exceptions	are	tracked	by	the	compiler.

- 		Use	the	try/catch	construct	to 	handle	exceptions.

- 	The	try-with-resources	statement		automatically	closes		resources	after	normal execution	or		when	an	

exception	occurred.

- 	 Use	the	try/finally	construct	to		deal		with		other	actions	that		must	occur	whether

or		not	execution	proceeded	normally.

- 	 You	can	catch	and	rethrow	an	exception,	or		chain	it	to		another	exception.

- 	A	stack	trace	describes	all		method	calls		that		are	pending	at		a	point	of		execution.

- 	An	assertion	checks	a	condition,	provided		that		assertion	checking		is	enabled	for	the

class,	and	throws	an	error	if	the	condition	is	not	fulfilled.

- 		Loggers	are	arranged	in	a	hierarchy,	and	they	can	receive	logging	messages	with

levels	ranging	from	SEVERE	to	FINEST.

- 		Log	handlers		can	send	logging	messages	to		alternate	destinations,	and	formatters

control	the	message	format.

- 	 	You	can	control	logging	properties	with	a	log	configuration		file.


- The	finally		clause		is		executed	when	the	try	block	comes	to		an	end,	either	normally		or  due	to		an	exception.

This	pattern	occurs	whenever	you	need	to		acquire	and	release	a	lock,	or		increment	and

decrement	a	counter,	or		push	something		on	a	stack	and	pop	it	off	when	you	are	done.	You

want	to		make	sure	that		these	actions	happen	regardless		of		what	exceptions	might	be  thrown.

- You	should		avoid	throwing	an	exception	in	the	finally	clause.	If	the	body	of		the	try

block	was		terminated	due	to		an	exception,	it	is	masked	by	an	exception	in	the	finally

clause.	The	suppression	mechanism	that		you	saw		in	the	preceding	section	only		works		for

try-with-resources	statements.

- A	finally	clause		should		not	contain	a	return		statement.	If	the	body	of		the

try	block	also	has	a	return		statement,	the	one	in	the	finally	clause		replaces		the return	value.

- It	is	possible	to		form	try	statements	with		catch	clauses	followed		by	a	finally

clause.	But	you	have	to		be	careful	with		exceptions	in	the	finally	clause.	 
