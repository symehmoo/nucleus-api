CREATE database nucleus;
use nucleus;

create table Lob(
id varchar(36) NOT NULL DEFAULT(UUID()),
lobName varchar(45),
dateCreated datetime,
dateModified datetime,
PRIMARY KEY(id)
);

create table Mnemonic(
id varchar(36) NOT NULL DEFAULT(UUID()),
mnemonicsName varchar(45),
dateCreated datetime,
dateModified datetime,
lobId varchar(36),
PRIMARY KEY(id),
FOREIGN KEY (lobId) REFERENCES Lob(id)
);

create table AppComponents(
id varchar(36) NOT NULL DEFAULT(UUID()),
appComponentsName varchar(45),
dateCreated datetime,
dateModified datetime,
mnemonicId varchar(36),
PRIMARY KEY(id),
FOREIGN KEY (mnemonicId) REFERENCES Mnemonic(id)
);

create table TestConfig(
id varchar(36) NOT NULL DEFAULT(UUID()),
testName varchar(45),
gitRepoName varchar(100),
gitRepoURL varchar(100),
scriptName varchar(100),
env varchar(45),
users_idusers varchar(50),
dateCreated datetime,
dateModified datetime,
lobId varchar(36),
mnemonicId varchar(36),
appComponentsId varchar(36),
PRIMARY KEY(id),
FOREIGN KEY (lobId) REFERENCES Lob(id),
FOREIGN KEY (mnemonicId) REFERENCES Mnemonic(id),
FOREIGN KEY (appComponentsId) REFERENCES AppComponents(id)
);

create table TestExecution(
id varchar(36) NOT NULL DEFAULT(UUID()),
startTime datetime,
endTime datetime,
runStatus varchar(45),
processId int,
users_idusers varchar(50),
dateCreated datetime,
dateModified datetime,
testConfigId varchar(36),
PRIMARY KEY(id),
FOREIGN KEY (testConfigId) REFERENCES TestConfig(id)
);
