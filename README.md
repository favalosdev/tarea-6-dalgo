# tarea-6-dalgo

Trabajo realizado por Fernando Ávalos y Daniel Perilla Ocampo.

## *Parte 1*
La ejecución de la primera parte precisa de pasar argumentos por la línea de comandos. Se puede escoger entre tres algoritmos Dijkstra, BellmanFord y FloydWarshall y tres tipos de datos distintos, a los cuales les corresponden los carácteres s, m, b (small, medium, big). El primer argumento es el nombre del algoritmo a utilizar y el segundo es el carácter empleado. Ejemplos de entradas válidas serían FloydWarshall s o BellmanFord b.

Adjuntamos los tiempos de ejecución.

|        | Floyd-Warshall | Bellman-Ford   | Dijkstra |
|--------|----------------|----------------|----------|
| Small  | 2              | 8              | 10       |
| Medium | 60             | 862            | 127      |
| Big    | 126620         | No dió salida. | 88584    |

Las magnitudes están dadas en milisegundos. 

## *Parte 2*
Abrir el paquete .bfs y ejecutar la clase main. Se puede cambiar el grafo a cargar. Incluimos un grafo por defecto; el mismo estaba en el enunciado
de la tarea.

## *Parte 3*
Abrir el paquete .dfs y ejecutar la clase main. Se puede cambiar el grafo a cargar. Hay dos maneras de probar el algoritmo. La primera es pasando como primer argumento "top", en cuyo caso se cargará el grafo descrito en la imagen y se reportará el orden topológico. La siguiente opción consiste en cargar un grafo con ciclos para demostrar la capacidad del algoritmo de detectarlos.

![Markdown Image](https://media.geeksforgeeks.org/wp-content/cdn-uploads/graph.png)
