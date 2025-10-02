{Implementar un programa modularizado para una librería. Implementar módulos para:

a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.

b. Imprimir el contenido del árbol ordenado por código de producto.

c. Retornar el código de producto con mayor cantidad de unidades vendidas.

d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.

e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros.
}

program a;

const
    fin= -1;

type
    producto= record
        cod:integer;
        cantVendidos:integer;
        montoTotal:integer;
    end;

    venta= record
        codVenta:integer;
        codProducto:integer;
        cantVendidos:integer;
        precio:integer;
    end;

    arbol= ^nodo;
    nodo= record
        elem:producto;
        hi:arbol;
        hd:arbol;
    end;

{a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.}

    procedure leer(var v:venta);
    begin
        writeln('Ingresa codigo de venta (-1 finaliza)');
        readln(v.codVenta);
        if (v.codVenta <> fin) then begin
            v.codProducto:= random(100);
            v.cantVendidos:= random(10);
            v.precio:= random(1000);
        end;
    end;

    procedure agregar(var a:arbol; v:venta);
    begin
        if (a = nil) then begin
            new(a);
            a^.elem.cod := v.codProducto;
            a^.elem.cantVendidos := v.cantVendidos;
            a^.elem.montoTotal := v.precio * v.cantVendidos;
            a^.hi:= nil;
            a^.hd:= nil;
        end
        else if v.codProducto = a^.elem.cod then begin
            a^.elem.cantVendidos := a^.elem.cantVendidos + v.cantVendidos;
            a^.elem.montoTotal := a^.elem.montoTotal + (v.precio * v.cantVendidos);
        end
        else if v.codProducto < a^.elem.cod then agregar(a^.hi, v)
        else agregar(a^.hd, v);
    end;

    procedure cargar(var a:arbol);
    var
        v:venta;
    begin
        leer(v);
        if (v.codVenta <> fin) then begin
            agregar(a,v);
            cargar(a);
        end;
    end;

{b. Imprimir el contenido del árbol ordenado por código de producto.}

    procedure imprimir(a:arbol);
    begin
        if (a<>nil) then begin
            imprimir(a^.hi);
            writeln('Cod produ: ', a^.elem.cod);
            writeln('Cantidad de unidades vendidas: ', a^.elem.cantVendidos);
            writeln('Monto total: ', a^.elem.montoTotal);
            imprimir(a^.hd);
        end;
    end;

var
    ar:arbol;
begin
    ar:= nil;
    randomize;
    cargar(ar);
    imprimir(ar);
end.
