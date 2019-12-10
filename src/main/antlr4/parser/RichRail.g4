grammar RichRail;

// Rules
command                     : newcommand | addcommand | getcommand | delcommand | remcommand;
newcommand                  : newtraincommand | newpersonwagoncommand | newgoodswagoncommand| newlocomotivecommand| newguilcommand;
addcommand                  : addpersonwagoncommand|  addlocomotivecommand| addgoodswagoncommand;
delcommand                  : delpersonwagoncommand| delgoodswagoncommand| deltraincommand| dellocomotivecommand;
remcommand                  : rempersonwagoncommand| remlocomotivecommand| remgoodswagoncommand;
getcommand                  : getseatscommand| getnamecommand| getclasstypecommand| getgoodsidcommand| getlocomotiveidcommand| getcargocommand| getfueltypecommand;

newtraincommand             : 'new' 'train' ID;
newpersonwagoncommand       : 'new' 'personwagon' PersonID ('seats' NUMBER| 'name' STRING| 'classtype' STRING)?;
newgoodswagoncommand        : 'new' 'goodswagon' GoodsID('id' NUMBER| 'cargo' STRING)?;
newlocomotivecommand        : 'new' 'locomotive'  LocoID('id' NUMBER| 'fueltype' STRING)?;
newguilcommand              : 'new'  'guil'  GoodsID;

addpersonwagoncommand       : 'add' PersonID 'to' ID;
addlocomotivecommand        : 'add' LocoID   'to' ID;
addgoodswagoncommand         : 'add' GoodsID  'to' ID;

getseatscommand             : 'getnumseats'  'personwagon'  PersonID;
getnamecommand              : 'getname'      'personwagon'  PersonID;
getclasstypecommand         : 'getclasstype' 'personwagon'  PersonID;
getgoodsidcommand           : 'geid'         'goodswagon'   GoodsID;
getlocomotiveidcommand      : 'geid'         'locomotive'   LocoID;
getcargocommand             : 'getcargo'     'goodswagon'   GoodsID;
getfueltypecommand          : 'getfueltype'  'locomotive'   LocoID;

delpersonwagoncommand       : 'delete' 'personwagon' PersonID;
deltraincommand             : 'delete' 'train' ID;
dellocomotivecommand		: 'delete' 'locomotive' LocoID;
delgoodswagoncommand		: 'delete' 'goodswagon'	GoodsID;

remgoodswagoncommand             : 'remove' GoodsID 'from' ID;
rempersonwagoncommand       : 'remove' PersonID 'from' ID;
remlocomotivecommand        : 'remove' LocoID   'from' ID;

type            : 'train' | 'personwagon' | 'goodswagon'| 'locomodtive'| 'guil';

// Tokens
ID          : ('a'..'z')('a'..'z'|'0'..'9')*;
PersonID    : ('a'..'z')('a'..'z'|'0'..'9')*;
GoodsID     : ('w')('a'..'z'|'0'..'9')*;
LocoID      : ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER      : ('0'..'9')+;
STRING      : ('a'..'z');
WHITESPACE  : [ \t\r\n\u000C] -> skip;