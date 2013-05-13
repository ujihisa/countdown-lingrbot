(ns countdown.core
  (:require clj-http.client))

(defn -main [& args]
  (let [room "computer_science" msg "test" bot-verifier "bf0942db651053ad522cbbcbf39cd22d062ca7e4"]
    (let [result (clj-http.client/post
                   "http://lingr.com/api/room/say"
                   {:form-params
                    {:room room
                     :bot 'countdown
                     :text (str msg)
                     :bot_verifier bot-verifier}})]
      (prn (:body result))))
  (prn 'hello))
