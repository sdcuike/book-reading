 
The	key	points	of	this	chapter	are:

- You	can	annotate	declarations	just	as	you	use	modifiers	such	as	public	or		static.

- 	You	can	also		annotate	types	that	appear	in		declarations,	casts,		instanceof

checks,	or		method	references.

- An	annotation		starts	with		a		@	symbol	and	may	contain	key/value	pairs	called  elements.

- Annotation	values		must	be	compile-time		constants:		primitive	types,	enum

constants,	Class	literals,	other	annotations,	or		arrays		thereof.

- An		item	can	have	repeating	annotations	or		annotations	of		different		types.

- To	define		an	annotation,	specify	an	annotation		interface	whose	methods	correspond

to		the	annotation	elements.

- The	Java		library		defines	over	a		dozen	annotations,	and	annotations	are	extensively

used	in	the	Java		Enterprise	Edition.

- 	To		process	annotations	in	a	running	Java		program,	you	can	use	reflection	and	query

the	reflected	items	for	annotations.

-  Annotation		processors	process	source	files		during		compilation,	using	the	Java

language	model		API	to		locate		annotated	items.


- Annotations	for	local	variables	and	packages	are	discarded	when	a	class	is

compiled.	Therefore,		they	can	only		be	processed	at		the	source	level.
