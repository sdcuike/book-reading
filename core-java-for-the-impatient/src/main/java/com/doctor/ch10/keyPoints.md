The	key	points	of		this	chapter	are:

-	A		Runnable	describes	a	task		that		can	be	executed	asynchronously.

- 	An	Executor	schedules	Runnable	instances	for	execution.

- 	A	Callable	describes	a	task		that		yields	a	result.

- 	You	can	submit	one	or		more	Callable	instances	to		an	ExecutorService	and

combine		the	results	when	they	are	available.

- When	multiple	threads	operate	on	shared	data	without	synchronization,	the	result	is  unpredictable.

- Prefer	using	parallel	algorithms		and	threadsafe		data	structures		over	programming  with		locks.

-  Parallel	streams		and		array	operations		automatically	and		safely		parallelize  computations.

- A	ConcurrentHashMap	is	a	threadsafe		hash	table	which	allows		atomic	update  of	entries.

- 	You	can	use	AtomicLong	for	a	lock-free		shared	counter,	or		use	LongAdder		if  contention		is	high.

-	A	lock	ensures	that	only	one	thread	at		a	time	executes	a	critical		section.

- 	An	interruptible	task		should		terminate	when	the	interrupted	flag	is	set	or		an  InterruptedException	occurs.

- 	A	long-running	task		should		not	block	the	user	interface	of		a	program,	but	progress

and		final		updates	need	to		occur	in	the	user-interface	thread.

-	The	Process	class	lets	you	execute	a	command	in	a	separate	process	and	interact

with	the	input,	output,	and	error	streams.
