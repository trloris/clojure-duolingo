(ns duolingo.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn get-user
  "Retrieve user info from Duolingo in form of JSON"
  [user]
  (json/read-str (:body (client/get (str "http://duolingo.com/users/" user)))))

(defn get-settings
  "Retrieve user's info from dictionary"
  [user-dict]
  (select-keys user-dict ["notify_comment" "deactivated" "is_follower_by" "is_following"]))
