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
  (select-keys user-dict ["notify_comment" "deactivated" "is_follower_by"
                          "is_following"]))

(defn get-languages
  "Retrieve the list of languages the user is learning"
  [user-dict]
  (filter #(get % "learning") (user-dict "languages")))

(defn get-user-info
  "Retrieve user's info"
  [user-dict]
  (select-keys user-dict ["username" "bio" "id" "num_following" "cohort"
                          "num_followers" "learning_language_string" "created"
                          "contribution_points" "gplus_id" "twitter_id" "admin"
                          "invites_left" "location" "fullname" "avatar"
                          "ui_language"]))

(defn get-language-progress
  "Retrieve progress of user's selected language"
  [user-dict language]
  (select-keys ((user-dict "language_data") language)
  	["streak" "language_string" "level_progress" "num_skills_learned"
     "level_percent" "level_points" "points_rank" "next_level" "level_left"
     "language" "points"]))
