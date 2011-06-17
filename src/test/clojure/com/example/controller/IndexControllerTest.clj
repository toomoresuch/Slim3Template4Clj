(ns com.example.controller.IndexControllerTest
    (:import
        com.example.controller.IndexController,
        javax.servlet.http.HttpServletResponse,
        org.slim3.tester.ControllerTester)
    (:use clojure.contrib.test-is))


(defn setup-fixtures
    "Docstring for setup-fixtures."
    [test-func]

    (def tester (ControllerTester. (.. (IndexController.) getClass)))
    (.setUp tester)
    (.start tester "/")
    (test-func)
    (.tearDown tester))
(use-fixtures :each setup-fixtures)


(deftest test-sample
    "Docstring for -run."

    (is (= (.. HttpServletResponse SC_OK) (.getStatus (.. tester response)))))
