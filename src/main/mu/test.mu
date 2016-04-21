main(){
  stack s;
  spush(s, 10);
  spush(s, 20);
  empty(s); 
  b = 0;
  b = top(s); 
  spop(s);
}