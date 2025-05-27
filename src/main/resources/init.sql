CREATE SCHEMA if not exists TENNISSCOREBOARD;
SET SCHEMA TENNISSCOREBOARD;

CREATE TABLE if not exists PLAYERS(
                                       id bigint PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(100) NOT NULL
                                  );

CREATE UNIQUE INDEX ON PLAYERS(
                               name
                              );

CREATE TABLE if not exists MATCHES(
                                       id INT2 PRIMARY KEY AUTO_INCREMENT,
                                       player1_id bigint,
                                       player2_id bigint,
                                       playerWinner_id bigint,
                                       foreign key (player1_id) references PLAYERS(id),
                                       foreign key (player2_id) references PLAYERS(id),
                                       foreign key (playerWinner_id) references PLAYERS(id)
                                   );

INSERT INTO PLAYERS(name) VALUES('D. Medvedev');
INSERT INTO PLAYERS(name) VALUES('B. Djokovic');
INSERT INTO PLAYERS(name) VALUES('R. Federer');
INSERT INTO PLAYERS(name) VALUES('R. Nadal');

INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,2,1);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(2,3,2);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(3,2,2);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);

INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(3,4,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);

INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(3,4,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);

INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(3,4,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(1,3,3);
INSERT INTO MATCHES(player1_id, player2_id, playerWinner_id) VALUES(4,1,4);