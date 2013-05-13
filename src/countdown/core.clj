(ns countdown.core
  (:require clj-http.client)
  (:require clj-time.core)
  (:require clj-time.format)
  (:require clj-time.local))

(def built-in-formatter (clj-time.format/formatters :basic-date-time))

(defn help []
  (prn "server or cmd"))

(defn -main [& args]
  (case (first args)
    "server" (prn 'cool)
    "cmd" (do
            (prn (clj-time.format/parse built-in-formatter "20130603T000000.000Z"))
            (prn (clj-time.format/unparse built-in-formatter (clj-time.local/local-now)))
            #_(let [room "computer_science" msg "test" bot-verifier "bf0942db651053ad522cbbcbf39cd22d062ca7e4"]
              (let [result (clj-http.client/post
                             "http://lingr.com/api/room/say"
                             {:form-params
                              {:room room
                               :bot 'countdown
                               :text (str msg)
                               :bot_verifier bot-verifier}})]
                (prn (:body result))))
            (prn 'hello))
    "help" (help)
    "-h" (help)
    (help)))
