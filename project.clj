(defproject predicates "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:dependencies [[midje "1.4.0"]
                                  [com.stuartsierra/lazytest "1.2.3"]]
                   :plugins [[lein-midje "2.0.0-SNAPSHOT"]]}}
  :repositories {"stuart" "http://stuartsierra.com/maven2"}
  :url "http://example.com/FIXME")
