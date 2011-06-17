(ns com.example.service.Slim3ServiceTest
    (:import
        com.example.service.Slim3Service,
        org.slim3.tester.AppEngineTester)
    (:use clojure.contrib.test-is))


(defn setup-fixtures
    "Docstring for setup-fixtures."
    [test-func]

    (def tester (AppEngineTester.))
    (.setUp tester)
    (test-func)
    (.tearDown tester))
(use-fixtures :each setup-fixtures)


(deftest test-sample
    "Docstring for -run."

    (Slim3Service/newAndPut "abc")
    (is (= 1 (.. (Slim3Service/queryAll) size))))
