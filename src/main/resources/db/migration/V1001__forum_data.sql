insert into users(email,password,username)
    value ("Aman.aman@aman.com",1234,"Aman"),
    ("Eldiyar.eldiyar@eldiyar.com",12345,"Eldiyar"),
    ("Elvira.elvira@elvira.com",123456,"Elvira"),
    ("Ramazan.ramazan@ramazan.com",1234567,"Ramazan");

insert into subjects(events, local_date, user_id)
    value ("Новый год","2021-01-01",1),
    ("День защитника Отечества","2006-09-21",2),
    ("Международный женский день","2021-12-30",3),
    ("День народной Апрельской революции","2012-06-07",4);

insert into answers(text,local_date,subject_id,user_id)
    value ("Если это может кому-то помочь, вот перевод принятого ответа Crembo на pura Java","2004-10-18",1,1),
("Метод контроллера","2006-02-28",2,2),
("Основной класс (только значащие биты):","2000-03-10",3,3),
("Ниже будет работать метод перезапуска.","2000-02-01",4,4);