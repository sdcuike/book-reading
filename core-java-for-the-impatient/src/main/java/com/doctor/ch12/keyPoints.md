The	key	points	of	this	chapter	are:

-	All	java.time	objects	are	immutable.

- An		Instant	is	a	point	on	the	time	line	(similar	to		a	Date).

-	In	Java	time,	each	day	has	exactly	86,400	seconds	(that	is,	no	leap	seconds).

- A	Duration		is	the	difference	between	two	instants.

-	LocalDateTime	has	no	time	zone	information.

-  The	API	designers	recommend	that		you	do	not	use	zoned	time	unless		you

really	want	to		represent	absolute		time	instances.	Birthdays,	holidays,	schedule	times,	and

so	on	are	usually	best	represented	as	local	dates	or		times.

- TemporalAdjuster	methods	handle	common	calendar	computations,	such	as

finding	the	first	Tuesday	of		a	month.

- 	ZonedDateTime	is	a	point	in	time	in	a	given	time	zone	(similar	to  GregorianCalendar).

- 	Use	a	Period,	not	a	Duration,	when	advancing	zoned		time,	in	order	to		account

for	daylight	savings	time	changes.

- 	Use	DateTimeFormatter	to		format	and	parse	dates	and	times.
