create database Votacao
use Votacao

 create table tbVotos(
  codigo int not null primary key identity,
  voto int not null,
  datahora datetime default Getdate(),
  validador varchar(200))

  insert into tbVotos (voto)
  values
  (2),(1),(3), (2),(1),(3),
  (2),(3),(3),(2),(4),(3),
  (2),(3),(3),(2),(4),(3),
  (5),(1),(3),(2),(4),(3),
  (5),(2),(3),(2),(2),(3),
  (2),(2),(3),(2),(4),(4),
  (5),(2),(3),(2),(1),(3)
  select * from tbVotos

  select voto, 
  count(voto) as total
  from tbVotos
  group by voto
   order by total desc