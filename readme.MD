**MySQL REST api**

In this moment api supports JWT tokens, and doing one-condition SQL queries.
Queries are saved in statements.json file, can be accessed from api url http://localhost:8080/api/statementID/condition
Token must be given in POST header in form "Token":"actualtoken".

Warnings:


key.key is just sample file, better generate your own key.
Absolute paths must be replaced in file paths.
Token can be obtained from /login page. In this moment credentials are fixed.
Work still in progress, goal is to api work out-of-box.