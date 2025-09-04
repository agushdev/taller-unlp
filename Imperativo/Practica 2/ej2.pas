{
2.- Escribir un programa que:

a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.

b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.

c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.

d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.

e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.

}

program recursion;

type
    rango= 100..200;

    lista= ^nodo;
    nodo= record
        elem: integer;
        sig: lista;
    end;

	procedure agregarAdelante(var l:lista; elem:integer);
        var nue:lista;
        begin
            new(nue);
            nue^.elem:= elem;
            nue^.sig:= l;
            l:= nue;
        end;

    procedure cargarLista(var l:lista);
    var num:rango;
    begin
        num:= 100 + random(200-100+1);
        if (num <> 100) then begin
            agregarAdelante(l, num);
            cargarLista(l);
        end;
    end;

    procedure imprimirOrden(l: lista);
    begin
        if (l <> nil) then begin
            writeln(l^.elem);
            imprimirOrden(l^.sig);
        end;
    end;

    procedure imprimirOrdenInverso(l:lista);
    begin
        if (l <> nil) then begin
            imprimirOrdenInverso(l^.sig);
            writeln(l^.elem);
        end;
    end;

    function minimo(l:lista; min:integer):integer;
    begin
        if (l = nil) then minimo:= min
        else begin
            if (l^.elem < min) then min:= l^.elem;
            minimo:= minimo(l^.sig,min);
        end;
    end;

    function maximo(l:lista; max:integer):integer;
    begin
        if (l = nil) then maximo:= max
        else begin
            if (l^.elem > max) then max:= l^.elem;
            maximo:= maximo(l^.sig,max);
        end;
    end;

    procedure imprimirMaxMin(l: lista);
    var min,max: integer;
    begin
        max:= -9999;
        min:= 9999;
        writeln('El minimo es: ', minimo(l,min));
        writeln('###########');
        writeln('El maximo es: ', maximo(l,max));
    end;

    function buscar(l:lista; valor:integer):boolean;
    begin
        if (l=nil)then buscar:= false
        else begin
            if (l^.elem= valor) then buscar:= true
            else buscar:= buscar(l^.sig,valor);
        end;
    end;

    procedure informarBusqueda(l:lista);
    var
        encontrado: boolean;
        num: integer;
    begin
        writeln('Ingresa num a buscar: ');
        readln(num);
        encontrado:= buscar(l,num);
        if (encontrado=true) then writeln ('Se encontro el num: ',num)
        else writeln ('No se encontro el num: ',num);
    end;

var
    l:lista;
begin
    randomize;
    cargarLista(l);
    writeln('Orden normal: ');
    imprimirOrden(l);
    writeln('###########');
    writeln('Orden inverso: ');
    imprimirOrdenInverso(l);
    writeln('###########');
    imprimirMaxMin(l);
    writeln('###########');
    informarBusqueda(l);
end.
