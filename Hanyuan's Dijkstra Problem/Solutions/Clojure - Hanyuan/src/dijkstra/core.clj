(ns dijkstra.core
  (:gen-class)) 

; Dijkstra's pathfinding algorithm

; Insert element into an array
(defn insert [item array ind]
  (vec
    (concat
      (subvec array 0 (inc ind))
      [item]
      (subvec array (inc ind)))))

; Finds all arrays with starting point of [element]
(defn find-arrays [paths element]
  ; element => [node cost previous-nodes]
  (loop [ind 0
         links []]
    (if (= ind (count paths)) links
      (let [current-path (nth paths ind)]
        (recur
            (inc ind)
            (if
              (some #{(first element)}
                (vec (butlast current-path)))
              (conj links
                [(if (= (first current-path) (first element))
                   (nth current-path 1)
                   (first current-path))
                 (+ (nth current-path 2) (second element))
                 (conj (nth element 2) (first element))])
              links))))))

; Places an element onto the stack
(defn place-element [stack element]
  (loop [ind 0]
    (if (= ind (count stack))
      (loop [new-ind 0]
        (if (= new-ind (count stack))
          (conj stack element)
          (if (>= (second element) (second (nth stack new-ind)))
            (insert element stack new-ind)
            (recur (inc new-ind)))))
      (if (= (first element) (first (nth stack ind)))
        (if (< (second element) (second (nth stack ind)))
          (assoc stack ind element) stack)
        (recur (inc ind))))))

; Full Dijkstra algorithm
(defn dijkstra [paths start end]
  (loop [stack [[start 0 []]]]
    (if (= (first (first stack)) end)
      (last (first stack)) 
      (recur
        (let [found-paths (find-arrays paths (first stack))]
          (loop [ind 0
                 new-stack (vec (rest stack))]
            (if (= ind (count found-paths)) new-stack
              (recur
                (inc ind)
                (place-element new-stack (nth found-paths ind))))))))))

(defn -main [& args]
  (println
    (dijkstra
      [[0 1 5] [0 3 7] [1 2 2] [1 3 6] [2 3 3] [2 4 4] [3 5 4]]
      0 4)))
