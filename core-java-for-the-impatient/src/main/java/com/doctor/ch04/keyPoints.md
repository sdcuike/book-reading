The	key	points	of	 this 	chapter	are:


- Instance	variables	and	 static 	variables	are	collectively	 called 	fields.	The	fields, methods,	

and	nested	classes/interfaces	inside	a	class	are	collectively 	called	its  members.

-   A	 subclass 	can	inherit	 or	 override	methods	from	the	superclass.

- 	Use	the	super	keyword 	to 	invoke	 a	 superclass	method	or	  constructor.

-  	A	final	 method 	cannot	be	overridden;	a	final	 class	cannot	be	extended.

- 	An	abstract 	method	has	no	implementation;	an	abstract	class	cannot	be instantiated.

-  A	protected	member 	of	a	subclass 	is 	accessible	in	a	subclass	 method,	but	only

when	applied	to	  objects 	of		the	same	subclass.

- 	Every	class	is	a	subclass 	of 	Object	 which	 provides	methods	toString, equals,	hashCode,	and	clone.

- 	Each	enumerated	type	is	a	subclass		of		Enum	which	provides		methods	toString, valueOf,	and	compareTo.

-	The	Class	class	provides		information	about	a	Java		type,	which	can	be	a	class, array,	interface,	primitive 	type,	or void.

-  You	can	use	a	Class	object		to		load		resources	that		are	placed		alongside	class	files.

-  You	can	load 	classes	from	locations	other	than	the	class	path	by	using	a	class	loader.

- The	reflection	library	 enables	 programs		to		discover		members	of		arbitrary		objects, access	variables,	and	invoke	methods.

-  Proxy	objects	dynamically	implement		arbitrary		interfaces,	routing	all		method invocations		to		a	handler.

-  Unlike	this,		super	is	not	a	reference	to		an	object,	but	a	directive		to		bypass  dynamic	method	lookup	

and		invoke		a	specific	method	instead.

- The	superclass	constructor	call	must	be	the	first  statement	in	the	constructor	for	the	subclass.

If	you	omit	the	superclass		constructor	call,	the	superclass		must	have	a	no-argument  constructor		which	is	implicitly	called.

-  Unlike	an	interface,	an	abstract	class	can	have	instance	variables	and	constructors.

-	 Just	as	you	can	have	an	anonymous	class	that		implements	an	interface,	you	can	have	an

anonymous	class	that		extends		a	superclass.	This		can	be	handy	for	debugging:

- It	is	legal	for	an	enumeration		to		have	static	members.	However,	you	have	to		be	careful

with		construction	order.	The	enumerated	constants	are	constructed	before	the	static

members,	so	you	cannot	refer	to		any	static	members	in	an	enumeration		constructor.	 

The	remedy	is	to	do	the	initialization	in		a	static	initializer.

- You	can	add	methods	to		each	individual	enum		instance,	but	they	have	to		override	methods

defined	in	the	enumeration.	 


-  Virtual		machine		instructions	are	stored		in	class	files.	Each	class	file	contains		the

instructions	for	a	single	class	or		interface.	A	class	file	can	be	located	on	a	file	system,	a

JAR	file,	a	remote	location,	or	even	dynamically	constructed	in	memory.	A	class	loader	is

responsible	for	loading	the	bytes	and	turning	them	into	a	class	or		interface	in	the	virtual machine.

The	virtual	machine		loads	class	files	on	demand,	starting	with	the	class	whose	main

method	is	to		be	invoked.	That	class	will	depend	on	other	classes,	such	as

java.lang.System	and	java.util.Scanner,	which	will	be	loaded	together		with

the	classes	that		they	depend	on.

When	executing	a	Java		program,	at		least	three	class	loaders	are	involved.

The	bootstrap	class	loader		loads	Java	library	classes	(typically	from	the	JAR	file jre/lib/rt.jar).	It	is	a	part	of	the	virtual	machine.

The	extension	class	loader	loads	“standard	extensions”	from	the	jre/lib/extdirectory.

The	system	class	loader		loads	the	application	classes.	It	locates	classes	in	the	directories and	JAR	files	on	the	class	path.

There	is	no	ClassLoader	object	corresponding	to		the	bootstrap	class	loader.	For

example,	String.class.getClassLoader()	returns	null.		In	the	Oracle		Java

implementation,	the	extension	and	system	class	loaders	are	implemented	in	Java.	Both	are
instances	of		the	URLClassLoader	class.

