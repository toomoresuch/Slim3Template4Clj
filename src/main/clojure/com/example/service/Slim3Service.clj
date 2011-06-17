(ns com.example.service.Slim3Service
    (:gen-class
        :methods [
                     #^{:static true} [newAndPut [String] void],
                     #^{:static true} [queryAll [] java.util.List]])
    (:import
        com.example.meta.Slim3ModelMeta,
        com.example.model.Slim3Model,
        com.google.appengine.api.datastore.Key,
        java.util.List,
        org.slim3.datastore.Datastore))


(defn -newAndPut
    "Docstring for new-and-put [prop1]."
    [prop1]

    (let [model (Slim3Model.)]
        (.setProp1 model prop1)
        (let [key (Datastore/put model)]
            (.setKey model key))))

(defn -queryAll
    "Docstring for queryAll."
    []

    (.. (Datastore/query (Slim3ModelMeta/get)) asList))

