CREATE database nucleus;
use nucleus;

create table lob(
id varchar(36) NOT NULL DEFAULT(UUID()),
lobname varchar(45) NOT NULL,
datecreated datetime,
datemodified datetime,
PRIMARY KEY(id),
UNIQUE KEY(lobname) 
);

create table mnemonic(
id varchar(36) NOT NULL DEFAULT(UUID()),
mnemonicsname varchar(45) NOT NULL,
datecreated datetime,
datemodified datetime,
lobid varchar(36) NOT NULL,
lobname varchar(45) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (lobid) REFERENCES lob(id),
UNIQUE KEY(mnemonicsname)
);

create table appcomponents(
id varchar(36) NOT NULL DEFAULT(UUID()),
appcomponentsname varchar(45) NOT NULL,
datecreated datetime,
datemodified datetime,
mnemonicid varchar(36) NOT NULL,
mnemonicname varchar(45) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (mnemonicid) REFERENCES mnemonic(id),
UNIQUE KEY(appcomponentsname,mnemonicid)
);

create table testconfig(
id varchar(36) NOT NULL DEFAULT(UUID()),
testname varchar(45) NOT NULL,
gitreponame varchar(100) NOT NULL,
gitrepourl varchar(100) NOT NULL,
scriptname varchar(100) NOT NULL,
env varchar(45),
userid_users varchar(50),
datecreated datetime,
datemodified datetime,
lobname varchar(45) NOT NULL,
mnemonicname varchar(45) NOT NULL,
appcomponentname varchar(45) NOT NULL,
numberofagents int,
testtype varchar(45),
PRIMARY KEY(id),
UNIQUE KEY(testname)
);

create table testexecution(
id varchar(36) NOT NULL DEFAULT(UUID()),
starttime datetime,
endtime datetime,
runstatus varchar(45),
processid int,
userid_users varchar(50),
datecreated datetime,
datemodified datetime,
testconfigid varchar(36) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (testconfigid) REFERENCES testconfig(id)
);

ALTER TABLE testconfig ADD avg_tranpersec DECIMAL(10,2);
ALTER TABLE testconfig ADD avg_responsetime DECIMAL(10,2);
ALTER TABLE testconfig ADD err_perc DECIMAL(10,2);
ALTER TABLE testexecution ADD avg_tranpersec DECIMAL(10,2);
ALTER TABLE testexecution ADD avg_responsetime DECIMAL(10,2);
ALTER TABLE testexecution ADD err_perc DECIMAL(10,2);
ALTER TABLE testexecution ADD actual_avg_tranpersec DECIMAL(10,2);
ALTER TABLE testexecution ADD actual_avg_responsetime DECIMAL(10,2);
ALTER TABLE testexecution ADD actual_err_perc DECIMAL(10,2);
ALTER TABLE testexecution ADD teststatus varchar(45);
