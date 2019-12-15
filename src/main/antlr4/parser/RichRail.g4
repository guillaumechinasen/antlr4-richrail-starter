grammar RichRail;

// Rules
newcommand                  : newtraincommand | newpersonwagoncommand | newgoodswagoncommand| newlocomotivecommand| newguilcommand;
addcommand                  : addpersonwagoncommand|  addlocomotivecommand| addgoodswagoncommand;
delcommand                  : delpersonwagoncommand| delgoodswagoncommand| deltraincommand| dellocomotivecommand;
remcommand                  : rempersonwagoncommand| remlocomotivecommand| remgoodswagoncommand;
getcommand                  : getseatscommand| getnamecommand| getclasstypecommand| getgoodsidcommand| getlocomotiveidcommand| getcargocommand| getfueltypecommand;

newtraincommand             : 'new' 'train' TrainID;
newpersonwagoncommand       : 'new' 'personwagon' PersonID ('seats' NUMBER)?;
newgoodswagoncommand        : 'new' 'goodswagon' GoodsID ('id' STRING| 'cargo' STRING)?;
newlocomotivecommand        : 'new' 'locomotive'  LocoID ('id' STRING| 'fueltype' STRING)?;
newguilcommand              : 'new'  'guil'  GoodsID;

goodsid : GoodsID;

addpersonwagoncommand       : 'add' PersonID 'to' TrainID;
addlocomotivecommand        : 'add' LocoID   'to' TrainID;
addgoodswagoncommand         : 'add' GoodsID  'to' TrainID;

getseatscommand             : 'getnumseats'  'personwagon'  PersonID;
getnamecommand              : 'getname'      'personwagon'  PersonID;
getclasstypecommand         : 'getclasstype' 'personwagon'  PersonID;
getgoodsidcommand           : 'geid'         'goodswagon'   GoodsID;
getlocomotiveidcommand      : 'geid'         'locomotive'   LocoID;
getcargocommand             : 'getcargo'     'goodswagon'   GoodsID;
getfueltypecommand          : 'getfueltype'  'locomotive'   LocoID;

delpersonwagoncommand       : 'delete' 'personwagon' PersonID;
deltraincommand             : 'delete' 'train' TrainID;
dellocomotivecommand		: 'delete' 'locomotive' LocoID;
delgoodswagoncommand		: 'delete' 'goodswagon'	GoodsID;

remgoodswagoncommand        : 'remove' GoodsID 'from' TrainID;
rempersonwagoncommand       : 'remove' PersonID 'from' TrainID;
remlocomotivecommand        : 'remove' LocoID   'from' TrainID;

type            : 'train' | 'personwagon' | 'goodswagon'| 'locomotive'| 'guil';

// Tokens
TrainID     : ('T')('a'..'z'|'0'..'9')*;
PersonID    : ('P')('a'..'z'|'0'..'9')*;
GoodsID     : ('W')('a'..'z'|'0'..'9')*;
LocoID      : ('L')('a'..'z'|'0'..'9')*;
NUMBER      : ('0'..'9')*;
STRING      : ('a'..'z')('a'..'z'|'0'..'9')*;
WHITESPACE  : [ \t\r\n\u000C] -> skip;