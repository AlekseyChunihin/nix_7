/*Location values*/
INSERT INTO [Location](id,[name]) 
		VALUES (1,'gdansk');
INSERT INTO [Location](id,[name]) 
		VALUES (2,'bydgoszcz');
INSERT INTO [Location](id, [name]) 
		VALUES (3,'torun');
INSERT INTO [Location](id, [name]) 
		VALUES (4,'warszawa');
/*Route values*/
INSERT INTO [Route](id, from_id, to_id, cost) --gdansk->bydgoszcz
		VALUES (1,1,2,1);
INSERT INTO [Route](id, from_id, to_id, cost) --gdansk->torun
		VALUES (2,1,3,3);

INSERT INTO [Route](id, from_id, to_id, cost) --bydgoszcz->gdansk
		VALUES (3,2,1,1);
INSERT INTO [Route](id, from_id, to_id, cost) --bydgoszcz->torun
		VALUES (4,2,3,1);
INSERT INTO [Route](id, from_id, to_id, cost) --bydgoszcz->warszawa
		VALUES (5,2,4,4);

INSERT INTO [Route](id, from_id, to_id, cost) --torun->gdansk
		VALUES (6,3,1,3);
INSERT INTO [Route](id, from_id, to_id, cost) --torun->bydgoszcz
		VALUES (7,3,2,1);
INSERT INTO [Route](id, from_id, to_id, cost) --torun->warszawa
		VALUES (8,3,4,1);

INSERT INTO [Route](id, from_id, to_id, cost) --warszawa->bydgoszcz
		VALUES (9,4,2,4);
INSERT INTO [Route](id, from_id, to_id, cost) --warszawa->torun
		VALUES (10,4,3,1);
/*Problem values*/
INSERT INTO Problem(id, from_id, to_id) --gdansk->warszawa
		VALUES (1,1,4);
INSERT INTO Problem(id, from_id, to_id) --bydgoszcz->warszawa
		VALUES (2,2,4);