CREATE SCHEMA travel_advice;

CREATE TABLE travel_advice.city (
    id UUID PRIMARY KEY NOT NULL,
    name CHARACTER varying(20)
);

CREATE TABLE travel_advice.city_advice (
  id UUID PRIMARY KEY NOT NULL,
  city_id UUID NOT NULL,
  advice TEXT,

  CONSTRAINT fk_city_advice_city_id FOREIGN KEY (city_id) REFERENCES travel_advice.city(id)
);


INSERT INTO travel_advice.city (id, name) 
VALUES ('00000000-0000-0000-0000-000000000000', 'Москва');

INSERT INTO travel_advice.city (id, name) 
VALUES ('00000000-0000-0000-0000-000000000001', 'Питер');

INSERT INTO travel_advice.city (id, name) 
VALUES ('00000000-0000-0000-0000-000000000002', 'Лондон');

INSERT INTO travel_advice.city (id, name) 
VALUES ('00000000-0000-0000-0000-000000000003', 'Минск');


INSERT INTO travel_advice.city_advice (id, city_id, advice)
VALUES ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'Воробьевы горы — одно из самых живописных и необычных мест Москвы. Они выделяются не только благодаря своему местоположению, превосходному виду на столицу и уникальной флоре и фауне');

INSERT INTO travel_advice.city_advice (id, city_id, advice)
VALUES ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 'Каждому стоит посетить крепость хотя бы раз, а ещё лучше прийти сюда к полудню и услышать полуденный выстрел из пушек вживую.');

INSERT INTO travel_advice.city_advice (id, city_id, advice)
VALUES ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 'Еще один правильный вариант того, что посмотреть в Лондоне за 1 день обязан каждый гость города - Тауэрский мост');

INSERT INTO travel_advice.city_advice (id, city_id, advice)
VALUES ('00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', 'Культурный центр «Корпус». Один из корпусов завода «Горизонт» в прошлом, а сейчас – андеграундный культурный центр с концертами, лекциями, маркетами и фестивалями.');

