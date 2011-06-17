(ns com.example.controller.IndexController
    (:gen-class
        :extends org.slim3.controller.Controller
        :exposes {response {:get getResponce, :set setResponce}}
        :exposes-methods {forward forwardS, requestScope requestScopeS})
    (:import
        com.example.meta.Slim3ModelMeta,
        com.example.model.Slim3Model,
        com.example.service.Slim3Service,
        java.util.Date,
        org.slim3.datastore.Datastore))


(defn -run
    "Docstring for -run."
    [this]

    (let [res (.. this getResponce)]
        (.println (.. res getWriter) "Hello, World!")

        (Slim3Service/newAndPut (.. (Date.) toString))

        (doseq [x (Slim3Service/queryAll)]
            (.println (.. res getWriter) (.. x getProp1)))

        (.flushBuffer res)))
