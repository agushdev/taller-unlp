{
Una biblioteca necesita un sistema para procesar la información de los libros. 
De cada libro se conoce: ISBN, anio de edición, código del autor y código de género (1 a 15).

a) Implementar un módulo que lea información de los libros y retorne una estructura de datos 
eficiente para la búsqueda por código de autor que contenga código de autor y una lista de todos sus libros. 
La lectura finaliza al ingresar el valor 0 para un ISBN.

b) Realizar un módulo que reciba la estructura generada en el inciso a) y un código. 
El módulo debe retornar una lista con código de autor y su cantidad de libros, para cada autor con código superior al código ingresado.

c) Realizar un módulo recursivo que reciba la estructura generada en inciso b) 
y retorne cantidad y código de autor con mayor cantidad de libros.

NOTA: Implementar el programa principal, que invoque a los incisos a, b y c. En caso de ser necesario, puede utilizar los módulos que se encuentran a continuación.
}

program biblioteca;

const
    generos=15;
    fin=0;

type
    rangoGenero=1..generos;

    libro=record
        isbn:integer;
        anio:integer;
        codAutor:integer;
        codGenero:rangoGenero;
    end;
    lista=^nodoLista;
    nodoLista=record
        elem:libro;
        sig:lista;
    end;


    estructura=record
        codAutor:integer;
        libros: lista;
    end;

    arbol=^nodoArbol;
    nodoArbol= record
        elem:estructura;
        hi:arbol;
        hd:arbol;
    end;

    listaB= ^nodoB;
    nodoB= record
        codAutor:integer;
        cantLibros:integer;
        sig:listaB;
    end;


    procedure leerLibro(var l:libro);
    begin
        l.isbn:= random(9999);
        if l.isbn <> fin then begin
            l.anio:= random(25) + 2020;
            l.codAutor:= random(6)+1;
            l.codGenero:= random(15);
        end;
    end;

    procedure agregarAdelante(var lis:lista; l:libro);
    var nue:lista;
    begin
        new(nue);
        nue^.elem:= l;
        nue^.sig:= lis;
        lis:= nue;
    end;

    procedure agregar(var a:arbol; l:libro);
    var nue:arbol;
    begin
        if (a = nil) then begin
            new(nue);
            
            nue^.elem.codAutor:= l.codAutor;
            nue^.elem.libros:= nil;
            agregarAdelante(nue^.elem.libros, l);

            nue^.hi:= nil;
            nue^.hd:= nil;
            a:= nue;
        end

        else if l.codAutor < a^.elem.codAutor then agregar(a^.hi,l)
        else if l.codAutor > a^.elem.codAutor then agregar(a^.hd,l)
        else agregarAdelante(a^.elem.libros, l);
    end;

    procedure cargar(var a:arbol);
    var l:libro;
    begin
        leerLibro(l);
        if (l.isbn <> fin) then begin
            agregar(a,l);
            cargar(a);
        end;
    end;

    // b) Realizar un módulo que reciba la estructura generada en el inciso a) y un código. 
    // El módulo debe retornar una lista con código de autor y su cantidad de libros, para cada autor con código superior al código ingresado.

    function retornarCantLibros(l:lista):integer;
    var contador:integer;
    begin
        contador:=0;
        while (l <> nil) do begin
            contador:= contador + 1;
            l:= l^.sig;
        end;
        retornarCantLibros:= contador;
    end;

    procedure agregarAlFinal(var l: listaB; cod: integer; cant: integer);
    var
        nue, actual: listaB;
    begin
        new(nue);
        nue^.codAutor := cod;
        nue^.cantLibros := cant;
        nue^.sig := nil;

        if l = nil then
            l := nue
        else
        begin
            actual := l;
            while actual^.sig <> nil do
                actual := actual^.sig;
            actual^.sig := nue;
        end;
    end;

    procedure retornarLibrosPorAutor(a:arbol; codLimite:integer; var l:listaB);
    begin
		if (a <> nil) then begin
			retornarLibrosPorAutor(a^.hi, codLimite, l); 
			if a^.elem.codAutor > codLimite then 
                agregarAlFinal(l,a^.elem.codAutor, retornarCantLibros(a^.elem.libros));
			retornarLibrosPorAutor(a^.hd, codLimite, l);
        end;
    end;

    function retornarLista(a:arbol; cod:integer):listaB;
    var l:listaB;
    begin
        l:=nil;
        retornarLibrosPorAutor(a,cod,l);
        retornarLista:= l;
    end;

var
    ar:arbol;
begin
    randomize;
    ar:= nil;
    cargar(ar);
    retornarLista(ar,5);
end.
