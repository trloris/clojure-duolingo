(ns duolingo.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn get-user
  "google thing"
  [user]
  (json/read-str (:body (client/get (str "http://duolingo.com/users/" user)))))
