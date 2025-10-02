{
2. Escribir un programa que:

a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:

    i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
    producto. Los códigos repetidos van a la derecha.

    ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
    código de producto. Cada nodo del árbol debe contener el código de producto y la
    cantidad total de unidades vendidas.

    iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
    código de producto. Cada nodo del árbol debe contener el código de producto y la lista de
    las ventas realizadas del producto.

    Nota: El módulo debe retornar TRES árboles.

b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad
total de productos vendidos en la fecha recibida.

c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.

d. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto
con mayor cantidad de ventas.
}

program arbolito;

type
    tiempo= record
        anio:integer;
        mes:integer;
        dia:integer;
    end;

    venta= record
        cod: integer;
        fecha:tiempo;
        cantVendido:integer;
    end;

    arbol= ^nodo;
    nodo= record
        elem: venta;
        HI: arbol;
        HD: arbol;
    end;

    procedure leerVenta(var v:venta);
    begin
        v.cod:= random(201);
        if (v.cod <> 0)then begin
            v.fecha.anio:= 2000 + random(2025-2000+1);
            v.fecha.mes:= random(12) + 1;
            v.fecha.dia:= random(31) + 1;
            v.cantVendido:= random(100) + 1;
        end;
    end;

    procedure agregar(var a:arbol; v:venta);
    begin
        if (a=nil) then begin
            new(a);
            a^.elem:= v;
            a^.HI:= nil;
            a^.HD:= nil;
        end
        else if ( v.cod < a^.elem.cod) then agregar(a^.HI,v)
        else agregar(a^.HD,v);
    end;

    procedure cargarArbol(var a:arbol);
    var v:venta;
    begin
        leerVenta(v);
        if (v.cod <> 0) then begin
            agregar(a,v);
            cargarArbol(a);
        end;
    end;

    procedure imprimirEnOrden(a:arbol);
    begin
        if (a <> nil) then begin
            imprimirEnOrden(a^.HI);
            writeln('Cod: ', a^.elem.cod, ', Cantidad: ', a^.elem.cantVendido);
            imprimirEnOrden(a^.HD);
        end;
    end;

var a:arbol;
begin
    randomize;
    a:=nil;
    cargarArbol(a);
    writeln('--- Arbol generado (En Orden) ---');
    imprimirEnOrden(a);
end.
