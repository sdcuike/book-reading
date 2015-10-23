The	key	points	of	this	chapter	are:

-  Iterators		imply	a	specific	traversal	strategy		and 	prohibit	efficient	concurrent  execution.

-  	You	can	create		streams		from	collections,	arrays,	generators,	or		iterators.

-  Use	filter	to		select	elements	and	map	to		transform	elements.

-  Other	operations		for	transforming		streams		include	limit,	distinct,	and  sorted.

-  To		obtain		a	result	from	a	stream,	use	a	reduction	operat	or		such	as	count,	max,

min,	findFirst,		or		findAny.	Some	of		these	methods	return	an	Optional  value.

-  The	Optional		type	is		intended		as	a	safe		alternative		to		working	with		null	values.

To		use	it	safely,	take		advantage		of		the		ifPresent	and	orElse		methods.

-  You	can	collect		stream	results	in		collections,	arrays,	strings,	or		maps.

-  	The	groupingBy	and		partitioningBy	methods	of		the	Collectors	class

allow	you	to		split		the	contents	of		a	stream	into	groups,	and		to		obtain		a	result	for	each  group.

-  There	are	specialized		streams		for	the	primitive		types	int,	long,	and	double.

- 	Parallel	streams		automatically	parallelize	stream	operations.
