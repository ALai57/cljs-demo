
This is an example app that uses a Clojure backend and Clojurescript frontend.
The app must run on Java 11.


The template includes:
- Server with handler
- CLJS app


*Development environment*

How to start server:

```lein run```


How to start CLJS:

```lein figwheel```


How to start CLJS with in-editor REPLing
```
Start CLJ repl

(use 'figwheel-sidecar.repl-api)
(start-figwheel! *Optionally insert profile name*)
(cljs-repl *Optionally insert profile name*)

```


*How to setup postgres:*

Requirements for postgres backend:

psql -> database -> user with password and access to database


run postgres in super user

```sudo su postgres```

run postgres

```
   * create database full-stack-template-postgres-db*
   psql -d full-stack-template-postgres-db
   CREATE USER db_user WITH ENCRYPTED PASSWORD 'password';
   GRANT ALL ON DATABASE full-stack-template-postgres-db TO db_user;
   GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO db_user;

```

Helpful psql commands:

```
   \du :: list users
   \dt :: List tables
   select current_user;
   select current_database();
   select schema_name from information_schema.schemata;
```




*** Must have NPM installed to manage JS dependencies.

On Ubuntu::
```
sudo apt-get update
sudo apt-get install npm
```

