{
3.- Implementar un programa que invoque a los siguientes módulos.

a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).

b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)

c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.

}

program tre;

const
    dimF= 20;

type
    rangoDim=1..dimF;
    rangoNum=300..1550;
    vec= array[rangoDim] of rangoNum;

    procedure cargarVec(var v:vec; dimL:integer);
    begin
        if (dimL <= dimF) then begin
            v[dimL]:= 300 + random(1550-300+1);
            cargarVec(v,dimL+1);
        end;
    end;

    procedure ordenarVec(var v:vec; dimL:integer);
    var 
        i, j, pos:rangoDim;
        num:rangoNum;
    begin
        for i:=1 to (dimL-1) do begin
            pos:= i;
            for j:= i+1 to dimL do
                if(v[j] < v[pos]) then pos:= j;
            
            num:= v[pos];
            v[pos]:= v[i];
            v[i]:= num;
        end;
    end;

    procedure imprimirVec(v:vec; dimL:integer);
    begin
        if (dimL <= dimF) then begin
            writeln(v[dimL]);
            imprimirVec(v,dimL+1)
        end
        else begin
            writeln('Se termino la jodita')
        end;
    end;

    procedure busquedaDicotomica (v: vec; ini,fin: integer; dato:integer; var pos: integer);
    var medio: integer;
    begin
        if (ini > fin) then 
            pos:= -1
        else begin
            medio:= (ini + fin) div 2;
            if (v[medio] = dato) then pos:= medio
            else if (dato < v[medio]) then busquedaDicotomica(v, ini, medio-1, dato, pos)
            else busquedaDicotomica(v, medio+1, fin, dato, pos);
        end;
    end;

    Procedure imprimirBusqueda(v:vec; ini,fin: integer);
    var
        num,pos: integer;
    begin
        writeln('Ingresa un valor a buscar: ');
        readln(num);

        busquedaDicotomica(v, ini, fin, num, pos);

        if (pos=-1) then
            writeln('El dato ', num, ' no se encuentra en el vector')
        else
            writeln('El dato ', num, ' se encuentra en la posicion: ', pos);
    end;

var
    v:vec;
begin
    cargarVec(v,1);
    imprimirVec(v,1);
    writeln('########');
    ordenarVec(v,dimF);
    imprimirVec(v,1);
    writeln('########');
    imprimirBusqueda(v,1,dimF);
end.
