(ns clj.postgres
  (:require [clj.env :as env]
            [clojure.java.jdbc :as sql]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Default
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def db-port (@env/env :db-port))
(def db-host (@env/env :db-host))
(def db-name (@env/env :db-name))
(def db-user (@env/env :db-user))
(def db-password (@env/env :db-password))
(def live-db? (@env/env :live-db?))
(def ssl-factory (@env/env :ssl-factory))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Database Connection
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def db-base-config {:dbtype "postgresql"
                     :dbname db-name
                     :host db-host
                     :user db-user
                     :password db-password})

(def pg-db
  (if live-db?
    (conj
     db-base-config
     {:ssl true
      :sslfactory ssl-factory})
    db-base-config))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Functions to test DB connection
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-table [table specs]
  (sql/db-do-commands pg-db [(sql/create-table-ddl table specs)]))

(defn insert [table data]
  (sql/insert-multi! pg-db table data))

(defn select-all [table]
  (sql/query pg-db [(str "SELECT * FROM " (name table))]))

