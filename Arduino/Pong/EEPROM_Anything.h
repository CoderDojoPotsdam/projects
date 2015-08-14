
#ifndef EEPROM_Anything_h
#define  EEPROM_Anything_h

#include <EEPROM.h>

// read and write EEPROM values
template <class T> int EEPROM_writeAnything(int ee, const T& value)
{
   // from http://forum.arduino.cc/index.php?PHPSESSID=eocvtd0jtq11rkb884a1m8q8t2&topic=41497.msg301766#msg301766
   const int8_t* p = (const int8_t*)(const void*)&value;
   int i;
   for (i = 0; i < sizeof(value); i++)
       EEPROM.write(ee++, *p++);
   return i;
};

template <class T> int EEPROM_readAnything(int ee, T& value)
{
   // from http://forum.arduino.cc/index.php?PHPSESSID=eocvtd0jtq11rkb884a1m8q8t2&topic=41497.msg301766#msg301766
   int8_t* p = (int8_t*)(void*)&value;
   int i;
   for (i = 0; i < sizeof(value); i++)
       *p++ = EEPROM.read(ee++);
   return i;
};

#endif
