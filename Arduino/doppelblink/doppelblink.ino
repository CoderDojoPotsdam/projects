boolean stopWhile = false;

void setup(){
 pinMode(8,OUTPUT);
 pinMode(7,OUTPUT); 
}

void loop(){
  digitalWrite(7,HIGH);
  digitalWrite(8,LOW);
  delay(1000);
  digitalWrite(7,LOW);
  digitalWrite(8,HIGH);
  delay(1000);//Warte 1000 ms
  /*while(!stopWhile){
    
  }*/
}
