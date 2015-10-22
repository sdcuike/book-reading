The	key	points	of	this	chapter	are:

-  An	interface	specifies	 a	 set	of	 methods	that	 an	implementing	class	must	provide.

-  	An	interface	is	 a	supertype	o f	any	class	that 	implements	it.	Therefore,	one	can  assign	instances	of	 the	class	to 	variables	of	 the	interface	type.

-  	An	interface	can	contain	static	methods.	All	variables	of	 an	interface	are  automatically	static	and	final.

-  	An	interface	can	contain	default	methods	that	 an	implementing	class	can	inherit 	or override.

-  You	cannot	have	instance	variables	in 	an	interface.	An	interface	specifies  	behavior, not	object	state.

- In	earlier 	versions	 of	Java,	all	 methods	of 	an	interface	had	to 	be	abstract—that	is,	without a	body.	Nowadays	you	can	add	two	kinds	of	 methods	with 	a	concrete	implementation:

static	and	default	methods.	 

- If	neither	interface	provides	 a 	default	for	a	shared	method,	then	there	is	no	conflict.

An	implementing	class	has	two	choices:	implement	the	method,	or	 leave	it

unimplemented	and	declare	the	class	as	abstract.
 
-  	The	Comparable	and	Comparator	interfaces	are	used	for	comparing	 objects.

-  	A	lambda	expression	denotes	a	block	of	code	that	 can	 be	executed	at	 a 	later	point	in time.

-  	Lambda	expressions	are	converted	to 	functional	interfaces.

-  	Method	and	constructor	references	  refer	to 	methods	or	 constructors	without invoking	them.

-   Lambda	 expressions	 and	local	inner	classes	can	access	effectively	final	 variables  from	the	enclosing	scope.
