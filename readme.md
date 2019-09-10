
# Description

This is an example app that uses a Clojure backend and Clojurescript frontend.
The app must run on Java 11.


__The template includes:__  
- Server with handler  
- CLJS app  
- A  
- B  


# Development

__How to start server:__

```bash
lein run
```



__How to start CLJS:__

```bash
lein figwheel
```



__How to start CLJS with in-editor REPLing__

```clojure
(use 'figwheel-sidecar.repl-api)
(start-figwheel! *Optionally insert profile name*)
(cljs-repl *Optionally insert profile name*)
```


#








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

