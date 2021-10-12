INSERT INTO users ([name],telephone_number)
		VALUES ('Victor','0964534567');
INSERT INTO users ([name],telephone_number)
		VALUES ('Andrey','0963100876');

INSERT INTO accounts (balance,[user_id])
	    VALUES (1500,1);
INSERT INTO accounts (balance,[user_id])
	    VALUES (5000,1);
INSERT INTO accounts (balance,[user_id])
	    VALUES (7200,2);

INSERT INTO categories ([name],category_type)
	    VALUES ('salary',1);
INSERT INTO categories ([name],category_type)
	    VALUES ('food',0);
INSERT INTO categories ([name],category_type)
	    VALUES ('transport',0);
INSERT INTO categories ([name],category_type)
	    VALUES ('utilities',0);
INSERT INTO categories ([name],category_type)
	    VALUES ('allowance',1);