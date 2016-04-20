fac(num){
  if(num == 1){
  	return 1;
  }
  y = 0;
  x = 0;
  z = 0;
  y = num - 1;
  x = fac(y);
  print x;
  z = x * num;
  return z;
}
main(){
  x=10;
  y=100;
  fac(x);
}