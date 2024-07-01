INSERT INTO "charge_test_data" VALUES (1, 0, 0), (2, -5, 0), (1, 50, 50), (4, 105, 50);

update charge_test_data set charge_input = -7 where id = 3;
select * from charge_test_data order by id;
select * from charge_test_data order by id asc;

delete from charge_test_data where id = 3;
INSERT INTO "charge_test_data" VALUES  (3, -5, 0);
