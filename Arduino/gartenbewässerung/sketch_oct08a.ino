int messwert=0;

int gelb=6;
int rot=7;
int grun=8;
int weis=9;
void setup()
{
Serial.begin(9600);
pinMode (6,OUTPUT);
pinMode (7,OUTPUT);
pinMode (8,OUTPUT);
}

void loop()

{

 messwert=analogRead(A0);

 Serial.print("Feuchtigkeits-Messwert:");

 Serial.println(messwert);

 delay(500);

if (messwert <100 )

{

digitalWrite(rot, HIGH);

}

else

{

digitalWrite(rot, LOW);

}



if (messwert <300 )


{
  digitalWrite(gelb, HIGH);
  
}

else

{
  
digitalWrite(gelb, LOW);

}

if (messwert <650 )


{
  digitalWrite(grun, HIGH);
  
}

else

{
  
digitalWrite(grun, LOW);

}

if (messwert >700 )


{
  digitalWrite(weis, HIGH);
  
}

else

{
  
digitalWrite(weis, LOW);

}}


