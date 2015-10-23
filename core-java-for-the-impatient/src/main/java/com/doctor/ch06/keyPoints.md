The	key	points		of		this	chapter	are:

-   	A	generic	class	is	a	class	with		one	or		more	type	parameters.

-   A	generic	method	is	a	method	with		type	parameters.

-   You	can	require	a	type	parameter		to		be	a	subtype	of		one	or		more	types.

-   	Generic	types	are	invariant:	When	S	is	a	subtype	of 	T,	there	is	no	relationship

between	G<S>	and	G<T>.

_________________________________

-  	By	using	wildcards	G<?	extends	T>	or		G<?	super	T>,	you	can	specify	that

a	method	can	accept	an	instantiation	of	a	generic	type	with	a	subclass		or		superclass 	argument.

-   	Type	parameters	are	erased	when	generic	classes	and	methods	are	compiled.

-   	Erasure	puts	many	restrictions	on	generic	types.	In	particular,	you	can’t	instantiate

generic	classes	or		arrays,	cast		to	a	generic	type,	or		throw	an	object	of		a	generic	type.

-   	The	Class<T>	class	is	generic,	which	is	useful	because		methods	such	as

newInstance	are	declared		to		produce	a	value	of		type	T.

-   	Even	though	generic	classes	and	methods	are	erased	in	the	virtual	machine,	you	can

find	out	at		runtime	how		they	were	declared.

