program super;

const
    sucursales=10;
    fin=0;

type
    rangoSucursal=1..sucursales;

    venta=record
        dni:integer;
        codSucursal:rangoSucursal;
        factura:integer;
        monto:real;
    end;

    lista=^nodo;
    nodo=record
        elem:venta;
        sig:lista;
    end;

    estructura=record
        dni:integer;
        compras:lista;
    end;

    arbol= ^nodo;
    nodo= record
        elem:estructura;
        hi:arbol;
        hd:arbol;
    end;

    procedure leerInfo();

    procedure agregarAdelanteLista();

    procedure agregarArbol(var a:arbol; v:venta);
    var nue:arbol;
    begin
        if (l = nil) then begin
            new(nue);
            nue^.elem.dni:= v.dni;
            nue^.elem.compras:= v;
        end;
    end;