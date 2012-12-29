(def point {:x 1, :y 2, :__class_symbol__ 'Point})

(def Point
     (fn [x y]
       {:x x,
        :y y
        :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class-of :__class_symbol__)

(def shift
     (fn [this xinc yinc]
       (Point (+ (x this) xinc)
              (+ (y this) yinc))))

(def Triangle
     (fn [point1 point2 point3]
       {:point1 point1, :point2 point2, :point3 point3
        :__class_symbol__ 'Triangle}))


(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))

;Exercise 1
(defn add [p1 p2]
    (Point (+ (:x p1) (:x p2))
           (+ (:y p1) (:y p2))))
(defn add-shift [p1 p2]
    (shift p1 (:x p2) (:y p2)))

(def pa (Point 2 5))
(def pb (Point 3 8))

(println (add pa pb))
(println (add-shift pa pb))

;Excercise 2
(defn make [class & args]
    (apply class args))

(println (make Point 1 2))

(println (make Triangle (make Point 1 2)
                        (make Point 1 3)
                        (make Point 3 1)))

;Exercise 3
(defn equal-points? [p1 p2]
    (= p1 p2))

(defn equal-triangles? [t1 t2]
    (and
        (equal-points?
            (:point1 t1) (:point1 t2))
        (equal-points?
            (:point2 t1) (:point2 t2))
        (equal-points?
            (:point3 t1) (:point3 t2))))

(println (equal-triangles? right-triangle right-triangle))
(println (equal-triangles? right-triangle equal-right-triangle))
(println (equal-triangles? right-triangle different-triangle))
