## <b>Ordenacion - Seleccion y Insercion</b>

## <a><u>SELECCION:</u></a>

#### El algoritmo consta de N vueltas, donde N es la dimension logica del arreglo.

- #### <a>En la primera vuelta:</a> Recorre todo el arreglo desde inicio a fin y se guarda en que pos se encuentra el elemento mas chico del arreglo.<p>Una vez termina el recorrido se intercambia con el primer elemento.
- #### <a>En la segunda vuelta:</a> Ya sabes que en la primer posicion esta el elemento mas chico. Por lo tanto buscas a partir de la segunda posicion hasta el final, y es el mismo procedimiento de encontrarlo, guardar la pos y intercambiarlo.
- #### Esto se repite hasta recorrer todo el arreglo, dando el total de N vueltas. N seria la dimension logica - 1, porque el ultimo elemento se ubicaria en la ultima vuelta.

#### Viendolo en codigo:

````pas
Procedure seleccion ( var v:vectorEnteros; dimL:integer);

var i, j, pos:integer; item:integer;	
		
begin
 for i:=1 to (dimL-1) do begin {busca el mínimo y guarda en pos la posición}
          pos := i;
          for j := i+1 to dimL do
             if v[j] < v[pos] then pos:=j;

         {intercambia v[i] y v[p]}
         item := v[pos];   
         v[pos] := v[i];   
         v[i] := item;
      end;
end;
````

## <a><u>INSERCION:</u></a>

#### Este algoritmo tambien consta de N vueltas, donde N es la dimension logica del arreglo.<p>La idea de este algoritmo es ir considerando subconjuntos de datos del vector e ir ordenandolos.

- #### <a>En la primera vuelta:</a> Se trabaja el subconjunto formado unicamente por el primer elemento del arreglo, que lo consideramos como ordenado.
- #### <a>En la segunda vuelta:</a> Se trabaja el subconjunto formado por el primer y segundo elemento del arreglo y se ordena ese subconjunto de manera de encontrar en que posicion debe estar el segundo elemento para que el arreglo siga ordenado.
- #### <a>En la tercera vuelta:</a> Lo mismo aca, trabajas con el primero, segundo y tercero. Y buscas en que posicion deberia de estar el tercer elemento, sabiendo que el primero y el segundo estan ordenados.
- #### Esto se repite hasta recorrer todo el arreglo, dando asi un total de N vueltas.

#### Viendolo en codigo:

````pas
Procedure insercion ( var v:vectorEnteros; dimL:indice );
Var
 i, j: indice; actual: integer;		
begin
 for i:=2 to dimL do begin 
     actual:= v[i];
     j:= i-1; 
     while (j>0) y (v[j]>actual) do      
       begin
         v[j+1]:= v[j];
         j:= j – 1;                  
       end;  
     v[j+1]:= actual; 
 end;
end;
````