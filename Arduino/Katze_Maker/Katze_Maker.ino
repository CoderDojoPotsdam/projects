//Variablen
int lichtNormal;

void setup(){
  
  pinMode(12, OUTPUT);
  pinMode(7, OUTPUT);
  
  pinMode(A0, INPUT);
  lichtNormal = digitalRead(A0);
  
}

void loop(){
  
  //Augenblincken
  if(random (5000) == 1){
    digitalWrite(12, LOW);
    digitalWrite(7, LOW); 
  }

  if(random (5000) == 1){
    digitalWrite(12, HIGH);
    digitalWrite(7, HIGH);
  }
  
  //Schnurren
  if(digitalRead()){
  
    
    
  }
  
}
