The	key	points	of	this	chapter	are:

1.	Mutator	methods	change	the	state	of	 an	object;	accessor	methods	don’t.

2.	In	 Java,	variables	don’t	hold	 objects;	they	hold	 references	to	 objects.

3.	Instance	variables	and	method	implementations	are	declared 	inside	the	class  declaration.

4.	An	instance	method	is	invoked	on	an	object,	which	is	accessible	through	the	this reference.

5.	A	constructor	has	the	same	name	as	the	class.	A	class	can	have	multiple (overloaded)	constructors.

6.	Static	variables	don’t	belong	to 	any	objects.	Static	methods	are	not	invoked	on objects.

7.	Classes	are	organized	into	packages.	Use 	import	declarations	so	that	you	don’t	have

to 	use	the	package	name	in	your	programs.

8.	Classes	can	be	nested	in	other	classes.

9.	An	inner	class	is	a	nonstatic	nested	class.	Its	instances	have	a	reference	to	 the	 object

of	 the	enclosing	class	that	constructed	it.

10.	The	javadoc	utility	processes	source	files,	producing	HTML	files	with

declarations	and	programmer-supplied	comments.

11.Instance	variable	initializations	and	initialization	blocks	are	executed	in	the	order	in	which

they	appear	in	the	class	declaration,	and	before	the	body	of	the	constructor.

12.Instance	variables	are	very 	different 	from	local	variables.	Recall	that

you	must	always	explicitly	initialize	local	variables.

13.When	used	with 	a	reference	to	a	mutable	 object,	the	final	 modifier	merely	states

that	 the 	reference	will	never	change.	 

14.If	a	class	already	has	a	constructor,	it	does	not	automatically	get	another	constructor

with	 no	arguments.	If	you	supply	 a	 constructor	and	also	 want	a	no-argument

constructor,	you	have	to	 write	it	yourself.(默认构造函数特性)

15.Static	initialization	occurs	when	the	class	is	first	loaded.	Like	instance	variables,	static

variables	are	0,	false,	or	 null 	unless	 you	 explicitly	set	them	to 	another	value.	All

static	variable	initializations	and	static	initialization	blocks	are	executed	in	the	order	in

which	they	occur	in	the	class	declaration.





