(ns test-mate.core
  (:require [test-mate.analysis.analysis-core :as analysis]
            [cover.parse :as cover]
            [test-mate.statistic-server.push-data :as statistic-server]
            [test-mate.cmd :as cmd])
  (:gen-class))

(defn -main [& main-args]
  (let [command (first main-args)
        args (rest main-args)]
    (cond (= command "aggregate") (println "aggregate: " (cover/aggregate (first args) (rest args)))
          (= command "analysis") (analysis/analysis args)
          (= command "statistic-server") (statistic-server/push-data args)
          :else (cmd/exit-with-usage (str "Unknown command:" command) command))))
