<
x = 10;
y = 20;
z = 300;
a = 200;
>
main(){
	x = 17;
	y = 20;
	print x;
	[
		x=5;
		print x;
		print y;
		print z;
		[
			z= 18;
			print z;
			print x;
			print a;
		]
		print x;
	]
	print x;
}