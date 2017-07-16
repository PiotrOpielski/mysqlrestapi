MySQL REST api

Work still in progress, api is not working yet.

Prepared Statement is saved, then in url address you can select statement and insert values.

For example if statement3 = SELECT * FROM users WHERE user_id = ?
then url will be http://address/token/statement3/1004

Results will be given in json format.

Administrator panel will help managing statements, creating new and deleting old.
