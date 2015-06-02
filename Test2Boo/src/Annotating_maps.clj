(ns  Annotating-maps)

(def answer-annotations
     (fn [courses registrants-courses]
       (let [checking-set (set registrants-courses)]
         (map (fn [course]
                (assoc course
                       :spaces-left (- (:limit course)
                                       (:registered course))
                       :already-in? (contains? checking-set
                                               (:course-name course))))
              courses))))